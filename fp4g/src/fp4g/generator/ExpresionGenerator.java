package fp4g.generator;

import java.util.HashMap;
import java.util.Map;

import fp4g.data.Code;
import fp4g.data.Expresion;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.UnaryOp;
import fp4g.data.expresion.VarId;
import fp4g.generator.FunctionGenerator;
import fp4g.generator.models.JavaCodeModel;

/**
 * @author Edgardo
 * @param <T>
 *
 */
public abstract class ExpresionGenerator <T extends Generator,Model> {
	protected final T generator;
	
	public static enum CompareExpresion
	{
		equals("=="),
		lessThan("<"),
		greaterThan(">"),
		lessEqualsThan("<="),
		greaterEqualsThan(">=")
		;
		
		public final String operator;
		private CompareExpresion(String operator)
		{
			this.operator = operator;
		}
	}
	
	public ExpresionGenerator(T generator)
	{
		this.generator = generator;
	}
	
	public abstract String generate(Code parent,Model model,Expresion expr);

}
