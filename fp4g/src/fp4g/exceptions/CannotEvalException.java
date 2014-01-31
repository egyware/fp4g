package fp4g.exceptions;

import fp4g.data.Expresion;
import fp4g.data.IValue;
import fp4g.log.info.CannotEval;

public class CannotEvalException extends FP4GException 
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

	public CannotEvalException(CannotEval type,	IValue<?> value, String reason)
	{
		super(type,reason);
		cannotEvalued = null;
	}
	public CannotEvalException(CannotEval type,	IValue<?> value, String reason,Throwable t)
	{
		super(type,reason, t);
		cannotEvalued = null;
	}

	public Expresion getExpresion() {
		return cannotEvalued;
	}
}
