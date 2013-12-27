package fp4g.data;

import fp4g.data.expresion.Literal;

public class DeclVar extends Code 
{
	public final VarType type;
	public final String name;
	public final Literal<?> initValue;
	public DeclVar(VarType type, String name)
	{
		this(type,name,null);		
	}
	public DeclVar(VarType type, String name, Literal<?> initValue)
	{
		this.type = type;
		this.name = name;
		this.initValue = initValue;
	}
}
