package fp4g.core;

import java.util.List;
/**
 * <h3>Instrucción:</h3>
 * <code>
 * RESOLVER name
 * [
 * 		SET key = value;
 * 		"resource1","resource2","resource3";
 * ]
 * </code>
 * 
 * @author Edgardo
 *
 */
public final class Resolver extends Line
{
	private final Type type;
	private List<String> sources;
	private String name;
	private String wrapper;
	
	public Resolver(Type type)
	{
		this.type = type;
	}
	
	public Type getType()
	{
		return type;
	}
	
	public List<String> getSources()
	{
		return sources;
	}
	public String getName()
	{
		return name;
	}
	public String getWrapper()
	{
		return wrapper;
	}
	public void setSources(List<String> sources)
	{
		this.sources = sources;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setWrapper(String wrapper)
	{
		this.wrapper = wrapper;
	}
}
