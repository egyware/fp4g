package fp4g.generator.gdx.models;

import fp4g.generator.Model;

public abstract class StatementModel implements Model 
{
	public static enum Type
	{
		SendStatement
	}
	private final Type type;
	public StatementModel(Type type)
	{
		this.type = type;
	}
	
	public int getType()
	{
		return type.ordinal();
	}
}
