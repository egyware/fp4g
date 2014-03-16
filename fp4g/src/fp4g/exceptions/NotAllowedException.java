package fp4g.exceptions;

import fp4g.data.ICode;
import fp4g.log.info.NotAllowed;

public class NotAllowedException extends FP4GRuntimeException 
{
	private static final long serialVersionUID = 1L;

	public NotAllowedException(NotAllowed type,ICode code, String reason) 
	{
		super(type, reason);		
	}
	
	public NotAllowedException(NotAllowed type,ICode code, String reason,Throwable t) 
	{
		super(type, reason,t);	
	}

}
