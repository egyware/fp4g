package fp4g.data.define;

import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.IValue;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.literals.StringLiteral;

/**
 * TODO definir si va hacer algo esta clase...
 * Encapsula un comportamiento
 * @author Edgardo
 *
 */
public class Behavior extends Define
{
	public String group;
	public Behavior(String name,IDefine parent) 
	{
		super(DefineType.BEHAVIOR, name,parent);		
	}
	
	public void set(String key, IValue<?> value)
	{
		if(key.equalsIgnoreCase("group"))
		{
			group = value.getValue().toString();
		}
		else
		{
			super.set(key, value);
		}
	}
	
	public IValue<?> get(String key)
	{
		if(key.equalsIgnoreCase("group"))
		{
			return new StringLiteral(group);
		}	
		else
		{
			return super.get(key);
		}
	}

	//public Behavior parent;
	//public String name;
	//public ExprList parameters;
	
}
