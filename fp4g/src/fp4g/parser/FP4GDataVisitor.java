package fp4g.parser;


import java.util.Collection;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.classes.MessageMethods;
import fp4g.data.Add;
import fp4g.data.AddAsset;
import fp4g.data.AddDefine;
import fp4g.data.AddMethod;
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
import fp4g.data.define.Asset;
import fp4g.data.define.Behavior;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Manager;
import fp4g.data.define.Message;
import fp4g.data.define.Struct;
import fp4g.data.expresion.IMap;
import fp4g.data.libs.Lib;
import fp4g.data.statements.Destroy;
import fp4g.data.statements.Filter;
import fp4g.data.statements.OrFilters;
import fp4g.data.statements.Send;
import fp4g.data.statements.Source;
import fp4g.data.statements.Subscribe;
import fp4g.data.statements.Unsubscribe;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.exceptions.NotAllowedException;
import fp4g.log.Log;
import fp4g.log.info.CannotEval;
import fp4g.log.info.Error;
import fp4g.log.info.GeneratorError;
import fp4g.log.info.NotAllowed;
import fp4g.log.info.Warn;
import fp4g.parser.FP4GParser.ArrayContext;


/**
 * Visita el arbol construido.
 * 
 * Visita el arbol construido y construye los datos necesarios.
 * @author Edgardo
 */
public class FP4GDataVisitor extends FP4GBaseVisitor<ILine>
{
	private final IDefine container;
	private MessageMethods methods;
	private final Stack<IDefine> current;	
	private Statements statements;
	private final FP4GExpresionVisitor exprVisitor;
	private final FP4GNameListVisitor nameListVisitor;
	
	public FP4GDataVisitor(final Lib lib)
	{
		this.container = lib;		
		current = new Stack<IDefine>();		
		exprVisitor = new FP4GExpresionVisitor(current);
		nameListVisitor = new FP4GNameListVisitor(exprVisitor,current);
	}
	public FP4GDataVisitor(final Game game)
	{
		this.container = game;		
		current = new Stack<IDefine>();		
		exprVisitor = new FP4GExpresionVisitor(current);
		nameListVisitor = new FP4GNameListVisitor(exprVisitor,current);
		try
		{
			methods = (MessageMethods)game.get(Message.METHODS).getValue();
		}
		catch(NullPointerException e)
		{
			throw new FP4GRuntimeException(Error.MessageMethodNotFound,"Los metodos para los mensajes no se encontrarón",e);
		}
	}
	
	@Override
	public ILine visitUsing(FP4GParser.UsingContext ctx)
	{	
		IDefine define = null;
		switch(ctx.type)
		{		
		case BEHAVIOR:
			define = new Behavior(ctx.name.getText(),container);
			define.setGenerable(false);
			define.setUsable(true);
			container.setDefine(define);
			break;
		case ENTITY:
			define = new Entity(ctx.name.getText(),container);
			define.setGenerable(false);
			define.setUsable(true);
			container.setDefine(define);			
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
			define = new GameState(ctx.name.getText(),container);
			define.setGenerable(false);
			define.setUsable(true);
			container.setDefine(define);			
			break;
		case GAME:			
		default:			
			throw new FP4GRuntimeException(GeneratorError.IllegalState,"Se esperaba que se use un tipo valido. agrego un define nuevo?");					
		}
		
		if(define != null)
		{
			current.push(define);
			visit(ctx.usingValues());			
			current.pop();
		}
		
		return null;		
	}
	
	@Override
	public ILine visitStart(FP4GParser.StartContext ctx)
	{
		if(container instanceof Lib)
		{
			//TODO null
			throw new NotAllowedException(NotAllowed.NotExpectedGame,null, "Start dentro de Lib");
		}
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
				state.setGenerable(false);
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
		AddMethod method = null;
		if(message != null)
		{
			method = message.getAddMethod(ctx.filterName);
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
	public ILine visitSubscribe(FP4GParser.SubscribeContext ctx)
	{
		Define define = (Define)current.peek();
		Subscribe subscribe;
		//where=ID ON message=ID (DOUBLEDOT method=ID)?
		String whereName = ctx.where.getText();
		Instance whereType = Instance.Self;
		String messageName = ctx.message.getText();
		String methodName = (ctx.method != null)?ctx.method.getText():null;
		
		//obtener message
		Message message = define.getDefine(DefineType.MESSAGE, messageName);
		//objetener  method
		AddMethod method = message.getAddMethod(methodName);
		
		Define where = define.getDefine(whereName);
		
		//identificar where que es
		whereType = Instance.System;
		subscribe = new Subscribe(whereType, where, message, method);
		
		return subscribe;
	}
	
	@Override 
	public ILine visitUnsubscribe(FP4GParser.UnsubscribeContext ctx)
	{
		Define define = (Define)current.peek();
		Unsubscribe subscribe;
		//where=ID ON message=ID (DOUBLEDOT method=ID)?
		String whereName = ctx.where.getText();
		Instance whereType = Instance.Self;
		String messageName = ctx.message.getText();
		String methodName = (ctx.method != null)?ctx.method.getText():null;
		
		//obtener message
		Message message = define.getDefine(DefineType.MESSAGE, messageName);
		//objetener  method
		AddMethod method = message.getAddMethod(methodName);
		
		Define where = define.getDefine(whereName);
		
		//identificar where que es
		whereType = Instance.System;
		subscribe = new Unsubscribe(whereType, where, message, method);
		
		return subscribe;
	}
	
	@Override
	public ILine visitSend(FP4GParser.SendContext ctx)
	{
		Define define = (Define)current.peek();
		
		AddMethod method = methods.getMessageMethod(ctx.messageMethodName);
		if(method == null)
		{
			throw new FP4GRuntimeException(Error.FilterMethodMissing,"No se encontró un metodo para el filtro:  ".concat(ctx.messageMethodName));
		}
		Instance type = null;
		String receiver = null;
		//Busqueda de quien envia mensaje.
		//1.- Game
		//2.- Self
		//3.- Other
		//4.- Componente
		//5.- Tag
		//6.- Sistema
		type = (ctx.receiverType == null)?Instance.Behavior:ctx.receiverType;
		
		
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
			List<AddDefine> behaviors = define.getAddDefines(DefineType.BEHAVIOR);
			for(AddDefine bhvr:behaviors)
			{
				//buscar de forma iterativa
				if(bhvr.name.equals(receiver))
				{
					type = Instance.Behavior; //Es un behavior!
					send = new Send(type,method,receiver);
					break;
				}
			}
	    //Tag
			//buscar algún tag, si es que existe
			
	    //System
			
			//buscar en los defines de sistemas.
			Collection<IDefine> managers = container.getDefines(DefineType.MANAGER);
			for(IDefine manager:managers)
			{
				if(manager.getName().equals(receiver))
				{
					if(((Manager)manager).isReceiver())
					{
						type = Instance.System; //es un sistema!, ojo que el sistema puede que no esté definido...
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
		if(container instanceof Game)
		{
			final Game game = (Game)container; 
			game.name = ctx.name;
			game.setLine(ctx.getStart().getLine());
			return super.visitGame(ctx);
		}
		else
		{
			//TODO null
			throw new NotAllowedException(NotAllowed.NotExpectedGame,null, "No se permite definir el nombre del juego cuando se carga una biblioteca");
		}
	}
	
	@Override
	public ILine visitGameValues(FP4GParser.GameValuesContext ctx)
	{
		current.push(container);		
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
				if(container instanceof Lib)
				{
					define = new Manager(defName,parent);
					define.setGenerable(false); //no se genera
			  		define.setUsable(false); //no es usable
				}				
				else
				{
					throw new NotAllowedException(NotAllowed.NotImplementedYet, define, "No se ha implementado esta caracteristica todavía");
				}
				break;
		  	case BEHAVIOR:
		  		if(container instanceof Lib)
				{
		  			define = new Behavior(defName,parent);
		  			define.setGenerable(false); //no se genera
			  		define.setUsable(false); //no es usable
				}				
				else
				{
					throw new NotAllowedException(NotAllowed.NotImplementedYet, define, "No se ha implementado esta caracteristica todavía");
				}
		  		break;		  		
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
		  	case STRUCT:
		  		define = new Struct(defName, parent);
		  		define.setGenerable(false); //no se genera
		  		define.setUsable(false); //no es usable
		  		break;
		  	default:
		  		throw new FP4GRuntimeException(GeneratorError.IllegalState,"Se esperaba que se use un tipo valido. agrego un define nuevo?");
		 }
		define.setLine(define_ctx.getStart().getLine());
		parent.setDefine(define);
				  
		current.push(define);		
		super.visitDefineValues(ctx);
		current.pop();
		
		final FP4GParser.NameListContext nameList_ctx = define_ctx.nameList();
		if(nameList_ctx != null)
		{
			final NameList nameList = nameListVisitor.getNameList(nameList_ctx);
			define.setNameList(nameList);		
		}
		
		return null;		
	}	
	
	@Override
	public ILine visitAddMethod(FP4GParser.AddMethodContext ctx)
	{
		IDefine parent = current.peek();
		//String name, NameList list, IMap values		
		NameList list = nameListVisitor.getNameList(ctx.nameList());
		
		final IMap map = getMap(ctx.exprParams,ctx.start.getLine());
		
		AddMethod add = new AddMethod(ctx.addName, list, map);
		
		parent.setAdd(add);
		
		return add;
	}
	
	@Override
	public ILine visitAddDefine(FP4GParser.AddDefineContext ctx)
	{
		IDefine parent = current.peek();		
		
		Add add;		
		//buscar el define que estoy agregando
		try 
		{
			//Define define, ExprList params, IMap values
			IDefine  define = parent.getDefine(ctx.type,ctx.addName);
			ExprList list = exprVisitor.getExprList(ctx.exprList());
			final IMap map = getMap(ctx.exprParams,ctx.start.getLine());
			add = new AddDefine((Define)define,list, map);			
			add.setLine(ctx.start.getLine());
		}
		catch (DefineNotFoundException e) 
		{			
			ExprList list = exprVisitor.getExprList(ctx.exprList());
			final IMap map = getMap(ctx.exprParams,ctx.start.getLine());
			add = new AddDefine(ctx.type,ctx.addName, list, map);
			add.setLine(ctx.start.getLine());
			Log.Exception(e, ctx.start.getLine());		
		}
		
		parent.setAdd(add);		
		
		return add; 		
	}
	
	@Override
	public ILine visitAssetValueWithInnerValue(FP4GParser.AssetValueWithInnerValueContext ctx) 
	{
		//Asset padre
		AddAsset assetParent = (AddAsset)visit(ctx.value);		
		if(ctx.innerAssets != null)
		{
			//visito a los hijos si existen
			for(ParseTree children:ctx.innerAssets.children)
			{
				AddAsset assetChildren = (AddAsset)visit(children);
				if(assetChildren != null)
				{
					assetChildren.setParent(assetParent);
				}
			}
		}
		return null;
	}
	
	private int asset_number = 0;	
	@Override
	public ILine visitAssetValue(FP4GParser.AssetValueContext ctx)
	{
		IDefine parent = current.peek();	

		//me aseguro que no sea null nunca
		String assetName  = (ctx.assetName != null)?ctx.assetName.getText(): String.format("asset_%d", asset_number++);
		String assetPath = ctx.assetPath.getText(); 
		assetPath = assetPath.substring(1, assetPath.length()-1);
		
		//tratar de buscar un define
		Asset asset;
		try
		{
			asset = parent.getDefine(DefineType.ASSET, ctx.assetType.getText());
		}
		catch (DefineNotFoundException e)
		{			
			//si no se encuentra, reemplazarlo por otro
			Log.Exception(e, ctx.assetName.getLine());
			//TODO evaluar si seguir usando el Asset.Type
			asset = new Asset(Asset.Type.valueOf(ctx.assetType.getText()), parent);
			asset.setUsable(false);
			asset.setGenerable(false);
		}
		
		final IMap map = getMap(ctx.exprParams,ctx.start.getLine());
		
		AddAsset assetAdd;
		if(assetName == null)
		{
			//Asset asset, String resourceName, String resource, IMap values
			assetAdd = new AddAsset(asset,assetName, assetPath, map);			
		}
		else
		{
			assetAdd = new AddAsset(asset,assetName, assetPath, map);				
			//assetAdd = new Add(DefineType.ASSET,assetType.name(),assetName);
		}
		assetAdd.setLine(ctx.start.getLine());
		
		parent.setAdd(assetAdd);
		
		return assetAdd;		
	}
	
	private IMap getMap(ArrayContext ctx, int line) 
	{
		final IMap map;
		Expresion exprParams = (ctx == null)? null: exprVisitor.visitArray(ctx);
		if(exprParams!=null)
		{
			if(exprParams instanceof List)
			{
				Log.Show(CannotEval.IncomplatibleTypes, line, "Se esperaba un map");
				map = null;
			}	
			else
			{
				map = (IMap) exprParams;
			}
		}
		else
		{
			map = null;
		}
		return map;
	}
}
