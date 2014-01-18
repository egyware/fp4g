package fp4g;

public class FP4GException extends RuntimeException {
	private static final long serialVersionUID = 609957569087114865L;
	private Log.MessageType message;
	public FP4GException(Log.MessageType m)
	{
		message = m;
	}
	public Log.MessageType getError()
	{
		return message;
	}
	
}
