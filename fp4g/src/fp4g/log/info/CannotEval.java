package fp4g.log.info;

public enum CannotEval implements ErrorType
{
	CannotEvalExpresion,
	VarNameNotFound,
	NotAllowedOperation, 
	IncomplatibleTypes, 
	IsNotAValidExpresion,
	ExpresionGeneratorNotFound,
	FunctionNotFound;
	
	
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


