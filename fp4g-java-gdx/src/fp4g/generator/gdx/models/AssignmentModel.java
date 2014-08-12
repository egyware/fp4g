package fp4g.generator.gdx.models;

import fp4g.data.Statement;
import fp4g.generator.StatementModel;

public class AssignmentModel extends StatementModel 
{
	private final String varName;
	private final String expresion;
	
	public AssignmentModel(String varName, String expresion) 
	{
		super(Statement.Type.Assignment);
		this.varName = varName;
		this.expresion = expresion;
	}
	public final String getVarName() {
		return varName;
	}
	public final String getExpresion() {
		return expresion;
	}

}
