package fp4g.data.expresion;

import fp4g.data.Expresion;
import fp4g.data.IValue;

public abstract class Literal<T> extends Expresion implements IValue<T> 
{	
	@Override
	public IValue<?> eval(IValue<?> define) 
	{
		return this;
	}	
}
