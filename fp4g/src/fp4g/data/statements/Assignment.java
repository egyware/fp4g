package fp4g.data.statements;

import fp4g.data.Expresion;
import fp4g.data.Statement;

public class Assignment extends Statement
{
	public final String varName;
	public final Expresion expresion;
	
	public Assignment(String varName, Expresion expresion)
	{
		super(Statement.Type.Assignment);
		this.varName = varName;
		this.expresion = expresion;
	}

}
