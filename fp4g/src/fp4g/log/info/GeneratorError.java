package fp4g.log.info;

import fp4g.log.ErrorType;

public enum GeneratorError implements ErrorType 
{
	CriticalErrorGeneratorNotFound,		
	CompilerNotFound,
	ExpresionGeneratorError,
	CannotParseFile,
	IllegalState,
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
