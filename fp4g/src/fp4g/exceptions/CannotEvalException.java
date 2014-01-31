package fp4g.exceptions;

import fp4g.CannotEval;
import fp4g.data.Expresion;

public class CannotEvalException extends FP4GRuntimeException 
{
	private static final long serialVersionUID = 1L;	
	private final Expresion cannotEvalued;
	public CannotEvalException(CannotEval type,Expresion expr, String reason) 
	{
		super(type, reason);
		cannotEvalued = expr;
	}

	public CannotEvalException(CannotEval type,Expresion expr, String reason, Throwable parent) 
	{
		super(type, reason, parent);
		cannotEvalued = expr;
	}

	public Expresion getExpresion() {
		return cannotEvalued;
	}
}
