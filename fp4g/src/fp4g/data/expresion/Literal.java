package fp4g.data.expresion;

import fp4g.data.Expresion;
import fp4g.data.IValue;
import fp4g.exceptions.NotAllowedOperatorException;

public abstract class Literal<T> extends Expresion implements IValue<T> 
{	
	@Override
	public IValue<?> eval(IValue<?> define) 
	{
		return this;
	}
	
	public abstract IValue<?> sum(IValue<?> right) throws NotAllowedOperatorException;
	public abstract IValue<?> mult(IValue<?> right)throws NotAllowedOperatorException;
	public abstract IValue<?> div(IValue<?> right) throws NotAllowedOperatorException;
	public abstract IValue<?> sub(IValue<?> right) throws NotAllowedOperatorException;
	
}
