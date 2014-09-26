package fp4g.data.expresion;

import fp4g.data.Expresion;
import fp4g.data.IValue;

public abstract class Literal<T> implements Expresion, IValue<T> 
{	
	@Override
	public IValue<?> eval(IValue<?> define) 
	{
		return this;
	}	
}
