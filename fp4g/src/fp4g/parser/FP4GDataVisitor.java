/**
 * 
 */
package fp4g.parser;

import java.util.List;
import java.util.Stack;

import static fp4g.Log.Show;
import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.NameList;
import fp4g.data.DefineType;
import fp4g.data.On;
import fp4g.data.On.Source;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Message;
import fp4g.data.expresion.ArrayExpr;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.UnaryOp;
import fp4g.data.expresion.VarId;
import fp4g.data.expresion.Literal;



/**
 * Visita el arbol construido.
 * @author Edgardo
 *
 */
public class FP4GDataVisitor extends FP4GBaseVisitor<Void> {
	private Game game;
	private Stack<Define> current;
	private Stack<ArrayExpr> array_stack;
	private Stack<Expresion> expr_stack;
	private ExprList exprList;
	private NameList nameList;
	public FP4GDataVisitor(Game game)
	{
		this.game = game;
		current = new Stack<>();
		expr_stack = new Stack<>();
		array_stack = new Stack<>();
	}
	
	@Override 
	public Void visitSet(FP4GParser.SetContext ctx)
	{
		Define define = current.peek();
		Stack<Expresion> expr_stack = this.expr_stack;		
		this.expr_stack = new Stack<>();
		super.visitSet(ctx);
		Expresion expr = this.expr_stack.pop();
		this.expr_stack = expr_stack;
		define.set(ctx.key, expr);
		return null;
	}
	
	@Override
	public Void visitGame(FP4GParser.GameContext ctx)
	{
		game.name = ctx.name;
		game.setLine(ctx.getStart().getLine());
		return super.visitGame(ctx);		
	}
	
	@Override
	public Void visitGameValues(FP4GParser.GameValuesContext ctx)
	{
		current.push(game);		
		super.visitGameValues(ctx);		
		current.pop();
		return null;
	}	
	
	@Override
	public Void visitDefineValues(FP4GParser.DefineValuesContext ctx)
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
				//TODO: No implementado aún
				Show(ErrType.NotImplement);
				throw new RuntimeException("No implementado");
				//break;		  		
		  	case BEHAVIOR:
		  		//TODO: No implementado aún
		  		Show(ErrType.NotImplement);
				throw new RuntimeException("No implementado");
		  		//break;		  		
		  	case GOAL:
		  		//TODO: No implementado aún
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
	public Void visitOn(FP4GParser.OnContext ctx)
	{
		Define parent = current.peek();
		
		//en vez de solo crearlo, tengo que buscarlo... y si no existe crearlo.
		On on = parent.getOn(ctx.messageName);
		if(on == null)
		{		
			//en vez de usar el nombre, deberia buscar una clase del tipo Mensaje!!!
			Define message = parent.getDefine(DefineType.MESSAGE,ctx.messageName);
			if(message == null)
			{
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
		//al evento on, se crea un nuevo codigo y se le añaden los filtros, si es que existen.
		//falta solo agregarle el codigo :)
		Source source = on.addSource();
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
	public Void visitAdd(FP4GParser.AddContext ctx)
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
	public Void visitNameList(FP4GParser.NameListContext ctx)
	{
		nameList = new NameList();
		super.visitNameList(ctx);
	
		return null;		
	}
	
	@Override 
	public Void visitDeclareVar(FP4GParser.DeclareVarContext ctx)
	{
		//TODO: esta conversación de variables no deberia estár puesta aqui
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
	public Void visitExprList(FP4GParser.ExprListContext ctx)
	{	
		//ojo con el orden de estas funciones
		super.visitExprList(ctx);
		//se asume que no se visitará concurrentemente a ExprList
		exprList = new ExprList(expr_stack.size());
				
		//añadimos todas las expresiones				
		while(!expr_stack.isEmpty())
		{
			final Expresion expr = expr_stack.pop();		
			exprList.addFirst(expr);				
		}		
		
		return null;
	}
	
	@Override
	public Void visitMultExpr(FP4GParser.MultExprContext ctx)
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
	public Void visitSubExpr(FP4GParser.SubExprContext ctx)
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
	public Void visitAddExpr(FP4GParser.AddExprContext ctx)
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
	public Void visitDivExpr(FP4GParser.DivExprContext ctx)
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
	public Void visitParExpr(FP4GParser.ParExprContext ctx)
	{		
		visit(ctx.op);
		expr_stack.peek().setPar(true); //establecemos que esta expresión, lleva parentesis
				
		return null;
	}	
	@Override
	public Void visitMinusExpr(FP4GParser.MinusExprContext ctx)
	{		
		visit(ctx.op);
		Expresion expr = expr_stack.pop();
		UnaryOp unaryExpr = new UnaryOp(UnaryOp.Type.Minus,expr);
		expr_stack.push(unaryExpr);
		
		return null;
	}	
	@Override
	public Void visitNotExpr(FP4GParser.NotExprContext ctx)
	{
		visit(ctx.op);		
		Expresion expr = expr_stack.pop();		
		UnaryOp unaryExpr = new UnaryOp(UnaryOp.Type.Not,expr);
		expr_stack.push(unaryExpr);
 
		return super.visitNotExpr(ctx);
	}
	
	//literal y id
	@Override
	public Void visitDecimalLiteral(FP4GParser.DecimalLiteralContext ctx)
	{
		Float integer = Float.valueOf(ctx.getText());
		Literal<Float> literal = new Literal<Float>(integer);
		expr_stack.push(literal);
		
		return null;
	}
	@Override
	public Void visitIntLiteral(FP4GParser.IntLiteralContext ctx)
	{
		Integer integer = Integer.valueOf(ctx.getText());
		Literal<Integer> literal = new Literal<Integer>(integer);
		expr_stack.push(literal);
		
		return null;
	}
	@Override
	public Void visitStringLiteral(FP4GParser.StringLiteralContext ctx)
	{
		String string = ctx.STRING_LITERAL().getText();
		string = string.substring(1, string.length()-1);
		Literal<String> literal = new Literal<String>(string);
		expr_stack.push(literal);
		
		return null;
	}
	
	@Override
	public Void visitDirectCode(FP4GParser.DirectCodeContext ctx)
	{
		String code = ctx.DIRECTCODE().getText();
		code = code.substring(2,code.length()-1);
		DirectCode dc = new DirectCode(code);
		expr_stack.push(dc);
		
		return null;
	}
	
	@Override
	public Void visitArray(FP4GParser.ArrayContext ctx)
	{
		ArrayExpr array = new ArrayExpr();
		array_stack.push(array);
		super.visitArray(ctx);
		array_stack.pop();
		expr_stack.push(array);
		return null;
	}
	
	@Override
	public Void visitParArray(FP4GParser.ParArrayContext ctx)
	{
		String key = ctx.key;
		Stack<Expresion> expr_stack = this.expr_stack;		
		this.expr_stack = new Stack<>();
		super.visitParArray(ctx);
		Expresion expr = this.expr_stack.pop();
		this.expr_stack = expr_stack;
		
		ArrayExpr array = array_stack.peek();
		array.set(key, expr);
		
		return null;		
	}
	
	@Override
	public Void visitId(FP4GParser.IdContext ctx)
	{
		String id = ctx.ID().getText();
		VarId varId = new VarId(id);
		expr_stack.push(varId);
				
		return null;
	}
	
	@Override
	public Void visitFunctionCallExpr(FP4GParser.FunctionCallExprContext ctx)
	{
		//guardamos el actual stack!
		Stack<Expresion> prev_stack  = expr_stack;
		//nuevo stack!
		expr_stack = new Stack<>();
		String callName = ctx.functionName.getText();
		
		visit(ctx.exprList());
				
		FunctionCall functionCall = new FunctionCall(callName,exprList);
		exprList = null;		
		
		//restablecemos el stack anterior
		expr_stack = prev_stack;		
		expr_stack.push(functionCall);
		
		return null;
	}
}
