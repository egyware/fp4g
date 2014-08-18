package fp4g.exceptions;

import fp4g.data.ILine;
import fp4g.log.IMessageType;

//Nota: TODOS LOS ERRORES SON RUNTIMES
public class FP4GRuntimeException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	private final IMessageType type;	
	private final String reason;	
	private final int line;
	public FP4GRuntimeException(IMessageType type,  String reason)
	{
		this(type,-1,reason);
	}
	public FP4GRuntimeException(IMessageType type, String reason,Throwable parent)
	{
		this(type, -1, reason, parent);
	}
	public FP4GRuntimeException(IMessageType type, ILine line,  String reason)
	{	
		super(type.getMessage());
		this.type   = type;		
		this.reason = reason;
		this.line = line.getLine();
	}	
	public FP4GRuntimeException(IMessageType type, int line,  String reason)
	{	
		super(type.getMessage());
		this.type   = type;		
		this.reason = reason;
		this.line = line;
	}	
	public FP4GRuntimeException(IMessageType type, int line,  String reason,Throwable parent)
	{
		super(type.getMessage(),parent);
		this.type   = type;
		this.reason = reason;
		this.line = line;
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
	public int getLine() 
	{
		return line;
	}
}
