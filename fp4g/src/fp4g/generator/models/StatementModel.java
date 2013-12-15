package fp4g.generator.models;

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
