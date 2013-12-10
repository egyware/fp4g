/**
 * 
 */
package fp4g.parser;

import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;

import static fp4g.Log.Show;
import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.Log.WarnType;
import fp4g.classes.MessageMethod;
import fp4g.classes.MessageMethods;
import fp4g.data.Add;
import fp4g.data.AssetType;
import fp4g.data.Assets;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.NameList;
import fp4g.data.DefineType;
import fp4g.data.On;
import fp4g.data.Statements;
import fp4g.data.On.Source;
import fp4g.data.Send;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Message;
import fp4g.data.expresion.ArrayMap;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.ClassMap;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.Map;
import fp4g.data.expresion.UnaryOp;
import fp4g.data.expresion.ValueLiteral;
import fp4g.data.expresion.VarId;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.CustomClassMap;


/**
 * Visita el arbol construido.
 * @author Edgardo
 */
public class FP4GDataVisitor extends FP4GBaseVisitor<Code> {
	private Game game;
	private MessageMethods methods;
	private Stack<Define> current;
	private Stack<Map> array_stack;
	private Stack<Expresion> expr_stack;
	private Stack<Assets> assets_stack;	
	private ExprList exprList;
	private NameList nameList;
	private Statements statements;
	public FP4GDataVisitor(Game game)
	{
		this.game = game;		
		current = new Stack<Define>();
		expr_stack = new Stack<Expresion>();
		array_stack = new Stack<Map>();
		assets_stack = new Stack<Assets>();
		methods = (MessageMethods) ((CustomClassMap)game.get("methods")).getBean(); //TODO problema, porque en la biblioteca no está cargado todavia esta biblioteca
	}
	
	@Override
	public Code visitStart(FP4GParser.StartContext ctx)
	{
		Define define = current.peek();
		
		if(define instanceof Game)
		{
			final String stateName = ctx.state;
			GameState state = define.getDefine(DefineType.STATE, stateName);
			if(state != null)
			{
				Show(WarnType.MissingAdd,game);
				//creo un elemento temporal para solucionar el state faltante, sin embargo no se generarï¿½
				state = new GameState(ctx.state,define);
				state.setBuild(false);
			}
			//if(state )
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
		Define parent = current.peek();
		
		//en vez de solo crearlo, tengo que buscarlo... y si no existe crearlo.
		On on = parent.getOn(ctx.messageName);
		if(on == null)
		{	
			//es message, cast seguro
			Message message = parent.getDefine(DefineType.MESSAGE,ctx.messageName);
			if(message == null)
			{
				//Muestra un error, pero sigue funcionando...
				Log.Show(ErrType.MessageExpected,ctx.start.getLine(),ctx.messageName);
				on = new On(ctx.messageName);
			}
			else
			{
				//ahora lo creo...
				on = new On(message);
			}
			//solo si es nuevito, se agrega
			parent.setOn(on);
		}
		
		super.visitOn(ctx);
		
		//al evento on, se crea un nuevo codigo y se le aï¿½aden los filtros, si es que existen.
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
		if(ctx.receiverName != null) //TODO detectar para onde vÃ¡ (falta sistemas)
		{
			receiver = ctx.receiverName;
			type = Send.SendTo.Other;
		}
		else
		{
			type = Send.SendTo.Self;
		}
		Send send = new Send(type,method);	
		super.visitSend(ctx);
		if(exprList != null)
		{
			//TODO checkar la exprList
			send.setArguments(exprList);
			exprList = null;
		}
		switch(type)
		{		
		case Other:
			send.setTo(receiver);
			break;		
		case System:
			//TODO falta que hago
			break;
		default:
			break;		
		}
		
		return send;		
	}
	
	@Override 
	public Code visitSet(FP4GParser.SetContext ctx)
	{
		Define define = current.peek();
		
		Stack<Expresion> expr_stack = this.expr_stack;		
		this.expr_stack = new Stack<Expresion>();
		super.visitSet(ctx);
		Expresion expr = this.expr_stack.pop();
		this.expr_stack = expr_stack;
		define.set(ctx.key, eval(define,expr));
		return null;
	}
	
	private Literal<?> eval(Define define, Expresion expr) {
		if(expr instanceof Literal<?>)
		{
			return (Literal<?>)expr;
		}
		else
		{
			//TODO evaluar el set
			throw new RuntimeException("No Implementados");
		}		
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
		Define parent = current.peek();
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
				//TODO: No implementado aï¿½n
				Show(ErrType.NotImplement);
				throw new RuntimeException("No implementado");
				//break;		  		
		  	case BEHAVIOR:
		  		//TODO: No implementado aï¿½n
		  		Show(ErrType.NotImplement);
				throw new RuntimeException("No implementado");
		  		//break;		  		
		  	case GOAL:
		  		//TODO: No implementado aï¿½n
		  		Show(ErrType.NotImplement);
				throw new RuntimeException("No implementado");
		  		//break;
		  	case MESSAGE:
		  		define = new Message(defName,parent);		  		
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
		Define parent = current.peek();
		
		Add	add = new Add(ctx.type,ctx.addName,ctx.varName);
		add.setLine(ctx.getStart().getLine());
		super.visitAdd(ctx);
		if(exprList != null)
		{
			add.addParams(exprList);
			exprList = null;
		}		
		
		parent.setAdd(add);		
		
		return null; 		
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
		//TODO: esta conversaciï¿½n de variables no deberia estï¿½r puesta aqui
		String name = null;
		switch(ctx.varType().type)
		{
		case Bool:
			name = "Boolean";
			break;		
		case Decimal:
			name = "Float";
			break;
		case Entity:
			name = "Entity";
			break;
		case Integer:
			name = "Integer";
			break;					
		case String:
			name = "String";
			break;
		default:
			name = ctx.varType().getText();
			break;
		}
		nameList.add(ctx.ID().getText(),name);
		return null;		
	}
	
	@Override
	public Code visitExprList(FP4GParser.ExprListContext ctx)
	{	
		//ojo con el orden de estas funciones
		super.visitExprList(ctx);
		//se asume que no se visitarï¿½ concurrentemente a ExprList
		exprList = new ExprList(expr_stack.size());
				
		//aï¿½adimos todas las expresiones				
		while(!expr_stack.isEmpty())
		{
			final Expresion expr = expr_stack.pop();		
			exprList.addFirst(expr);				
		}		
		
		return null;
	}
	
	@Override
	public Code visitMultExpr(FP4GParser.MultExprContext ctx)
	{	
		Expresion left,right;
		visit(ctx.left);
		visit(ctx.right);
		
		left = expr_stack.pop();
		right = expr_stack.pop();		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Mult,right,left);
		expr_stack.push(binaryExpr);		
		
		return null;
	}
	@Override
	public Code visitSubExpr(FP4GParser.SubExprContext ctx)
	{
		Expresion left,right;
		visit(ctx.left);
		visit(ctx.right);
		
		left = expr_stack.pop();
		right = expr_stack.pop();
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Sub,right,left);
		expr_stack.push(binaryExpr);		
		
		return null;
	}
	@Override
	public Code visitAddExpr(FP4GParser.AddExprContext ctx)
	{		
		Expresion left,right;
		visit(ctx.left);
		visit(ctx.right);
		
		left = expr_stack.pop();
		right = expr_stack.pop();
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Add,right,left);
		expr_stack.push(binaryExpr);		
		
		return null;
	}
	@Override
	public Code visitDivExpr(FP4GParser.DivExprContext ctx)
	{
		Expresion left,right;
		visit(ctx.left);
		visit(ctx.right);
		
		left = expr_stack.pop();
		right = expr_stack.pop();
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Div,right,left);
		expr_stack.push(binaryExpr);		
		
		return null;
	}	
	@Override
	public Code visitParExpr(FP4GParser.ParExprContext ctx)
	{		
		visit(ctx.op);
		expr_stack.peek().setPar(true); //establecemos que esta expresiï¿½n, lleva parentesis
				
		return null;
	}	
	@Override
	public Code visitMinusExpr(FP4GParser.MinusExprContext ctx)
	{		
		visit(ctx.op);
		Expresion expr = expr_stack.pop();
		UnaryOp unaryExpr = new UnaryOp(UnaryOp.Type.Minus,expr);
		expr_stack.push(unaryExpr);
		
		return null;
	}	
	@Override
	public Code visitNotExpr(FP4GParser.NotExprContext ctx)
	{
		visit(ctx.op);		
		Expresion expr = expr_stack.pop();		
		UnaryOp unaryExpr = new UnaryOp(UnaryOp.Type.Not,expr);
		expr_stack.push(unaryExpr);
 
		return super.visitNotExpr(ctx);
	}
	
	//literal y id
	@Override
	public Code visitDecimalLiteral(FP4GParser.DecimalLiteralContext ctx)
	{
		Float integer = Float.valueOf(ctx.getText());
		Literal<Float> literal = new ValueLiteral<Float>(integer);
		expr_stack.push(literal);
		
		return null;
	}
	@Override
	public Code visitIntLiteral(FP4GParser.IntLiteralContext ctx)
	{
		Integer integer = Integer.valueOf(ctx.getText());
		Literal<Integer> literal = new ValueLiteral<Integer>(integer);
		expr_stack.push(literal);
		
		return null;
	}
	@Override
	public Code visitStringLiteral(FP4GParser.StringLiteralContext ctx)
	{
		String string = ctx.STRING_LITERAL().getText();
		string = string.substring(1, string.length()-1);
		Literal<String> literal = new ValueLiteral<String>(string);
		expr_stack.push(literal);
		
		return null;
	}
	
	@Override
	public Code visitDirectCode(FP4GParser.DirectCodeContext ctx)
	{
		String code = ctx.DIRECTCODE().getText();
		code = code.substring(2,code.length()-1);
		DirectCode dc = new DirectCode(code);
		expr_stack.push(dc);
		
		return null;
	}
	
	@Override
	public Code visitArray(FP4GParser.ArrayContext ctx)
	{		
		Map map = null;
		System.out.println(ctx.bean);
		if(ctx.bean != null)
		{
			ClassLoader cl = ClassLoader.getSystemClassLoader();
			try {
				Class<?> clazz = cl.loadClass(String.format("fp4g.classes.",ctx.bean));
				map = new ClassMap(clazz);
			} catch (ClassNotFoundException e) {
				Show(ErrType.ClassNotFound,ctx.ID.getLine());
			}
		}
		if(map == null)
		{
			map = new ArrayMap();
		}		
		array_stack.push(map);
		super.visitArray(ctx);
		array_stack.pop();
		expr_stack.push((Expresion)map); //siempre son expresiones!
		return null;
	}
	
	@Override
	public Code visitParArray(FP4GParser.ParArrayContext ctx)
	{
		String key = ctx.key;
		Stack<Expresion> expr_stack = this.expr_stack;		
		this.expr_stack = new Stack<Expresion>();
		super.visitParArray(ctx);
		Expresion expr = this.expr_stack.pop();
		this.expr_stack = expr_stack;
		
		Map array = array_stack.peek();
		if(expr instanceof Literal)
		{
			array.set(key, (Literal<?>) expr);
		}
		else
		{
			Show(ErrType.MissingError);
		}		
		return null;		
	}
	
	@Override
	public Code visitId(FP4GParser.IdContext ctx)
	{
		String id = ctx.ID().getText();
		VarId varId = new VarId(id);
		expr_stack.push(varId);
				
		return null;
	}
	
	@Override
	public Code visitFunctionCallExpr(FP4GParser.FunctionCallExprContext ctx)
	{
		//guardamos el actual stack!
		Stack<Expresion> prev_stack  = expr_stack;
		//nuevo stack!
		expr_stack = new Stack<Expresion>();
		String callName = ctx.functionName.getText();
		
		visit(ctx.exprList());
				
		FunctionCall functionCall = new FunctionCall(callName,exprList);
		exprList = null;		
		
		//restablecemos el stack anterior
		expr_stack = prev_stack;		
		expr_stack.push(functionCall);
		
		return null;
	}
	
	@Override
	public Code visitAssets(FP4GParser.AssetsContext ctx) 
	{
		Assets assets = new Assets();		
		assets_stack.push(assets);
		visitChildren(ctx);
		assets_stack.pop();
		
		Define parent = current.peek();
		parent.setAssets(assets);
		return null;
	}
	
	@Override
	public Code visitAssetValueInner(FP4GParser.AssetValueInnerContext ctx)
	{
		Assets parent = assets_stack.peek();
		AssetType type = ctx.assetType().type;		
		String name = (ctx.assetName != null)? ctx.assetName.getText(): null;
		String assetFile = ctx.asset.getText();
		parent.add(type,name,assetFile);
		return null;
	}
	
	@Override
	public Code visitAssetValue(FP4GParser.AssetValueContext ctx)
	{
		Assets parent = assets_stack.peek();
		AssetType type = ctx.assetType().type;		
		String name = (ctx.assetName != null)? ctx.assetName.getText(): null;
		String assetFile = ctx.asset.getText();
		if(ctx.getChildCount()>0)
		{			
			Assets assets = new Assets(type,name,assetFile);		
			assets_stack.push(assets);
			visitChildren(ctx);
			assets_stack.pop();
			
			parent.add(assets);
		}		
		else
		{
			parent.add(type,name,assetFile);
		}
			
		
		return null;		
	}
}
