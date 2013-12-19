/**
 * 
 */
package fp4g.data.expresion;

import fp4g.data.Define;
import fp4g.data.Expresion;

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
	public Literal<?> eval(Define define) 
	{
		throw new RuntimeException("No Implementado");
	}
}
