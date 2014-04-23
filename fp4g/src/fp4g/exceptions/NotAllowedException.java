package fp4g.exceptions;

import fp4g.data.ILine;
import fp4g.log.info.NotAllowed;

public class NotAllowedException extends FP4GRuntimeException 
{
	private static final long serialVersionUID = 1L;

	//TODO Va servir de algo el ILine Code
	public NotAllowedException(NotAllowed type,ILine code, String reason) 
	{
		super(type, reason);		
	}
	
	public NotAllowedException(NotAllowed type,ILine code, String reason,Throwable t) 
	{
		super(type, reason,t);	
	}

}
