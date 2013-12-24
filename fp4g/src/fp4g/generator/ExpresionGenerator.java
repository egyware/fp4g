package fp4g.generator;

import fp4g.data.Expresion;

/**
 * @author Edgardo
 * @param <T>
 *
 */
public abstract class ExpresionGenerator <T extends Generator,M extends Model> {
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
	
	public abstract String generate(M model,Expresion expr);

}
