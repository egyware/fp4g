package fp4g.data;

import fp4g.core.IValue;
import fp4g.core.Line;

public class DeclVar extends Line 
{
	public final VarType type;
	public final String name;
	public final IValue<?> initValue;
	public DeclVar(VarType type, String name)
	{
		this(type,name,null);		
	}
	public DeclVar(VarType type, String name, IValue<?> initValue)
	{
		this.type = type;
		this.name = name;
		this.initValue = initValue;
	}
}
