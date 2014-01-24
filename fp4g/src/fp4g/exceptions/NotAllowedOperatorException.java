package fp4g.exceptions;

import fp4g.data.IValue;
import fp4g.data.expresion.BinaryOp.Type;

public class NotAllowedOperatorException extends CannotEvalException 
{
	public NotAllowedOperatorException(IValue<?> literal, Type mult) 
	{
		super(null);
	}

	private static final long serialVersionUID = 1L;
	

}
