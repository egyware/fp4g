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

/**
 * @author Edgardo
 * @param <T>
 *
 */
public abstract class ExpresionGenerator {
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
	
	protected abstract String expr2string(Expresion expr);
		
	public static String generate(Expresion expr)
	{		
		//System.err.println(expr.getClass().getSimpleName());
		ExpresionGenerator eg = generator.get(expr.getClass());		
		if(eg != null)
		{
			if(expr.hasPar())
			{
				return String.format("(%s)",eg.expr2string(expr));
			}
			else
			{
				return eg.expr2string(expr);
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
		protected String expr2string(Expresion expr) {
			VarId var = (VarId)expr;			
			return var.varName;
		}		
	}
	
	private static class LiteralExprGen extends ExpresionGenerator
	{
		@Override
		protected String expr2string(Expresion expr) {
			Literal<?> literal = (Literal<?>)expr;			
			return literal.value.toString();
		}		
	}
	
	private static class FunctionCallExprGen extends ExpresionGenerator
	{
		@Override
		protected String expr2string(Expresion expr) {			
			Expresion resultExpr = FunctionGenerator.generate((FunctionCall)expr);
			if(resultExpr != null)
			{
				return generate(resultExpr);
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
		protected String expr2string(Expresion expr) {
			DirectCode direct = (DirectCode)expr;			
			return direct.code;
		}		
	}
	
	private static class UnaryExprGen extends ExpresionGenerator
	{
		@Override
		protected String expr2string(Expresion expr) {
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
			builder.append(generate(un.expr));			
			return builder.toString();
		}		
	}
	
	private static class BinaryExprGen extends ExpresionGenerator
	{
		@Override
		protected String expr2string(Expresion expr) {
			BinaryOp bin = (BinaryOp)expr;
			StringBuilder builder = new StringBuilder();
			builder.append(generate(bin.left));
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
			builder.append(generate(bin.right));						
			return builder.toString();
		}		
	}

}
