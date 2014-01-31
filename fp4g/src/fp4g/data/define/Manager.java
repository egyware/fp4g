package fp4g.data.define;

import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.IValue;
import fp4g.data.expresion.literals.BoolLiteral;
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
	private boolean receiver;
	
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
		if(key.toLowerCase().equals("receiver"))
		{
			receiver = ((Boolean)value.getValue()).booleanValue();
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
		if(key.toLowerCase().equals("receiver"))
		{
			return new BoolLiteral(receiver);
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
	
	public boolean isReceiver()
	{
		return receiver;
	}	
}
