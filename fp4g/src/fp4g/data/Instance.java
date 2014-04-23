package fp4g.data;

public enum Instance 
{
	Self, Other, System, Behavior, Game;
	
	public IValue<?> getInstance(String name, IDefine current)
	{
		//TODO por hacer si es necesario
		return null;
	}
}
