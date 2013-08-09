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
	public ExprList params; //TODO por definir
	public Add(ObjectType type,String name)
	{
		this(type,name,null);		
	}		
		
	public Add(ObjectType type, String name, String varName) {
		this.type = type;
		this.name = name;
		this.varName = varName;
	}

	public ObjectType getType()
	{
		return type;
	}

}
