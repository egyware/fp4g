package fp4g.data.expresion;

import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.exceptions.NotAllowedOperatorException;

public abstract class Literal<T> extends Expresion{
	public abstract T getValue();
	
	
	@Override
	public Literal<?> eval(IDefine define) 
	{
		return this;
	}
	
	public abstract Literal<?> sum(Literal<?> right) throws NotAllowedOperatorException;
	public abstract Literal<?> mult(Literal<?> right)throws NotAllowedOperatorException;
	public abstract Literal<?> div(Literal<?> right) throws NotAllowedOperatorException;
	public abstract Literal<?> sub(Literal<?> right) throws NotAllowedOperatorException;
	
}
