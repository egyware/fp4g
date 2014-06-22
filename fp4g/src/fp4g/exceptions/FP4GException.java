package fp4g.exceptions;

import fp4g.log.IMessageType;


public class FP4GException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private final IMessageType type;	
	private final String reason;
	protected FP4GException(IMessageType type, String reason)
	{	
		super(type.getMessage().concat(": ").concat(reason));
		this.type = type;		
		this.reason = reason;
	}	
	protected FP4GException(IMessageType type, String reason,Throwable parent)
	{
		super(type.getMessage(),parent);
		this.type = type;
		this.reason = reason;
	}
	
	public final IMessageType getType() 
	{
		return type;
	}	
	public final String getReason() 
	{
		return reason;
	}

}
