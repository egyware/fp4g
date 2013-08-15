/**
 * 
 */
package fp4g.data;

/**
 * @author egyware
 *
 */
public class Add extends Code{		
	private ObjectType type;
	public String name;	
	public String varName;
	public ExprList params;
	public Add(ObjectType type,String name)
	{
		this(type,name,null);		
	}		
		
	public Add(ObjectType type, String name, String varName) {
		this.type = type;
		this.name = name;
		this.varName = varName;
	}
	
	public void addParams(ExprList params)
	{
		this.params = params;
	}

	public ObjectType getType()
	{
		return type;
	}

}
