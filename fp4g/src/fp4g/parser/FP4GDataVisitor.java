package fp4g.parser;


import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.ILine;
import fp4g.data.IValue;
import fp4g.data.NameList;
import fp4g.data.On;
import fp4g.data.Statement;
import fp4g.data.Statements;
import fp4g.data.add.AddAsset;
import fp4g.data.add.AddDefine;
import fp4g.data.add.AddMethod;
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
import fp4g.data.statements.Filter;
import fp4g.data.statements.OrFilters;
import fp4g.data.statements.Source;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.exceptions.NotAllowedException;
import fp4g.log.Log;
import fp4g.log.info.CannotEval;
import fp4g.log.info.Error;
import fp4g.log.info.GeneratorError;
import fp4g.log.info.NotAllowed;
import fp4g.parser.FP4GParser.ArrayContext;
import fp4g.parser.FP4GParser.UsingValuesContext;


/**
 * Visita el arbol construido.
 * 
 * Visita el arbol construido y construye los datos necesarios.
 * @author Edgardo
 */
public class FP4GDataVisitor extends FP4GBaseVisitor<ILine>
{
	private final IDefine container;	
	private final Stack<IDefine> current;
	private final FP4GExpresionVisitor exprVisitor;
	private final FP4GNameListVisitor nameListVisitor;
	private final FP4GStatementVisitor statementVisitor;
	
	public FP4GDataVisitor(final Lib lib)
	{
		this.container = lib;		
		current = new Stack<IDefine>();		
		exprVisitor = new FP4GExpresionVisitor(current);
		nameListVisitor = new FP4GNameListVisitor(exprVisitor,current);
		statementVisitor = new FP4GStatementVisitor(lib,current,exprVisitor);
	}
	public FP4GDataVisitor(final Game game)
	{
		this.container = game;		
		current = new Stack<IDefine>();		
		exprVisitor = new FP4GExpresionVisitor(current);
		nameListVisitor = new FP4GNameListVisitor(exprVisitor,current);
		statementVisitor = new FP4GStatementVisitor(game,current,exprVisitor);
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
			define = new Message(ctx.name.getText(), container);
			define.setGenerable(false);
			define.setUsable(true);
			container.setDefine(define);
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
			UsingValuesContext values = ctx.usingValues();
			if(values != null)
			{
				current.push(define);
				visit(values);			
				current.pop();
			}
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
	public ILine visitWhen(FP4GParser.WhenContext ctx)
	{
		//TODO posible error, hay que chequear bien esto
		final Define parent       = (Define)current.peek();
		final Expresion expresion = exprVisitor.visit(ctx.condition);
		final Statement statement = statementVisitor.visit(ctx.stmnt);
		//TODO verificar si expresion es realmente una condición
		
		parent.addWhen(expresion, statement);
		
		return null;
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

		Statements statements = statementVisitor.getStatements(ctx.statements());
		//al evento on, se crea un nuevo codigo y se le añaden los filtros, si es que existen.
		//falta solo agregarle el codigo :)
		Source source = on.addSource(statements);		
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
	public ILine visitSet(FP4GParser.SetContext ctx)
	{
		IDefine define = current.peek();
		
		Expresion expr = exprVisitor.visit(ctx.expr());		
		try {
			define.set(ctx.key, eval(define,expr));
		} catch (CannotEvalException e) {			
			Log.Show(CannotEval.CannotEvalExpresion,ctx.getStart().getLine(),expr.toString());
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
	public ILine visitFlags(FP4GParser.FlagsContext ctx)
	{
		//TODO este casting se ve algo peligroso...
		Define parent = (Define)current.peek();
		NameList flags = nameListVisitor.getFlags(ctx);
		parent.addFlags(flags);
		
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
