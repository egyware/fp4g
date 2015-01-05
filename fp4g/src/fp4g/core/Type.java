package fp4g.core;

/**
 * <h3>Instrucción: </h3>
 * <code>TYPE name;</code>
 * 
 * @author Edgardo
 *
 */
public final class Type extends Line
{
	private String name;	
	
	public Type()
	{		
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}	

}
