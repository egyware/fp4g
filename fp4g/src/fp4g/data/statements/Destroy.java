package fp4g.data.statements;

import fp4g.data.Code;
import fp4g.data.Instance;


public class Destroy extends Code
{
	public final Instance toDestroy;
	public final String instanceName;
	public Destroy(Instance toDestroy)
	{
		this(toDestroy,null);
	}
	public Destroy(Instance toDestroy,String name)
	{
		this.toDestroy = toDestroy;
		this.instanceName = name;
	}	
}
