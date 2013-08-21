/**
 * 
 */
package fp4g.parser;

import java.util.Stack;

import static fp4g.Log.Show;
import fp4g.Log.ErrType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.expresion.BinaryOp;
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
	private Stack<Expresion> expr_stack;
	private ExprList exprList;
	public FP4GDataVisitor(Game game)
	{
		this.game = game;
		current = new Stack<>();
		expr_stack = new Stack<>();
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
		  		//TODO: No implementado aún
		  		Show(ErrType.NotImplement);
				throw new RuntimeException("No implementado");
		  		//break;		  		
		  	default:
		  		Show(ErrType.UnknowError);		  		
		  	break;
		 }
		define.setLine(define_ctx.getStart().getLine());
		parent.addDefine(define);
		  
		current.push(define);		
		super.visitDefineValues(ctx);
		current.pop();		
		
		return null;		
	}
	
	@Override
	public Void visitAdd(FP4GParser.AddContext ctx)
	{
		Define parent = current.peek();
		
		Add add = new Add(ctx.type,ctx.addName);
		add.setLine(ctx.getStart().getLine());
		
		parent.addADD(add);		
		return super.visitAdd(ctx); 		
	}
	
	 
	
	@Override
	public Void visitExprList(FP4GParser.ExprListContext ctx)
	{			
		//se asume que no se visitará concurrentemente a ExprList
		exprList = new ExprList();
		super.visitExprList(ctx);
		//añadimos todas las expresiones
		
		if(!expr_stack.isEmpty())
		{
			for(Expresion expr = expr_stack.pop(); !expr_stack.isEmpty(); expr = expr_stack.pop())
			{
				exprList.add(expr);
				System.err.println(expr.getClass().getSimpleName());
			}
		}
		
		return null;
	}
	
	@Override
	public Void visitMultExpr(FP4GParser.MultExprContext ctx)
	{	
		Expresion left,right;
		visit(ctx.left);
		visit(ctx.right);
		
		right = expr_stack.pop();
		left = expr_stack.pop();
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
		
		right = expr_stack.pop();
		left = expr_stack.pop();
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
		
		right = expr_stack.pop();
		left = expr_stack.pop();
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
		
		right = expr_stack.pop();
		left = expr_stack.pop();
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Div,right,left);
		expr_stack.push(binaryExpr);		
		
		return null;
	}	
	@Override
	public Void visitParExpr(FP4GParser.ParExprContext ctx)
	{
		//TODO será bueno añadir esta expresión a una clase parentesis?
		visit(ctx.op);
				
		return null;
	}	
	@Override
	public Void visitMinusExpr(FP4GParser.MinusExprContext ctx)
	{
		//TODO
		return null;
	}	
	@Override
	public Void visitNotExpr(FP4GParser.NotExprContext ctx)
	{
		//TODO 
		return null;
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
	public Void visitId(FP4GParser.IdContext ctx)
	{
		String id = ctx.ID().getText();
		VarId varId = new VarId(id);
		expr_stack.push(varId);
		
		return null;
	}
}
