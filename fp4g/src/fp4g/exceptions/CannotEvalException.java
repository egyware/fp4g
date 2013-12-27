package fp4g.exceptions;

import fp4g.data.Expresion;

public class CannotEvalException extends Exception 
{
	public CannotEvalException(Throwable e, Expresion expr) 
	{
		super(String.format("No se pudo evaluar la expresion %s", expr.toString()),e);
	}
	public CannotEvalException(Expresion expr) 
	{
		super(String.format("No se pudo evaluar la expresion %s", expr.toString()));
	}

	private static final long serialVersionUID = 1L;

}
