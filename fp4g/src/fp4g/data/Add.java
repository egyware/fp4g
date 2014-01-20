/**
 * 
 */
package fp4g.data;

/**
 * @author egyware
 *
 */
public class Add extends Code
{		
	private final DefineType type;
	public final Define define;
	public final String name;	
	public String varName;
	public ExprList params;	
	public Add(DefineType type,String name)
	{
		this(type,name,null);		
	}		
		
	public Add(DefineType type, String name, String varName) {
		this.type = type;
		this.name = name;
		this.varName = varName;
		this.define = null;
	}
	
	
	public Add(Define define, String varName) {
		this.type = define.getType();
		this.name = define.name;
		this.varName = varName;
		this.define = define;
		
	}
	
	public void addParams(ExprList params)
	{
		this.params = params;
	}

	public DefineType getType()
	{
		return type;
	}

}
