package fp4g.exceptions;

import fp4g.log.info.GeneratorError;

public class GeneratorException extends FP4GException 
{
	private static final long serialVersionUID = 1L;
	public GeneratorException(GeneratorError error,String message)
	{
		super(error,message);
	}

}
