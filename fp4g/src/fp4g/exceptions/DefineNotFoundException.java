/**
 * 
 */
package fp4g.exceptions;

import fp4g.data.DefineType;

/**
 * @author Edgardo
 *
 */
public class DefineNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DefineNotFoundException(String name)
	{
		super(String.format("No se pudo encontrar el Define: %s",name));
	}

	public DefineNotFoundException(DefineType type, String name) {
		super(String.format("No se pudo encontrar el Define(%s): %s",type.name(),name));
	}

}
