/**
 * 
 */
package fp4g.data.expresion;

import fp4g.data.Expresion;
import fp4g.data.IValue;

/**
 * @author Edgardo
 *
 */
public class DirectCode extends Expresion implements IValue<DirectCode> {
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
