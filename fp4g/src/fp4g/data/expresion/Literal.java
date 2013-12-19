package fp4g.data.expresion;

import fp4g.data.Define;
import fp4g.data.Expresion;

public abstract class Literal<T> extends Expresion{
	public abstract T getValue();
	
	
	@Override
	public Literal<?> eval(Define define) 
	{
		return this;
	}
}
