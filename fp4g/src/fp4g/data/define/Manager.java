package fp4g.data.define;

import fp4g.data.Define;
import fp4g.data.DefineType;


/**
 * Encapsula un Manager
 * Esta clase permite agregarle funcionalidad al juego, asi que solo nos bastará con saber su nombre
 * @author Edgardo
 *
 */
public abstract class Manager extends Define implements Comparable<Manager>{
	private final int priority;
	
	public Manager(String name,int p) {
		super(DefineType.MANAGER, name);
		priority = p;
	}
	
	public int compareTo(Manager other)
	{
		return (priority - other.priority);
	}
}
