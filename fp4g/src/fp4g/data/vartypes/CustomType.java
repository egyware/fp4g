package fp4g.data.vartypes;

import fp4g.data.DefineType;
import fp4g.data.VarType;

public class CustomType implements VarType
{
	public final DefineType type;
	public final String name;
	public CustomType(final DefineType type, final String name)
	{
		this.type = type;
		this.name = name;
	}	
	public String name()
	{
		return name;
	}
}
