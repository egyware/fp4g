package fp4g.generator;

import java.util.HashMap;
import java.util.Map;

import fp4g.data.Expresion;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.UnaryOp;
import fp4g.data.expresion.VarId;
import fp4g.generator.models.JavaCodeModel;

/**
 * @author Edgardo
 * @param <T>
 *
 */
public abstract class ExpresionGenerator {
	public static enum CompareExpresion
	{
		equals("=="),
		lessThan("<"),
		greaterThan(">"),
		lessEqualsThan("<="),
		greaterEqualsThan(">=")
		;
		
		final String operator;
		private CompareExpresion(String operator)
		{
			this.operator = operator;
		}
	}
	
	private static final  Map<Class<?>, ExpresionGenerator> generator = new HashMap<>(6);
	static
	{
		generator.put(VarId.class, new VarExprGen());
		generator.put(Literal.class, new LiteralExprGen());
		generator.put(UnaryOp.class, new UnaryExprGen());
		generator.put(BinaryOp.class, new BinaryExprGen());
		generator.put(FunctionCall.class, new FunctionCallExprGen());
		generator.put(DirectCode.class, new DirectCodeExprGen());
	}
	
	protected abstract String expr2string(JavaCodeModel model,Expresion expr);
		
	public static String generate(JavaCodeModel model,Expresion expr)
	{		
		//System.err.println(expr.getClass().getSimpleName());
		ExpresionGenerator eg = generator.get(expr.getClass());		
		if(eg != null)
		{
			if(expr.hasPar())
			{
				return String.format("(%s)",eg.expr2string(model,expr));
			}
			else
			{
				return eg.expr2string(model,expr);
			}			
			 
		}
		else
		{	
			//TODO: mostrar error
			return null;
		}
	}
	
	private static class VarExprGen extends ExpresionGenerator
	{
		@Override
		protected String expr2string(JavaCodeModel model,Expresion expr) {
			VarId var = (VarId)expr;			
			return var.varName;
		}		
	}
	
	private static class LiteralExprGen extends ExpresionGenerator
	{
		@Override
		protected String expr2string(JavaCodeModel model,Expresion expr) {
			final Literal<?> literal = (Literal<?>)expr;
			final Object value = literal.value;
			if(value instanceof String)
			{
				return String.format("\"%s\"",value);
			}
			else
			{
				return literal.value.toString();
			}
		}		
	}
	
	private static class FunctionCallExprGen extends ExpresionGenerator
	{
		@Override
		protected String expr2string(JavaCodeModel model,Expresion expr) {			
			Expresion resultExpr = FunctionGenerator.generate(model,(FunctionCall)expr);
			if(resultExpr != null)
			{
				return generate(model,resultExpr);
			}
			else
			{	
				//TODO: mostrar error
				return null;
			}
		}		
	}
	
	private static class DirectCodeExprGen extends ExpresionGenerator
	{
		@Override
		protected String expr2string(JavaCodeModel model,Expresion expr) {
			DirectCode direct = (DirectCode)expr;			
			return direct.code;
		}		
	}
	
	private static class UnaryExprGen extends ExpresionGenerator
	{
		@Override
		protected String expr2string(JavaCodeModel model,Expresion expr) {
			UnaryOp un = (UnaryOp)expr;
			StringBuilder builder = new StringBuilder();
			switch(un.type)
			{
			case Minus:
				builder.append('-');
				break;
			case Not:
				builder.append('!');
				break;
			default:
				break;				
			}
			builder.append(generate(model,un.expr));			
			return builder.toString();
		}		
	}
	
	private static class BinaryExprGen extends ExpresionGenerator
	{
		@Override
		protected String expr2string(JavaCodeModel model,Expresion expr) {
			BinaryOp bin = (BinaryOp)expr;
			StringBuilder builder = new StringBuilder();
			builder.append(generate(model,bin.left));
			switch(bin.type)
			{
			case Add:
				builder.append('+');
				break;
			case Div:
				builder.append('/');
				break;
			case Mult:
				builder.append('*');
				break;
			case Sub:
				builder.append('-');
				break;
			default:
				break;
							
			}
			builder.append(generate(model,bin.right));						
			return builder.toString();
		}		
	}

}
