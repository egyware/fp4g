package fp4g.data.define;

import fp4g.data.ICode;
import fp4g.exceptions.FP4GRuntimeException;
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
