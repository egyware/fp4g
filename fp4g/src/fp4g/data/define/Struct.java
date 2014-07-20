package fp4g.data.define;

import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.ILib;

public class Struct extends Define 
{
	public Struct(String name) 
	{
		super(DefineType.STRUCT, name);
	
	}
	
	public Struct(String name, ILib lib) 
	{
		super(DefineType.STRUCT, name, lib);
	
	}

}
