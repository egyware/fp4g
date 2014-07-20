package fp4g.data.define;

import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.ILib;

/**
 * Encapsula un comportamiento
 * @author Edgardo
 *
 */
public class Behavior extends Define
{
	public String group;
	public Behavior(String name,ILib container) 
	{
		super(DefineType.BEHAVIOR, name,container);		
	}
	
	public final String getGroup() {
		return group;
	}
	public final void setGroup(String group) {
		this.group = group;
	}
	

	//public Behavior parent;
	//public String name;
	//public ExprList parameters;
	
}
