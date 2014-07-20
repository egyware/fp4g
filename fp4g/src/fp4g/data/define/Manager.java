package fp4g.data.define;

import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.ILib;

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
	
	public Manager(String name,ILib parent) 
	{
		super(DefineType.MANAGER, name, parent);		
	}
	
	public int getPriority() 
	{
		return priority;
	}
	
	public boolean isReceiver()
	{
		return receiver;
	}

	public final void setPriority(int priority) {
		this.priority = priority;
	}

	public final void setReceiver(boolean receiver) {
		this.receiver = receiver;
	}	
}
