package fp4g.data.define;

import fp4g.classes.ManagerData;
import fp4g.data.Define;
import fp4g.data.DefineTypes;
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
	private String managerClass;
	
	private ManagerData debug;
	private ManagerData extra;
	
	public Manager(String name,ILib parent) 
	{
		super(DefineTypes.MANAGER, name, parent);		
	}
	
	public int getPriority() 
	{
		return priority;
	}
	
	public boolean isReceiver()
	{
		return receiver;
	}

	public final void setPriority(int priority) 
	{
		this.priority = priority;
	}

	public final void setReceiver(boolean receiver) 
	{
		this.receiver = receiver;
	}

	public final String getManagerClass() 
	{
		return managerClass;
	}

	public final void setManagerClass(String managerClass)
	{
		this.managerClass = managerClass;
	}

	public ManagerData getDebug() 
	{
		return debug;
	}

	public void setDebug(ManagerData debug) {
		this.debug = debug;
	}



	public ManagerData getExtra() {
		return extra;
	}



	public void setExtra(ManagerData extra) {
		this.extra = extra;
	}
}
