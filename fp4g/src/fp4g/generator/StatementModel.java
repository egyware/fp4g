package fp4g.generator;

import fp4g.data.Statement;

public abstract class StatementModel 
{
	private final Statement.Type type;
	public StatementModel(Statement.Type type)
	{
		this.type = type;
	}
	
	public int getType()
	{
		return type.ordinal();
	}
}
