package fp4g.data.define;

import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;

public class Struct extends Define 
{
	public Struct(String name) 
	{
		super(DefineType.STRUCT, name);
	
	}
	
	public Struct(String name, IDefine parent) 
	{
		super(DefineType.STRUCT, name, parent);
	
	}

}
