package fp4g;

public enum CannotEval implements ErrorType
{
	CannotEvalExpresion,
	VarNameNotFound,
	NotAllowedOperation;
	
	
	private final String message;
	private CannotEval()
	{
		message = this.name();
	}
	private CannotEval(String msg)		
	{		
		message = msg;
	}	
	
	@Override
	public String getMessage()
	{	
		return message;
	}
	
}


