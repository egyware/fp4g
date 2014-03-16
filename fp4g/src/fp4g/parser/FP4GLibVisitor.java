/**
 * 
 */
package fp4g.parser;

import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.data.Add;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.IValue;
import fp4g.data.Instance;
import fp4g.data.NameList;
import fp4g.data.On;
import fp4g.data.Statements;
import fp4g.data.VarType;
import fp4g.data.define.Asset;
import fp4g.data.define.Behavior;
import fp4g.data.define.Entity;
import fp4g.data.define.GameState;
import fp4g.data.define.Manager;
import fp4g.data.define.Message;
import fp4g.data.define.Struct;
import fp4g.data.libs.Lib;
import fp4g.data.statements.Destroy;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.exceptions.NotAllowedException;
import fp4g.log.Log;
import fp4g.log.info.GeneratorError;
import fp4g.log.info.NotAllowed;
import fp4g.log.info.Warn;
import fp4g.log.info.Error;


/**
 * Visita el arbol construido.
 * @author Edgardo
 */
public class FP4GLibVisitor extends FP4GBaseVisitor<Code>
{
	private final Lib lib;	
	private final Stack<IDefine> current;
	private NameList nameList;
	private Statements statements;
	private final FP4GExpresionVisitor exprVisitor;
	public FP4GLibVisitor(final Lib lib)
	{
		this.lib = lib;		
		current = new Stack<IDefine>();		
		exprVisitor = new FP4GExpresionVisitor(current);
	}
	
	@Override
	public Code visitUsing(FP4GParser.UsingContext ctx)
	{	
		final String usingName = ctx.name.getText();
		switch(ctx.type)
		{		
		case BEHAVIOR:
			Behavior behavior = new Behavior(usingName,lib);
			behavior.setGenerable(false);
			behavior.setUsable(true);
			lib.setDefine(behavior);
			break;
		case ENTITY:
			Entity entity = new Entity(usingName,lib);
			entity.setGenerable(false);
			entity.setUsable(true);
			lib.setDefine(entity);
			break;
		case GOAL:
			//TODO por hacer...
//			Behavior behavior = new Behavior(ctx.name.getText());
//			behavior.setBuild(false);
//			game.setDefine(behavior);
			break;
		case MANAGER:
			Manager manager = new Manager(usingName,lib);
			manager.setGenerable(false);
			manager.setUsable(true);
			lib.setDefine(manager);
			break;
		case MESSAGE:
			//TODO por hacer..
			break;
		case STATE:
			GameState state = new GameState(ctx.name.getText(),lib);
			state.setGenerable(false);
			state.setUsable(true);
			lib.setDefine(state);			
			break;
		case GAME:			
		default:			
			throw new FP4GRuntimeException(GeneratorError.IllegalState,"Se esperaba que se use un tipo valido. agrego un define nuevo?");				
		}
		return null;		
	}
	
	@Override
	public Code visitStart(FP4GParser.StartContext ctx)
	{
		//TODO cambiar a otro error
		throw new RuntimeException("No se esperaba start");
	}
	
	@Override
	public Code visitOn(FP4GParser.OnContext ctx)
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
				//Muestra un error, pero sigue funcionando...
				Log.Show(Error.MessageExpected,ctx.start.getLine(),ctx.messageName);
				on = new On(ctx.messageName);
			}
			
			//solo si es nuevito, se agrega
			parent.setOn(on);
		}
		
		super.visitOn(ctx);
		
		//al evento on, se crea un nuevo codigo y se le aï¿½aden los filtros, si es que existen.
		//falta solo agregarle el codigo :)
//		Source source = on.addSource(statements);
		statements = null;
		if(ctx.filters != null)
		{		
			//TODO SIN FILTRO
//			List<List<String>> filtros = ctx.filters.or;
//			for(List<String> filtro:filtros)
//			{
//				try
//				{
//					source.addFilter(filtro);
//				}
//				catch(FP4GException e)
//				{
//					//Error, acá tratamos de ahcer el mejor esfuerzo posible.
//					Log.Exception(e,ctx.start.getLine());
//				}
//			}
		}
		return null;		
	}
	
	@Override
	public Code visitOnStatement(FP4GParser.OnStatementContext ctx)
	{
		statements = new Statements();
		for(ParseTree c:ctx.children)
		{
			statements.add(visit(c));
		}		
		return statements;		
	}
	
	
	@Override
	public Code visitDestroy(FP4GParser.DestroyContext ctx)
	{
		Destroy destroy = new Destroy(Instance.Self);
		return destroy;
	}
	
	@Override
	public Code visitSend(FP4GParser.SendContext ctx)
	{
		throw new RuntimeException("No se permite Send =P");
	}
	
	@Override 
	public Code visitSet(FP4GParser.SetContext ctx)
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
	
	public static IValue<?> eval(IValue<?> define, Expresion expr) throws CannotEvalException 
	{
		return expr.eval(define);
	}
	
	@Override
	public Code visitGameValues(FP4GParser.GameValuesContext ctx)
	{
		current.push(lib);
		super.visitGameValues(ctx);		
		current.pop();
		return null;
	}	
	
	@Override
	public Code visitDefineValues(FP4GParser.DefineValuesContext ctx)
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
				define = new Manager(defName,parent);				
				break;		  		
		  	case BEHAVIOR:		  		
		  		define = new Behavior(defName,parent);
		  		define.setGenerable(false); //no se genera
		  		define.setUsable(false); //no es usable
		  		break;		  		
		  	case GOAL:
		  		//TODO: No implementado aún
		  		throw new NotAllowedException(NotAllowed.NotImplementedYet, null, "No se ha implementado esta caracteristica todavía");
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
	public Code visitAdd(FP4GParser.AddContext ctx)
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
	public Code visitNameList(FP4GParser.NameListContext ctx)
	{
		nameList = new NameList();
		super.visitNameList(ctx);
	
		return null;		
	}
	
	@Override 
	public Code visitDeclareVar(FP4GParser.DeclareVarContext ctx)
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
				Log.Exception(e, ctx.start.getLine());
			}
		}
		else
		{
			nameList.add(type, ctx.varName.getText());
		}
		//nameList.add(type,ctx.ID().getText());
		return null;		
	}
		
	
	
	@Override
	public Code visitAssets(FP4GParser.AssetsContext ctx) 
	{
		//TODO falta implementación
		return null;
	}
	
	@Override
	public Code visitAssetValue(FP4GParser.AssetValueContext ctx)
	{
		//TODO falta implementación		
		return null;		
	}
}
