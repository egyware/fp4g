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
public class DirectCode extends Expresion {
	public final String code;
	public DirectCode(String code)
	{
		this.code = code;
	}
	
	@Override
	public IValue<?> eval(IValue<?> define) 
	{
		throw new RuntimeException("No Implementado");
	}	
}
