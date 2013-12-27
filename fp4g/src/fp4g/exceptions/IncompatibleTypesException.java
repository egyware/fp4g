package fp4g.exceptions;

import fp4g.data.Expresion;

public class IncompatibleTypesException extends CannotEvalException {

	public IncompatibleTypesException(Throwable e, Expresion expr) {
		super(e, expr);		
	}
	
	public IncompatibleTypesException(Expresion expr) {
		super(expr);		
	}
	
	private static final long serialVersionUID = 1L;
	

}
