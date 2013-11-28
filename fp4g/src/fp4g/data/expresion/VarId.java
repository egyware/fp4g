package fp4g.data.expresion;

import fp4g.data.Expresion;

/*
 * Una expresión que indica que se ha usado una variable.
 */
public class VarId extends Expresion{
	public final String varName;
	public VarId(String name)
	{
		this.varName = name;
	}
}
