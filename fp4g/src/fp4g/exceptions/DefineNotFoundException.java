/**
 * 
 */
package fp4g.exceptions;

import fp4g.data.DefineType;
import fp4g.log.FP4GWarn;

/**
 * Excepcion que ayuda a clasificar los errores.
 * 
 * Este error informa que es posible que no se encuentre un Define.
 * 
 * @author Edgardo 
 */
public class DefineNotFoundException extends FP4GException
{
	
	public DefineNotFoundException(DefineType type, String defineName) 
	{
		super(FP4GWarn.DefineNotFound, String.format("No se encontro el define \"%s\" de tipo %s",defineName,type.name()));	
	}
	
	public DefineNotFoundException(DefineType type,String defineName, Throwable parent) 
	{
		super(FP4GWarn.DefineNotFound, String.format("No se encontro el define \"%s\" de tipo %s",defineName,type.name()),parent);		
	}
	
	public DefineNotFoundException(String defineName) 
	{
		super(FP4GWarn.DefineNotFound, String.format("No se encontro el define \"%s\"",defineName));	
	}
	
	public DefineNotFoundException(String defineName, Throwable parent) 
	{
		super(FP4GWarn.DefineNotFound, String.format("No se encontro el define \"%s\"",defineName),parent);		
	}
	
	private static final long serialVersionUID = 1L;	
}
