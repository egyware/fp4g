/**
 * 
 */
package fp4g.data.expresion;

import fp4g.core.Expresion;
import fp4g.core.IValue;

/**
 * @author Edgardo
 *
 */
public class DirectCode implements Expresion,  IValue<DirectCode> {
	public static final DirectCode EMPTY = new DirectCode("");
	
	public final String code;
	public DirectCode(String code)
	{
		this.code = code;
	}
	
	@Override
	public IValue<?> eval(IValue<?> define) 
	{
		return (IValue<?>) this;		
	}

	@Override	
	public DirectCode getValue() 
	{
		return this;
	}	
}
