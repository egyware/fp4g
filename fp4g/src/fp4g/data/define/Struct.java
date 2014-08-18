package fp4g.data.define;

import fp4g.data.Define;
import fp4g.data.DefineTypes;
import fp4g.data.ILib;

public class Struct extends Define 
{
	public Struct(String name) 
	{
		super(DefineTypes.STRUCT, name);
	
	}
	
	public Struct(String name, ILib lib) 
	{
		super(DefineTypes.STRUCT, name, lib);
	
	}

}
