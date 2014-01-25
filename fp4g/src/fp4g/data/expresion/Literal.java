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
	
	
	@Override
	public IValue<?> get(String name)
	{
		return null;
	}
	
	@Override
	final public IValue<?> getParent() throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Div);
	}
}
