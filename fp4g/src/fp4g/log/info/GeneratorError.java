package fp4g.log.info;

public enum GeneratorError implements ErrorType 
{
	CriticalErrorGeneratorNotFound,		
	CompilerNotFound, ExpresionGeneratorError,
	;
	private final String message;
	private GeneratorError()
	{
		message = this.name();
	}
	private GeneratorError(String msg)		
	{		
		message = msg;
	}	
	
	@Override
	public String getMessage()
	{	
		return message;
	}
}
