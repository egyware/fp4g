package fp4g.exceptions;

import fp4g.data.Expresion;
import fp4g.log.info.CannotEval;

public class IncompatibleTypesException extends CannotEvalException {

	public IncompatibleTypesException(Expresion expr, Throwable e) {
		super(CannotEval.IncomplatibleTypes,expr,"Tipos incomplatibles",e);		
	}
	
	public IncompatibleTypesException(Expresion expr) 
	{
		super(CannotEval.IncomplatibleTypes,expr,"Tipos incomplatibles");
	}
	
	private static final long serialVersionUID = 1L;
	

}
