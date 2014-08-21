package fp4g.parser;

import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.DefineTypes;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.ILib;
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
import fp4g.log.FP4GError;
import fp4g.log.Log;
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
	private final ILib container;
	private final FP4GExpresionVisitor exprVisitor;
	private final FP4GNameListVisitor nameListVisitor;
	private final FP4GStatementVisitor statementVisitor;
	private boolean loadLib;
	
	private IDefine current;
	
	public FP4GDataVisitor(final Lib lib)
	{
		this.container = lib;
		exprVisitor = new FP4GExpresionVisitor();
		nameListVisitor = new FP4GNameListVisitor(exprVisitor);
		statementVisitor = new FP4GStatementVisitor(lib, exprVisitor);
	}
	
	@Override
	public ILine visit(ParseTree tree)
	{
		ILine line = super.visit(tree);
		if(line != null && tree instanceof TerminalNode)
		{
			line.setLine(((TerminalNode)tree).getSymbol().getLine());
		}
		return line;
	}
	
	@Override
	public ILine visitUsing(FP4GParser.UsingContext ctx)
	{	
		IDefine define = null;
		final DefineType type = ctx.type;
		if(DefineTypes.BEHAVIOR == type)
		{
			define = new Behavior(ctx.name.getText(),container);
			define.setGenerable(false);
			define.setUsable(true);
			container.setDefine(define);
		}
		else
		if(DefineTypes.ENTITY == type)
		{
			define = new Entity(ctx.name.getText(),container);
			define.setGenerable(false);
			define.setUsable(true);
			container.setDefine(define);			
		}
		else
		if(DefineTypes.GOAL == type)
		{
			//TODO por hacer...
//			Behavior behavior = new Behavior(ctx.name.getText());
//			behavior.setBuild(false);
//			game.setDefine(behavior);
		}
		else
		if(DefineTypes.MANAGER == type)
		{
			//TODO por hacer...
		}
		else
		if(DefineTypes.MESSAGE == type)
		{
			define = new Message(ctx.name.getText(), container);
			define.setGenerable(false);
			define.setUsable(true);
			container.setDefine(define);
		}
		else
		if(DefineTypes.STATE == type)
		{
			define = new GameState(ctx.name.getText(),container);
			define.setGenerable(false);
			define.setUsable(true);
			container.setDefine(define);			
		}
		else
		{					
			throw new FP4GRuntimeException(FP4GError.IllegalState, "Se esperaba que se use un tipo valido. agrego un define nuevo?");					
		}
		
		current = define;
		if(define != null)
		{			
			UsingValuesContext values = ctx.usingValues();
			if(values != null)
			{				
				visit(values);
			}
		}
		
		return null;		
	}
	
	@Override
	public ILine visitStart(FP4GParser.StartContext ctx)
	{
		IDefine define = current;
		
		if(define instanceof Game)
		{
			final String stateName = ctx.state;			
			GameState state;
			try 
			{
				state = container.getDefine(DefineTypes.STATE, stateName);
			} 
			catch (DefineNotFoundException e) 
			{				
				Log.Exception(e, ctx.start.getLine());
				//creo un elemento temporal para solucionar el state faltante, sin embargo no se generará
				state = new GameState(ctx.state,container);
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
		final Expresion expresion = exprVisitor.visit(ctx.condition);
		final Statement statement = statementVisitor.visit(ctx.stmnt);
		//TODO verificar si expresion es realmente una condición
		
		current.addWhen(expresion, statement);
		
		return null;
	}
	
	@Override
	public ILine visitOn(FP4GParser.OnContext ctx)
	{
		//en vez de solo crearlo, tengo que buscarlo... y si no existe crearlo.
		On on = current.getOn(ctx.messageName);
		if(on == null)
		{	
			//es message, cast seguro
			Message message = null;
			try
			{
				message = container.getDefine(DefineTypes.MESSAGE,ctx.messageName);				
				on = new On(message);
			}
			catch (DefineNotFoundException e) 
			{
				Log.Exception(e, ctx.start.getLine());
				on = new On(ctx.messageName);
			}

			//solo si es nuevito, se agrega
			current.setOn(on);
		}

		Statements statements = statementVisitor.getStatements(current,ctx.statements());
		//al evento on, se crea un nuevo codigo y se le añaden los filtros, si es que existen.
		//falta solo agregarle el codigo :)
		Source source = on.addSource(statements);		
		if(ctx.filters != null)
		{		
			ctx.filters.orFilters = source.filters;
			ctx.filters.message   = on.message;
			visit(ctx.filters);
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
		ExprList list = exprVisitor.getExprList(current, ctx.exprList());
		Message message = ctx.message;
		AddMethod method = null;
		if(message != null)
		{
			method = message.getAddMethod(ctx.filterName);
		}	
		if(method == null)
		{
			throw new FP4GRuntimeException(FP4GError.FilterMethodMissing, "No se encontró un metodo para el filtro:  ".concat(ctx.filterName));
		}
		
		Filter filter = new Filter(method,list);
		
		return filter;		
	}
	
	@Override 
	public ILine visitSet(FP4GParser.SetContext ctx)
	{
		Expresion expr = exprVisitor.getExpr(current, ctx.expr());		
		if(current == null)
		{
			container.set(ctx.key, eval(container,expr));
		}
		else
		{
			current.set(ctx.key, eval(container,expr));
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
		final Game game = new Game(container); 
		game.name = ctx.name;
		game.setLine(ctx.getStart().getLine());
		container.setDefine(game);
		current = game;
		ILine ret = super.visitGame(ctx);
		current = null;
		return ret;
	}
	
	@Override
	public ILine visitParseLib(FP4GParser.ParseLibContext ctx)
	{
		//biblioteca
		current = null;		
		loadLib = true;
		return super.visitParseLib(ctx);		
	}
	
	@Override
	public ILine visitGameValues(FP4GParser.GameValuesContext ctx)
	{
		super.visitGameValues(ctx);		
		return null;
	}	
	
	@Override
	public ILine visitDefineValues(FP4GParser.DefineValuesContext ctx)
	{
		FP4GParser.DefineContext define_ctx = (FP4GParser.DefineContext)ctx.parent;		
		String defName = define_ctx.defName;
		
		Define define = null;		
		final DefineType type = define_ctx.type; 
		if(DefineTypes.STATE == type)
		{
			define = new GameState(defName,container);	
		}
		else
		if(DefineTypes.ENTITY  == type)
		{
			define = new Entity(defName,container);
		}
		else
		if(DefineTypes.MANAGER == type)
		{
				if(container instanceof Lib)
				{
					define = new Manager(defName,container);
					define.setGenerable(false); //no se genera
			  		define.setUsable(false); //no es usable
				}				
				else
				{
					throw new FP4GRuntimeException(FP4GError.NotImplement, define, "No se ha implementado esta caracteristica todavía");
				}
		}
		else
		if(DefineTypes.BEHAVIOR == type)
		{
		  		if(container instanceof Lib)
				{
		  			define = new Behavior(defName,container);
		  			define.setGenerable(false); //no se genera
			  		define.setUsable(false); //no es usable
				}				
				else
				{
					throw new FP4GRuntimeException(FP4GError.NotImplement, define, "No se ha implementado esta caracteristica todavía");
				}
		}
		else
		if(DefineTypes.GOAL == type)
		{
		  		//TODO: No implementado aún
				throw new FP4GRuntimeException(FP4GError.NotImplement, define, "No se ha implementado esta caracteristica todavía");
		}
		else
		if(DefineTypes.MESSAGE  == type)
		{ 		  		
		  		define = new Message(defName,container);
		}
		else
		if(DefineTypes.ASSET  == type)
		{
		  		Asset.Type addType = Asset.Type.valueOf(defName);
		  		define = new Asset(addType,container);
		}
		else
		if(DefineTypes.STRUCT == type)
		{
		  		define = new Struct(defName, container);
		  		define.setGenerable(false); //no se genera
		  		define.setUsable(false); //no es usable		  		
		}
		else
		{
			throw new FP4GRuntimeException(FP4GError.IllegalState,"Se esperaba que se use un tipo valido. agrego un define nuevo?");
		}
	
		if(loadLib)
		{
			define.setGenerable(false);
		}
		define.setLine(define_ctx.getStart().getLine());
		container.setDefine(define);
				  
		current = define;		
		super.visitDefineValues(ctx);
		current = null;
		
		final FP4GParser.NameListContext nameList_ctx = define_ctx.nameList();
		if(nameList_ctx != null)
		{
			final NameList nameList = nameListVisitor.getNameList(define, nameList_ctx);
			define.setNameList(nameList);		
		}		
		
		return null;		
	}	
	
	@Override
	public ILine visitFlag(FP4GParser.FlagContext ctx)
	{
		NameList flags = nameListVisitor.getFlags(current.getFlags(), current, ctx);
		current.addFlags(flags);		
		return null;
	}
	
	@Override
	public ILine visitAddMethod(FP4GParser.AddMethodContext ctx)
	{
		//String name, NameList list, IMap values		
		NameList list = nameListVisitor.getNameList(current, ctx.nameList());
		
		final IMap map = getMap(ctx.exprParams,ctx.start.getLine());
		
		AddMethod add = new AddMethod(ctx.addName, list, map);
		
		current.setAdd(add);
		
		return add;
	}
	
	@Override
	public ILine visitAddDefine(FP4GParser.AddDefineContext ctx)
	{
		Add add;		
		//buscar el define que estoy agregando
		try 
		{
			//Define define, ExprList params, IMap values
			IDefine  define = container.getDefine(ctx.type,ctx.addName);
			ExprList list = exprVisitor.getExprList(current, ctx.exprList());
			final IMap map = getMap(ctx.exprParams,ctx.start.getLine());
			add = new AddDefine((Define)define,list, map);			
			add.setLine(ctx.start.getLine());
		}
		catch (DefineNotFoundException e) 
		{			
			ExprList list = exprVisitor.getExprList(current, ctx.exprList());
			final IMap map = getMap(ctx.exprParams,ctx.start.getLine());
			add = new AddDefine(ctx.type,ctx.addName, list, map);
			add.setLine(ctx.start.getLine());
			Log.Exception(e, ctx.start.getLine());		
		}
		
		current.setAdd(add);		
		
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
		//me aseguro que no sea null nunca
		String assetName  = (ctx.assetName != null)?ctx.assetName.getText(): String.format("asset_%d", asset_number++);
		String assetPath = ctx.assetPath.getText(); 
		assetPath = assetPath.substring(1, assetPath.length()-1);
		
		//tratar de buscar un define
		Asset asset;
		try
		{
			asset = container.getDefine(DefineTypes.ASSET, ctx.assetType.getText());
		}
		catch (DefineNotFoundException e)
		{			
			//si no se encuentra, reemplazarlo por otro
			Log.Exception(e, ctx.assetName.getLine());
			//TODO evaluar si seguir usando el Asset.Type
			asset = new Asset(Asset.Type.valueOf(ctx.assetType.getText()), container);
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
		
		current.setAdd(assetAdd);
		
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
				throw new FP4GRuntimeException(FP4GError.IncomplatibleTypes, line, "Se esperaba un map");				
			}				
			map = (IMap) exprParams;			
		}
		else
		{
			map = null;
		}
		return map;
	}	
}
