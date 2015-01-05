package fp4g.exceptions;

import fp4g.core.Expresion;
import fp4g.core.IValue;
import fp4g.log.FP4GError;

public class CannotEvalException extends FP4GRuntimeException 
{
	public static enum Types
	{
		CannotEvalExpresion(FP4GError.CannotEvalExpresion),			
		VarNameNotFound(FP4GError.VarNameNotFound),
		NotAllowedOperation(FP4GError.NotAllowedOperation),
		IncomplatibleTypes(FP4GError.IncomplatibleTypes), 
		CannotSetProperty(FP4GError.CannotSetProperty),
		CannotGetProperty(FP4GError.CannotGetProperty),
		FunctionNotFound(FP4GError.FunctionNotFound), 
		NotValidExpresion(FP4GError.NotValidExpresion), 
		ExpresionGeneratorNotFound(FP4GError.ExpresionGeneratorNotFound),
		;
		
		private final FP4GError error;
		private Types(FP4GError error)
		{
			this.error = error;
		}
		
		public FP4GError get()
		{
			return error;
		}
	}
	private static final long serialVersionUID = 1L;	
	private final Expresion cannotEvalued;	
	public CannotEvalException(Types type,Expresion expr, String reason) 
	{
		super(type.error, reason);
		cannotEvalued = expr;
	}

	public CannotEvalException(Types type,Expresion expr, String reason, Throwable parent) 
	{
		super(type.error, reason, parent);
		cannotEvalued = expr;
	}

	public CannotEvalException(Types type,	IValue<?> value, String reason)
	{
		super(type.error,reason);
		cannotEvalued = null;
	}
	public CannotEvalException(Types type,	IValue<?> value, String reason,Throwable t)
	{
		super(type.error,reason, t);
		cannotEvalued = null;
	}

	public CannotEvalException(Types type, Object thiz, String key,	Object value, Throwable e) 
	{		
		super(type.error,String.format("No se puede establecer:  %s[%s] =  %s", thiz.getClass().getSimpleName(), key, value.toString()), e);
		cannotEvalued = null;
	}
	public CannotEvalException(Types type, Object thiz, String key) 
	{
		super(type.error,String.format("No se puede obtener: %s[%s]", thiz.getClass().getSimpleName(), key));
		cannotEvalued = null;
	}
	public Expresion getExpresion() {
		return cannotEvalued;
	}
}
