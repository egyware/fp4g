package fp4g.data.expresion;

import fp4g.data.Expresion;

public class UnaryOp extends Expresion{	
	public static enum Type
	{
		Not,
		Minus
	}
	public final Type type;
	public final Expresion expr;
	public UnaryOp(Type type,Expresion expr)
	{
		this.type = type;
		this.expr = expr;
	}
}
