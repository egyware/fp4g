package fp4g.generator.gdx;

import java.util.HashMap;
import java.util.Map;

import fp4g.data.Expresion;
import fp4g.data.IValue;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.UnaryOp;
import fp4g.data.expresion.VarId;
import fp4g.data.expresion.literals.BoolLiteral;
import fp4g.data.expresion.literals.FloatLiteral;
import fp4g.data.expresion.literals.IntegerLiteral;
import fp4g.data.expresion.literals.ObjectLiteral;
import fp4g.data.expresion.literals.StringLiteral;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.ExpresionGenerator;
import fp4g.generator.gdx.models.JavaCodeModel;
import fp4g.log.info.CannotEval;

/**
 * @author Edgardo
 * @param <T>
 *
 */
public class JavaExpresionGenerator extends ExpresionGenerator<JavaGenerator,JavaCodeModel> 
{
	private final  Map<Class<?>, EG_Expresion> expresions = new HashMap<Class<?>, EG_Expresion>(6,1);
	
	public JavaExpresionGenerator(JavaGenerator generator) {
		super(generator);
		
		final LiteralExprGen litgen = new LiteralExprGen();
		expresions.put(VarId.class, new VarExprGen());
		expresions.put(BoolLiteral.class, litgen);
		expresions.put(FloatLiteral.class, litgen);
		expresions.put(IntegerLiteral.class, litgen);
		expresions.put(ObjectLiteral.class, litgen);
		expresions.put(StringLiteral.class, litgen);
		expresions.put(UnaryOp.class, new UnaryExprGen());
		expresions.put(BinaryOp.class, new BinaryExprGen());
		expresions.put(FunctionCall.class, new FunctionCallExprGen());
		expresions.put(DirectCode.class, new DirectCodeExprGen());
	}
	
	private abstract class EG_Expresion
	{		
		public abstract String expr2string(JavaCodeModel model,Expresion expr) throws CannotEvalException;
	}
	
	@Override
	public String generate(JavaCodeModel model, IValue<?> value) throws CannotEvalException 
	{
		//TODO generalmente estos se les evalua y solo contiene el valor.
		//TODO esto es raro, ni yo lo entiendo.
		if(value instanceof Expresion)
		{
			Expresion expr = (Expresion)value;
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
		}		
		throw new CannotEvalException(CannotEval.IsNotAValidExpresion, value,"No se puede evualuar: ".concat(value.getClass().getSimpleName()));
	}
	
	@Override
	public String generate(JavaCodeModel model, Expresion expr) throws CannotEvalException
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
		throw new CannotEvalException(CannotEval.ExpresionGeneratorNotFound, expr,"No se puede evualuar: ".concat(expr.getClass().getSimpleName()));
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
			final Literal<?> literal = (Literal<?>)expr;
			final Object value = literal.getValue();
			if(value instanceof String)
			{
				return String.format("\"%s\"",value);
			}
			else if(value instanceof Float)
			{
				return value.toString().concat("f");
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
		public String expr2string(JavaCodeModel model, Expresion expr) throws CannotEvalException 
		{			
			Expresion resultExpr = generator.function(model,(FunctionCall)expr);
			return generate(model,resultExpr);			
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
		public String expr2string(JavaCodeModel model,Expresion expr) throws CannotEvalException
		{
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
		public String expr2string(JavaCodeModel model,Expresion expr) throws CannotEvalException
		{
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
			case Equal:
				builder.append("==");
				break;
			case LessThan:
				builder.append('<');
				break;
			case MoreThan:
				builder.append('>');
				break;
			default:
				break;	
							
			}
			builder.append(generate(model, bin.right));						
			return builder.toString();
		}		
	}


	

}
