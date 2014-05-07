package fp4g.generator.gdx.models;

public abstract class StatementModel 
{
	public static enum Type
	{
		SendStatement,
		DestroyStatement,
		SubscribeStatement,
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
