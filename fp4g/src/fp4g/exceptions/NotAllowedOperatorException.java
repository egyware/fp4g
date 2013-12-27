package fp4g.exceptions;

import fp4g.data.expresion.BinaryOp.Type;
import fp4g.data.expresion.Literal;

public class NotAllowedOperatorException extends CannotEvalException 
{
	public NotAllowedOperatorException(Literal<?> literal, Type mult) 
	{
		super(null);
	}

	private static final long serialVersionUID = 1L;
	

}
