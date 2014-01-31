package fp4g.exceptions;

import fp4g.data.IValue;
import fp4g.data.expresion.BinaryOp.Type;
import fp4g.log.info.CannotEval;

public class NotAllowedOperatorException extends FP4GException
{
	public NotAllowedOperatorException(IValue<?> literal, Type operatorType) 
	{
		super(CannotEval.NotAllowedOperation, String.format("Operación %s no valida para %s", operatorType.name(), literal.getClass().getSimpleName()));
	}
	
	public NotAllowedOperatorException(IValue<?> literal, Type operatorType,Throwable t) 
	{
		super(CannotEval.NotAllowedOperation, String.format("Operación %s no valida para %s", operatorType.name(), literal.getClass().getSimpleName()),t);
	}

	private static final long serialVersionUID = 1L;
	

}
