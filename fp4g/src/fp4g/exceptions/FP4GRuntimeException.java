package fp4g.exceptions;

import fp4g.log.IMessageType;




public class FP4GRuntimeException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	private final IMessageType type;	
	private final String reason;
	public FP4GRuntimeException(IMessageType type, String reason)
	{	
		super(type.getMessage());
		this.type = type;		
		this.reason = reason;
	}	
	public FP4GRuntimeException(IMessageType type, String reason,Throwable parent)
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
	
	public String getMessage()
	{
		return super.getMessage().concat(": ").concat(reason);
	}
}
