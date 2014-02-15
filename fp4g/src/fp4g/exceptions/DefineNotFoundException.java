/**
 * 
 */
package fp4g.exceptions;

import fp4g.data.DefineType;
import fp4g.log.info.Warn;

/**
 * @author Edgardo
 *
 */
public class DefineNotFoundException extends FP4GRuntimeException
{
	public DefineNotFoundException(DefineType type, String defineName) 
	{
		super(Warn.DefineNotFound, String.format("No se encontro el define \"%s\" de tipo %s",defineName,type.name()));	
	}
	
	public DefineNotFoundException(DefineType type,String defineName, Throwable parent) 
	{
		super(Warn.DefineNotFound, String.format("No se encontro el define \"%s\" de tipo %s",defineName,type.name()),parent);		
	}
	
	public DefineNotFoundException(String defineName) 
	{
		super(Warn.DefineNotFound, String.format("No se encontro el define \"%s\"",defineName));	
	}
	
	public DefineNotFoundException(String defineName, Throwable parent) 
	{
		super(Warn.DefineNotFound, String.format("No se encontro el define \"%s\"",defineName),parent);		
	}
	
	private static final long serialVersionUID = 1L;	
}
