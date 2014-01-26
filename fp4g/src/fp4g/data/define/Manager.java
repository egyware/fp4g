package fp4g.data.define;

import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.IValue;
import fp4g.data.expresion.literals.IntegerLiteral;


/**
 * Encapsula un Manager
 * Esta clase permite agregarle funcionalidad al juego, asi que solo nos bastará con saber su nombre
 * @author Edgardo
 *
 */
public class Manager extends Define 
{
	private int priority;
	
	public Manager(String name,IDefine parent) 
	{
		super(DefineType.MANAGER, name, parent);		
	}
	
	public void set(String key,IValue<?> value)
	{
		if(key.toLowerCase().equals("priority"))
		{
			priority = ((Number)value.getValue()).intValue();
		}
		else
		{
			super.set(key, value);
		}
	}
	
	public IValue<?> get(String key)
	{
		if(key.toLowerCase().equals("priority"))
		{
			return new IntegerLiteral(priority);
		}
		else
		{
			return super.get(key);
		}
	}

	public int getPriority() 
	{
		return priority;
	}
}
