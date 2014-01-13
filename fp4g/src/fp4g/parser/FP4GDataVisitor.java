/**
 * 
 */
package fp4g.parser;

import static fp4g.Log.Show;

import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.Log.WarnType;
import fp4g.classes.MessageMethod;
import fp4g.classes.MessageMethods;
import fp4g.data.Add;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.Instance;
import fp4g.data.NameList;
import fp4g.data.On;
import fp4g.data.On.Source;
import fp4g.data.Statements;
import fp4g.data.VarType;
import fp4g.data.define.Asset;
import fp4g.data.define.Behavior;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Message;
import fp4g.data.expresion.CustomClassMap;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.literals.StringLiteral;
import fp4g.data.statements.Destroy;
import fp4g.data.statements.Send;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DefineNotFoundException;


/**
 * Visita el arbol construido.
 * @author Edgardo
 */
public class FP4GDataVisitor extends FP4GBaseVisitor<Code>
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
		CustomClassMap map = ((CustomClassMap)game.get("methods"));
		methods = (MessageMethods)map.getValue();
	}
	
	
	
	@Override
	public Code visitUsing(FP4GParser.UsingContext ctx)
	{	
		switch(ctx.type)
		{		
		case BEHAVIOR:
			Behavior behavior = new Behavior(ctx.name.getText());
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
			//TODO error :/ estado ilegal					
		}
		return null;		
	}
	
	@Override
	public Code visitStart(FP4GParser.StartContext ctx)
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
				Show(WarnType.MissingAdd,ctx.start.getLine());
				//creo un elemento temporal para solucionar el state faltante, sin embargo no se generar�
				state = new GameState(ctx.state,define);
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
				Log.Show(ErrType.MessageExpected,ctx.start.getLine(),ctx.messageName);
				on = new On(ctx.messageName);
			}
			
			//solo si es nuevito, se agrega
			parent.setOn(on);
		}
		
		super.visitOn(ctx);
		
		//al evento on, se crea un nuevo codigo y se le a�aden los filtros, si es que existen.
		//falta solo agregarle el codigo :)
		Source source = on.addSource(statements);
		statements = null;
		if(ctx.filters != null)
		{			
			List<List<String>> filtros = ctx.filters.or;
			for(List<String> filtro:filtros)
			{
				source.addFilter(filtro);
			}
		}
		return null;		
	}
	
	@Override
	public Code visitOnStatement(FP4GParser.OnStatementContext ctx)
	{
		statements = new Statements();
		//TODO talvez deberia usar aggregateResult
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
		MessageMethod method = methods.getMessageMethod(ctx.messageMethodName);
		if(method == null)
		{
			Log.Show(ErrType.MessageMethodNotFound,ctx.start.getLine());
			//TODO ?
		}
		Send.SendTo type = null;
		String receiver = null;
		//Busqueda de quien envia mensaje.
		//1.- Self
		//2.- Other
		//3.- Componente
		//4.- Tag
		//5.- Sistema
		type = ctx.receiverType;
		switch(ctx.receiverType)
		{		
		case Other:
			//nada que hacer ;)
			break;
		case Self:
			//nada que hacer ;)
			break;					
		default:
		//Behavior,System, no se puede determinar desde el lexer
			receiver = ctx.receiverName;			
			type = Send.SendTo.System; //asumir� que es un sistema pero no ser� de mucha ayuda.			
			//type = Send.SendTo.Behavior;
			break;		
		}		
		Send send = new Send(type,method,receiver);	
		
		ExprList list = exprVisitor.getExprList(ctx.exprList());
		if(list != null)
		{		
			//TODO checkar la exprList, checkar que?, Compararla contra MessageMethod.Params se requiere conocimiento adicional.
			send.setArguments(list);		
		}
		
		return send;		
	}
	
	@Override 
	public Code visitSet(FP4GParser.SetContext ctx)
	{
		IDefine define = current.peek();
		
		Expresion expr = exprVisitor.visit(ctx.expr());		
		try {
			define.set(ctx.key, eval(define,expr));
		} catch (CannotEvalException e) {			
			Log.Show(WarnType.CannotEvalExpr,ctx.getStart().getLine(),expr.toString());
		}
		return null;
	}
	
	public static Literal<?> eval(IDefine define, Expresion expr) throws CannotEvalException 
	{
		return expr.eval(define);
	}

	@Override
	public Code visitGame(FP4GParser.GameContext ctx)
	{
		game.name = ctx.name;
		game.setLine(ctx.getStart().getLine());
		return super.visitGame(ctx);		
	}
	
	@Override
	public Code visitGameValues(FP4GParser.GameValuesContext ctx)
	{
		current.push(game);		
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
				//TODO: No implementado a�n
				Show(ErrType.NotImplement);
				throw new RuntimeException("No implementado");
				//break;		  		
		  	case BEHAVIOR:
		  		//TODO: No implementado a�n
		  		Show(ErrType.NotImplement);
				throw new RuntimeException("No implementado");
		  		//break;		  		
		  	case GOAL:
		  		//TODO: No implementado a�n
		  		Show(ErrType.NotImplement);
				throw new RuntimeException("No implementado");
		  		//break;
		  	case MESSAGE:
		  		define = new Message(defName,parent);		  		
		  		break;
		  	case ASSET:
		  		Asset.Type type = Asset.Type.valueOf(defName);
		  		define = new Asset(type,parent);
		  		break;
		  	default:
		  		Show(ErrType.UnknowError);		  		
		  	break;
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
		
		Add	add = new Add(ctx.type,ctx.addName,ctx.varName);
		add.setLine(ctx.start.getLine());
		
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
				Show(WarnType.CannotEvalExpr,ctx.initValue.start.getLine());				
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
	public Code visitAssetValueInner(FP4GParser.AssetValueInnerContext ctx)
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
	public Code visitAssetValue(FP4GParser.AssetValueContext ctx)
	{
		IDefine parent = current.peek();	

		//spaceship = ADD ASSET Texture({name="spacheship",atlas = assets_group_1})
		String varName  = (ctx.assetName != null)?ctx.assetName.getText():null;
		String assetFile = ctx.asset.getText(); //TODO hay que evualuar esto m�s adelante
		assetFile = assetFile.substring(1, assetFile.length()-1);
		Asset.Type assetType = Asset.Type.valueOf(ctx.assetType.getText());
		
		Add assetAdd;		
		if(varName == null)
		{
			assetAdd = new Add(DefineType.ASSET,assetType.name());
		}
		else
		{
			assetAdd = new Add(DefineType.ASSET,assetType.name(),varName);
		}
		ExprList paramsList = new ExprList(1);
		//TODO soportar muchas opciones
		paramsList.add(new StringLiteral(assetFile));
		
		assetAdd.addParams(paramsList);		
		parent.setAdd(assetAdd);
		
		if(ctx.innerAssetValues != null)
		{	
			//TODO m�s opciones...
		}
		
		return null;		
	}
}
