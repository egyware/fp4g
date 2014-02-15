/**
 * 
 */
package fp4g.parser;


import java.util.Collection;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.classes.MessageMethod;
import fp4g.classes.MessageMethods;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.ILine;
import fp4g.data.IValue;
import fp4g.data.Instance;
import fp4g.data.NameList;
import fp4g.data.On;
import fp4g.data.Statements;
import fp4g.data.VarType;
import fp4g.data.define.Asset;
import fp4g.data.define.Behavior;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Manager;
import fp4g.data.define.Message;
import fp4g.data.define.NotAllowedException;
import fp4g.data.expresion.CustomClassMap;
import fp4g.data.expresion.literals.StringLiteral;
import fp4g.data.statements.Destroy;
import fp4g.data.statements.Filter;
import fp4g.data.statements.OrFilters;
import fp4g.data.statements.Send;
import fp4g.data.statements.Source;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.Log;
import fp4g.log.info.Error;
import fp4g.log.info.GeneratorError;
import fp4g.log.info.NotAllowed;
import fp4g.log.info.Warn;


/**
 * Visita el arbol construido.
 * @author Edgardo
 */
public class FP4GDataVisitor extends FP4GBaseVisitor<ILine>
{
	private final Game game;
	private MessageMethods methods;
	private final Stack<IDefine> current;
	private NameList nameList;
	private Statements statements;
	private final FP4GExpresionVisitor exprVisitor;
	public FP4GDataVisitor(final Game game)
	{
		this.game = game;		
		current = new Stack<IDefine>();		
		exprVisitor = new FP4GExpresionVisitor(current);
		try
		{
			CustomClassMap map = ((CustomClassMap)game.get("methods"));
			methods = (MessageMethods)map.getValue();
		}
		catch(NullPointerException e)
		{
			throw new FP4GRuntimeException(Error.MessageMethodNotFound,"Los metodos para los mensajes no se encontrarón",e);
		}
	}
	
	
	
	@Override
	public ILine visitUsing(FP4GParser.UsingContext ctx)
	{	
		switch(ctx.type)
		{		
		case BEHAVIOR:
			Behavior behavior = new Behavior(ctx.name.getText(),game);
			behavior.setBuild(false);
			game.setDefine(behavior);
			break;
		case ENTITY:
			Entity entity = new Entity(ctx.name.getText(),game);
			entity.setBuild(false);
			game.setDefine(entity);
			break;
		case GOAL:
			//TODO por hacer...
//			Behavior behavior = new Behavior(ctx.name.getText());
//			behavior.setBuild(false);
//			game.setDefine(behavior);
			break;
		case MANAGER:
			//TODO por hacer...
			break;
		case MESSAGE:
			//TODO por hacer..
			break;
		case STATE:
			GameState state = new GameState(ctx.name.getText(),game);
			state.setBuild(false);
			game.setDefine(state);			
			break;
		case GAME:			
		default:			
			throw new FP4GRuntimeException(GeneratorError.IllegalState,"Se esperaba que se use un tipo valido. agrego un define nuevo?");					
		}
		return null;		
	}
	
	@Override
	public ILine visitStart(FP4GParser.StartContext ctx)
	{
		IDefine define = current.peek();
		
		if(define instanceof Game)
		{
			final String stateName = ctx.state;			
			GameState state;
			try 
			{
				state = define.getDefine(DefineType.STATE, stateName);
			} 
			catch (DefineNotFoundException e) 
			{				
				Log.Exception(e, ctx.start.getLine());
				//creo un elemento temporal para solucionar el state faltante, sin embargo no se generará
				state = new GameState(ctx.state,define);
				state.setLine(ctx.start.getLine());
				state.setBuild(false);
			}			
			((Game) define).setStart(state);
			return state;
		}
		else
		{
			return null;
		}				
	}
	
	@Override
	public ILine visitOn(FP4GParser.OnContext ctx)
	{
		IDefine parent = current.peek();
		
		//en vez de solo crearlo, tengo que buscarlo... y si no existe crearlo.
		On on = parent.getOn(ctx.messageName);
		if(on == null)
		{	
			//es message, cast seguro
			Message message = null;
			try
			{
				message = parent.getDefine(DefineType.MESSAGE,ctx.messageName);				
				on = new On(message);
			}
			catch (DefineNotFoundException e) 
			{
				Log.Exception(e, ctx.start.getLine());
				on = new On(ctx.messageName);
			}
			
			//solo si es nuevito, se agrega
			parent.setOn(on);
		}
		
		visit(ctx.statements);
		//al evento on, se crea un nuevo codigo y se le añaden los filtros, si es que existen.
		//falta solo agregarle el codigo :)
		Source source = on.addSource(statements);
		statements = null;
		if(ctx.filters != null)
		{		
			try
			{
				ctx.filters.orFilters = source.filters;
				ctx.filters.message   = on.message;
				visit(ctx.filters);				
			}
			catch(FP4GRuntimeException e)
			{
				//Error, acá tratamos de ahcer el mejor esfuerzo posible.
				Log.Exception(e,ctx.start.getLine());
			}

		}		
		
		return null;		
	}
	
	@Override 
	//Corresponde al O
	public ILine visitOnFilters(FP4GParser.OnFiltersContext ctx)
	{
		//utilizamos el de source.
		OrFilters or = ctx.orFilters;
		
		if(ctx.children != null)
		{
			for(ParseTree c:ctx.children)
			{
				if(c instanceof FP4GParser.FilterContext)
				{
					((FP4GParser.FilterContext) c).message = ctx.message;				
					Filter code = (Filter)visit(c);
					if(code != null)
					{
						or.addAnd(code);
					}
				}
			}		
		}
		
		return or;		
	}
	
	@Override 
	public ILine visitFilter(FP4GParser.FilterContext ctx)
	{
		//tendrá eso?
		ExprList list = exprVisitor.getExprList(ctx.exprList());
		Message message = ctx.message;
		MessageMethod method = null;
		if(message != null)
		{
			method = message.getMessageMethod(ctx.filterName);
		}	
		if(method == null)
		{
			throw new FP4GRuntimeException(Error.FilterMethodMissing,"No se encontró un metodo para el filtro:  ".concat(ctx.filterName));
		}
		
		Filter filter = new Filter(method,list);
		
		return filter;		
	}
	
	

	@Override
	public ILine visitOnStatements(FP4GParser.OnStatementsContext ctx)
	{
		statements = new Statements();
		//TODO talvez deberia usar aggregateResult
		if(ctx.children != null)
		{
			for(ParseTree c:ctx.children)
			{
				ILine code = visit(c);
				if(code != null)
				{
					statements.add(code);
				}
			}		
		}
		return statements;		
	}
	
	
	@Override
	public ILine visitDestroy(FP4GParser.DestroyContext ctx)
	{
		Destroy destroy = new Destroy(Instance.Self);
		return destroy;
	}
	
	@Override
	public ILine visitSend(FP4GParser.SendContext ctx)
	{
		Define define = (Define)current.peek();
		
		MessageMethod method = methods.getMessageMethod(ctx.messageMethodName);
		if(method == null)
		{
			throw new FP4GRuntimeException(Error.FilterMethodMissing,"No se encontró un metodo para el filtro:  ".concat(ctx.messageMethodName));
		}
		Send.SendTo type = null;
		String receiver = null;
		//Busqueda de quien envia mensaje.
		//1.- Game
		//2.- Self
		//3.- Other
		//4.- Componente
		//5.- Tag
		//6.- Sistema
		type = (ctx.receiverType == null)?Send.SendTo.Behavior:ctx.receiverType;
		
		
		Send send = null;
		switch(type)
		{		
		case Game:			
		case Other:			
		case Self:
			send = new Send(type,method,receiver);
			break;
		default:
			receiver = ctx.receiverName;
		//Behavior
			//buscar en los add de la entidad.
			List<Add> behaviors = define.getAdd(DefineType.BEHAVIOR);
			for(Add bhvr:behaviors)
			{
				//buscar de forma iterativa
				if((bhvr.varName != null && bhvr.equals(receiver))||bhvr.name.equals(receiver))
				{
					type = Send.SendTo.Behavior; //Es un behavior!
					send = new Send(type,method,receiver);
					break;
				}
			}
	    //Tag
			//buscar algún tag, si es que existe
			
	    //System
			
			//buscar en los defines de sistemas.
			Collection<IDefine> managers = game.getDefines(DefineType.MANAGER);
			for(IDefine manager:managers)
			{
				if(manager.getName().equals(receiver))
				{
					if(((Manager)manager).isReceiver())
					{
						type = Send.SendTo.System; //es un sistema!, ojo que el sistema puede que no esté definido...
						send = new Send(type,method,(Manager)manager);
					}
					else
					{
						//lanzar error						
						throw new FP4GRuntimeException(Error.ManagerIsNotAReceiver,String.format("El manager \"%s\" no puede recibir mensajes.",receiver));							 
					}
					break;
				}
			}					
		
			break;		
		}		
		
		ExprList list = exprVisitor.getExprList(ctx.exprList());
		if(list != null)
		{		
			//TODO checkar la exprList, checkar que?, Compararla contra MessageMethod.Params se requiere conocimiento adicional.
			send.setArguments(list);		
		}
		
		
		return send;		
	}
	
	@Override 
	public ILine visitSet(FP4GParser.SetContext ctx)
	{
		IDefine define = current.peek();
		
		Expresion expr = exprVisitor.visit(ctx.expr());		
		try {
			define.set(ctx.key, eval(define,expr));
		} catch (CannotEvalException e) {			
			Log.Show(Warn.CannotEvalExpr,ctx.getStart().getLine(),expr.toString());
		}
		return null;
	}
	
	public static IValue<?> eval(IValue<?> define, Expresion expr) 
	throws CannotEvalException 
	{
		return expr.eval(define);
	}

	@Override
	public ILine visitGame(FP4GParser.GameContext ctx)
	{
		game.name = ctx.name;
		game.setLine(ctx.getStart().getLine());
		return super.visitGame(ctx);		
	}
	
	@Override
	public ILine visitGameValues(FP4GParser.GameValuesContext ctx)
	{
		current.push(game);		
		super.visitGameValues(ctx);		
		current.pop();
		return null;
	}	
	
	@Override
	public ILine visitDefineValues(FP4GParser.DefineValuesContext ctx)
	{
		FP4GParser.DefineContext define_ctx = (FP4GParser.DefineContext)ctx.parent;
		IDefine parent = current.peek();
		String defName = define_ctx.defName;
		
		Define define = null;		
		switch(define_ctx.type)
		{
			case STATE:
				define = new GameState(defName,parent);	
			break;
			case ENTITY:
				define = new Entity(defName,parent);
			break;
			case MANAGER:
				//TODO: No implementado aún
				throw new NotAllowedException(NotAllowed.NotImplementedYet, define, "No se ha implementado esta caracteristica todavía");
				//break;		  		
		  	case BEHAVIOR:
		  		//TODO: No implementado aún
				throw new NotAllowedException(NotAllowed.NotImplementedYet, define, "No se ha implementado esta caracteristica todavía");
		  		//break;		  		
		  	case GOAL:
		  		//TODO: No implementado aún
				throw new NotAllowedException(NotAllowed.NotImplementedYet, define, "No se ha implementado esta caracteristica todavía");
		  		//break;
		  	case MESSAGE:
		  		define = new Message(defName,parent);		  		
		  		break;
		  	case ASSET:
		  		Asset.Type type = Asset.Type.valueOf(defName);
		  		define = new Asset(type,parent);
		  		break;
		  	default:
		  		throw new FP4GRuntimeException(GeneratorError.IllegalState,"Se esperaba que se use un tipo valido. agrego un define nuevo?");
		 }
		define.setLine(define_ctx.getStart().getLine());
		parent.setDefine(define);
				  
		current.push(define);		
		super.visitDefineValues(ctx);
		current.pop();
		
		if(nameList != null)
		{
			define.setNameList(nameList);
			nameList = null;
		}
		
		return null;		
	}	
	
	@Override
	public ILine visitAdd(FP4GParser.AddContext ctx)
	{
		IDefine parent = current.peek();
		
		Add add;
		//buscar el define que estoy agregando
		try 
		{
			IDefine  define = parent.getDefine(ctx.type,ctx.addName);
			add = new Add((Define)define, ctx.varName);
			add.setLine(ctx.start.getLine());
		}
		catch (DefineNotFoundException e) 
		{			
			add = new Add(ctx.type,ctx.addName,ctx.varName);
			add.setLine(ctx.start.getLine());
			Log.Exception(e, ctx.start.getLine());		
		}
		
		ExprList list = exprVisitor.getExprList(ctx.exprList());
		if(list != null)
		{		
			add.addParams(list);					
		}				
		
		parent.setAdd(add);		
		
		return add; 		
	}
	
	
	@Override
	public ILine visitNameList(FP4GParser.NameListContext ctx)
	{
		nameList = new NameList();
		super.visitNameList(ctx);
	
		return null;		
	}
	
	@Override 
	public ILine visitDeclareVar(FP4GParser.DeclareVarContext ctx)
	{
		final VarType type = ctx.varType().type;
		if(ctx.initValue != null)
		{			
			try
			{
				Expresion initValue = exprVisitor.visit(ctx.initValue);
				nameList.add(type, ctx.varName.getText(),eval(current.peek(),initValue));
			}
			catch (CannotEvalException e) 
			{
				Log.Exception(e,ctx.start.getLine());
			}
		}
		else
		{
			nameList.add(type, ctx.varName.getText());
		}
		return null;		
	}
		
	
	
	@Override
	public ILine visitAssets(FP4GParser.AssetsContext ctx) 
	{
//		Assets assets = new Assets();		
//		assets_stack.push(assets);
		visitChildren(ctx);
//		assets_stack.pop();
//		
//		Define parent = current.peek();
//		parent.setAssets(assets);
		return null;
	}
	
	@Override
	public ILine visitAssetValueInner(FP4GParser.AssetValueInnerContext ctx)
	{
//TODO por hacer		
//		Assets parent = assets_stack.peek();
//		AssetType type = ctx.assetType().type;		
//		String name = (ctx.assetName != null)? ctx.assetName.getText(): null;
//		String assetFile = ctx.asset.getText();
//		parent.add(type,name,assetFile);
		return null;
	}
	
	@Override
	public ILine visitAssetValue(FP4GParser.AssetValueContext ctx)
	{
		IDefine parent = current.peek();	

		//spaceship = ADD ASSET Texture({name="spacheship",atlas = assets_group_1})
		
		String varName  = (ctx.assetName != null)?ctx.assetName.getText():null;
		String assetFile = ctx.asset.getText(); //TODO hay que evualuar esto más adelante
		assetFile = assetFile.substring(1, assetFile.length()-1);
		Asset.Type assetType = Asset.Type.valueOf(ctx.assetType.getText());
		
		Add assetAdd;		
		if(varName == null)
		{
			try 
			{
				Define define = parent.getDefine(DefineType.ASSET,assetType.name());
				assetAdd = new Add(define,assetType.name());
			}
			catch (DefineNotFoundException e)
			{
				assetAdd = new Add(DefineType.ASSET,assetType.name());
				Log.Exception(e, ctx.assetName.getLine());
			}
		}
		else
		{
			try 
			{
				Define define = parent.getDefine(DefineType.ASSET,assetType.name());
				assetAdd = new Add(define, varName);				
			}
			catch (DefineNotFoundException e)
			{
				assetAdd = new Add(DefineType.ASSET,assetType.name(),varName);
				Log.Exception(e, ctx.assetName.getLine());
			}
			assetAdd.setLine(ctx.start.getLine());
			
		}
		ExprList paramsList = new ExprList(1);
		//TODO soportar muchas opciones
		paramsList.add(new StringLiteral(assetFile));
		
		assetAdd.addParams(paramsList);		
		parent.setAdd(assetAdd);
		
		if(ctx.innerAssetValues != null)
		{	
			//TODO más opciones...
		}
		
		return null;		
	}
}
