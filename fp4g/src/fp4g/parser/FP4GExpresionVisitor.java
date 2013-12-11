/**
 * 
 */
package fp4g.parser;

import static fp4g.Log.Show;

import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import fp4g.Log.ErrType;
import fp4g.data.Define;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.expresion.ArrayMap;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.ClassMap;
import fp4g.data.expresion.CustomClassMap;
import fp4g.data.expresion.CustomMap;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.Map;
import fp4g.data.expresion.UnaryOp;
import fp4g.data.expresion.ValueLiteral;
import fp4g.data.expresion.VarDot;
import fp4g.data.expresion.VarId;

/**
 * @author Edgardo
 *
 */
public class FP4GExpresionVisitor extends FP4GBaseVisitor<Expresion> 
{
	private final Stack<Stack<Expresion>> stacks = new Stack<Stack<Expresion>>();
	private final Stack<Map> array_stack = new Stack<Map>();
	private Stack<Expresion> stack;		
	private ExprList exprList;
	private final Stack<Define> current;
	
	public FP4GExpresionVisitor(Stack<Define> d)
	{
		current = d;
	}
	
	
	public void pushStack()
	{
		if(stack == null)
		{
			stack = new Stack<Expresion>();
		}
		else
		{
			stacks.push(stack);
			stack = new Stack<Expresion>();
		}
	}
	public Stack<Expresion> pop()
	{
		Stack<Expresion> old = stack;
		stack = null;
		if(!stacks.empty())
		{
			stack = stacks.pop();
		}
		return old;
	}
	
	@Override
	public Expresion visitExprList(FP4GParser.ExprListContext ctx)
	{
		pushStack();
		visitChildren(ctx);
		exprList = new ExprList(stack.size());
		
		//añadimos todas las expresiones				
		while(!stack.isEmpty())
		{
			final Expresion expr = stack.pop();		
			exprList.addFirst(expr);				
		}	
		pop();
		return null;		
	}
	
	@Override
    public Expresion visitChildren(RuleNode node)
	{
         Expresion result = defaultResult();
         int n = node.getChildCount();
         for (int i=0; i<n; i++) 
         {
                 ParseTree c = node.getChild(i);
                 Expresion childResult = c.accept(this);
                 if(childResult != null)
                 {
                	 stack.push(childResult);
                 }                     
         }
         return result;
    }

	//numeric expresion!
	@Override
	public Expresion visitMinusNExpr(FP4GParser.MinusNExprContext ctx)
	{
		visitChildren(ctx.op);
		Expresion expr = stack.pop();
		UnaryOp unaryExpr = new UnaryOp(UnaryOp.Type.Minus,expr);
		
		return unaryExpr;		
	}
	
	@Override
	public Expresion visitParNExpr(FP4GParser.ParNExprContext ctx)
	{		
		visit(ctx.op);
		stack.peek().setPar(true); //establecemos que esta expresiï¿½n, lleva parentesis
				
		return null;
	}	
	
	@Override
	public Expresion visitMultNExpr(FP4GParser.MultNExprContext ctx)
	{	
		Expresion left,right;
		visit(ctx.left);
		visit(ctx.right);
		
		left = stack.pop();
		right = stack.pop();		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Mult,right,left);
			
		return binaryExpr;
	}
	
	@Override
	public Expresion visitDivNExpr(FP4GParser.DivNExprContext ctx)
	{
		Expresion left,right;
		visit(ctx.left);
		visit(ctx.right);
		
		left = stack.pop();
		right = stack.pop();
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Div,right,left);
		
		return binaryExpr;
	}
	
	@Override
	public Expresion visitAddNExpr(FP4GParser.AddNExprContext ctx)
	{		
		Expresion left,right;
		visit(ctx.left);
		visit(ctx.right);
		
		left = stack.pop();
		right = stack.pop();
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Add,right,left);
		
		return binaryExpr;
	}
	
	@Override
	public Expresion visitSubNExpr(FP4GParser.SubNExprContext ctx)
	{
		Expresion left,right;
		visit(ctx.left);
		visit(ctx.right);
		
		left = stack.pop();
		right = stack.pop();
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Sub,right,left);
		
		return binaryExpr;
	}
	
	@Override
	public Expresion visitIntLiteral(FP4GParser.IntLiteralContext ctx)
	{
		Integer integer = Integer.valueOf(ctx.getText());
		Literal<Integer> literal = new ValueLiteral<Integer>(integer);
		
		return literal;
	}
	
	@Override
	public Expresion visitDecimalLiteral(FP4GParser.DecimalLiteralContext ctx)
	{
		Float integer = Float.valueOf(ctx.getText());
		Literal<Float> literal = new ValueLiteral<Float>(integer);
				
		return literal;
	}

	@Override
	public Expresion visitVarNExpr(FP4GParser.VarNExprContext ctx)
	{		
		super.visitVarNExpr(ctx);
		return null;
	}
	
	//logical expresion
	@Override
	public Expresion visitNotLExpr(FP4GParser.NotLExprContext ctx)
	{
		visit(ctx.op);		
		Expresion expr = stack.pop();		
		UnaryOp unaryExpr = new UnaryOp(UnaryOp.Type.Not,expr);
 
		return unaryExpr;
	}
	
	@Override
	public Expresion visitParLExpr(FP4GParser.ParLExprContext ctx)
	{		
		visit(ctx.op);
		stack.peek().setPar(true); //establecemos que esta expresiï¿½n, lleva parentesis
				
		return null;
	}	
	
	@Override 
	public Expresion visitBoolLiteral(FP4GParser.BoolLiteralContext ctx)
	{
		boolean bool = Boolean.parseBoolean(ctx.BOOL_LITERAL().getText());
		Literal<Boolean> literal = new ValueLiteral<Boolean>(bool);
				
		return literal;
	}
	

	@Override
	public Expresion visitVarLExpr(FP4GParser.VarLExprContext ctx)
	{		
		super.visitVarLExpr(ctx);
		return null;
	}
	
	
	
	//otros visitors
	//TODO más adelante seguir reorganizando según lado.
	@Override
	public Expresion visitFunctionCallExpr(FP4GParser.FunctionCallExprContext ctx)
	{
		//guardamos el actual stack!
		pushStack();
		
		String callName = ctx.functionName.getText();
		
		visit(ctx.exprList()); //acá se crea un nuevo stack!
				
		FunctionCall functionCall = new FunctionCall(callName,exprList);
		exprList = null;		
		
		//restablecemos el stack anterior
		pop();		
				
		return functionCall;
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public Expresion visitArray(FP4GParser.ArrayContext ctx)
	{		
		Map map = null;		
		if(ctx.bean != null)
		{			
			ClassLoader cl = getClass().getClassLoader();
			try {
				Class<?> clazz = cl.loadClass(String.format("fp4g.classes.%s",ctx.bean));
				if(CustomMap.class.isAssignableFrom(clazz))
				{
					map = new CustomClassMap((Class<? extends CustomMap>) clazz);
				}
				else
				{
					map = new ClassMap(clazz);
				}
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
		
		return (Expresion)map;
	}
	
	@Override
	public Expresion visitParArray(FP4GParser.ParArrayContext ctx)
	{
		String key = ctx.key;
		
		pushStack();
		super.visitParArray(ctx);

		Expresion expr = stack.pop();
		pop();
		
		Map array = array_stack.peek();
		if(expr instanceof Literal)
		{
			array.set(key, (Literal<?>) expr);
		}
		else
		{
			array.set(key,FP4GDataVisitor.eval(current.peek(),expr));
		}		
		return null;		
	}
	

	@Override
	public Expresion visitStringLiteral(FP4GParser.StringLiteralContext ctx)
	{
		String string = ctx.STRING_LITERAL().getText();
		string = string.substring(1, string.length()-1);
		Literal<String> literal = new ValueLiteral<String>(string);
				
		return literal;
	}
	
	@Override
	public Expresion visitDirectCode(FP4GParser.DirectCodeContext ctx)
	{
		String code = ctx.DIRECTCODE().getText();
		code = code.substring(2,code.length()-1);
		DirectCode dc = new DirectCode(code);
			
		return dc;
	}
	
	@Override
	public Expresion visitAccessVarOperator(FP4GParser.AccessVarOperatorContext ctx)
	{
		super.visitAccessVarOperator(ctx);
		VarId property = (VarId)stack.pop();
		VarDot dot = new VarDot(ctx.varName.getText(), property);		
		return dot;
	}
	
	@Override
	public Expresion visitAccessVar(FP4GParser.AccessVarContext ctx)
	{
		VarId varId = new VarId(ctx.varName.getText());		
		return varId;
	}	
}
