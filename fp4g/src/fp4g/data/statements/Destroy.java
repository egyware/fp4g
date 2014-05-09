package fp4g.data.statements;

import fp4g.data.Instance;
import fp4g.data.Statement;



public class Destroy extends Statement
{
	public final Instance toDestroy;
	public final String instanceName;
	public Destroy(Instance toDestroy)
	{	
		this(toDestroy,null);
	}
	public Destroy(Instance toDestroy,String name)
	{
		super(Statement.Type.Destroy);
		this.toDestroy = toDestroy;
		this.instanceName = name;
	}	
}
