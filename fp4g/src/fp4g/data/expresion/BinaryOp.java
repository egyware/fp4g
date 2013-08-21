package fp4g.data.expresion;

import fp4g.data.Expresion;

public class BinaryOp extends Expresion{
	public static enum Type
	{
		Add,
		Sub,
		Div,
		Mult
	}
	public final Type type;
	public final Expresion left;
	public final Expresion right;
	public BinaryOp(Type type,Expresion left,Expresion right)
	{
		this.type = type;
		this.left = left;
		this.right = right;
	}
}
