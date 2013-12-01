package fp4g.generator.gdxgenerator;

import static fp4g.Log.Show;

import java.util.HashMap;
import java.util.Map;

import fp4g.Log.ErrType;
import fp4g.data.Expresion;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.UnaryOp;
import fp4g.data.expresion.ValueLiteral;
import fp4g.data.expresion.VarId;
import fp4g.generator.ExpresionGenerator;
import fp4g.generator.models.JavaCodeModel;

/**
 * @author Edgardo
 * @param <T>
 *
 */
public class JavaExpresionGenerator extends ExpresionGenerator<JavaGenerator,JavaCodeModel> 
{
	private final  Map<Class<?>, EG_Expresion> expresions = new HashMap<>(6,1);
	
	public JavaExpresionGenerator(JavaGenerator generator) {
		super(generator);
		
		expresions.put(VarId.class, new VarExprGen());
		expresions.put(ValueLiteral.class, new LiteralExprGen());
		expresions.put(UnaryOp.class, new UnaryExprGen());
		expresions.put(BinaryOp.class, new BinaryExprGen());
		expresions.put(FunctionCall.class, new FunctionCallExprGen());
		expresions.put(DirectCode.class, new DirectCodeExprGen());
	}
	
	private abstract class EG_Expresion
	{
		public abstract String expr2string(JavaCodeModel model,Expresion expr);
	}
	
	@Override
	public String generate(JavaCodeModel model, Expresion expr) 
	{		
		
		EG_Expresion eg = expresions.get(expr.getClass());		
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
			Show(ErrType.ExpresionGeneratorNotFound,expr.getClass().getSimpleName());
			return null;
		}
	}
	
	private class VarExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaCodeModel model, Expresion expr) {
			VarId var = (VarId)expr;			
			return var.varName;
		}		
	}
	
	private class LiteralExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaCodeModel model,Expresion expr) {
			final ValueLiteral<?> literal = (ValueLiteral<?>)expr;
			final Object value = literal.getValue();
			if(value instanceof String)
			{
				return String.format("\"%s\"",value);
			}
			else
			{
				return value.toString();
			}
		}		
	}
	
	private class FunctionCallExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaCodeModel model, Expresion expr) {			
			Expresion resultExpr = generator.function(model,(FunctionCall)expr);
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
	
	private class DirectCodeExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaCodeModel model, Expresion expr) {
			DirectCode direct = (DirectCode)expr;			
			return direct.code;
		}		
	}
	
	private class UnaryExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaCodeModel model,Expresion expr) {
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
	
	private class BinaryExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaCodeModel model,Expresion expr) {
			BinaryOp bin = (BinaryOp)expr;
			StringBuilder builder = new StringBuilder();
			builder.append(generate(model, bin.left));
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
			builder.append(generate(model, bin.right));						
			return builder.toString();
		}		
	}


	

}
