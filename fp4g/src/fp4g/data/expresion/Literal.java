package fp4g.data.expresion;

import fp4g.core.Expresion;
import fp4g.core.IValue;

public abstract class Literal<T> implements Expresion, IValue<T> 
{	
	@Override
	public IValue<?> eval(IValue<?> define) 
	{
		return this;
	}	
}
