package fp4g.data.expresion;

import fp4g.data.Expresion;

/*
 * Una expresión que indica que se ha usado una variable.
 */
public class VarExpr extends Expresion{
	public final String varName;
	public VarExpr(String name)
	{
		this.varName = name;
	}
}
