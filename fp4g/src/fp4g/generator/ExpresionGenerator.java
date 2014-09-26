package fp4g.generator;

import fp4g.data.Container;
import fp4g.data.Expresion;
import fp4g.data.IValue;
import fp4g.exceptions.CannotEvalException;

/**
 * @author Edgardo
 * @param <T>
 *
 */
public abstract class ExpresionGenerator <M extends MetaSourceModel, T extends Generator<M>>
{
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
	
	
	public abstract String generate(M model, Container container, IValue<?> expr) throws CannotEvalException;
	public abstract String generate(M model, Container container, Expresion expr) throws CannotEvalException;

}
