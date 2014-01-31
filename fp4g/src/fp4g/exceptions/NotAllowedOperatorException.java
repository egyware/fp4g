package fp4g.exceptions;

import fp4g.Log.ErrType;
import fp4g.data.IValue;
import fp4g.data.expresion.BinaryOp.Type;

public class NotAllowedOperatorException extends FP4GRuntimeException
{
	public NotAllowedOperatorException(IValue<?> literal, Type operatorType) 
	{
		super(ErrorType.NotAllowedOperation, String.format("Operación %s no valida para %s", operatorType.name(), literal.getClass().getSimpleName()));
	}
	
	public NotAllowedOperatorException(IValue<?> literal, Type operatorType,Throwable t) 
	{
		super(ErrorType.NotAllowedOperation, String.format("Operación %s no valida para %s", operatorType.name(), literal.getClass().getSimpleName()),t);
	}

	private static final long serialVersionUID = 1L;
	

}
