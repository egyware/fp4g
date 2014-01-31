package fp4g.exceptions;

import fp4g.data.Expresion;

public class IncompatibleTypesException extends CannotEvalException {

	public IncompatibleTypesException(Expresion expr, Throwable e) {
		super(expr,"Tipos incomplatibles",e);		
	}
	
	public IncompatibleTypesException(Expresion expr) 
	{
		super(expr,"Tipos incomplatibles");
	}
	
	private static final long serialVersionUID = 1L;
	

}
