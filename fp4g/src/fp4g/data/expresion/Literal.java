package fp4g.data.expresion;

import fp4g.data.Expresion;

public abstract class Literal<T> extends Expresion{
	public abstract T getValue();
}
