package fp4g.data.expresion;

import fp4g.data.Expresion;

public class Literal<Type> extends Expresion{
	public final Type value;
	public Literal(Type value)
	{
		this.value = value;
	}
}
