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

	//TODO Para que es esto?
//	public Manager add() {
//		//TODO mientras que no hayan diferencias de clases, entre la definida y la agregada esto está correcto
//		Manager clone = null;
//		try {
//			clone = (Manager) clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return clone;
//	}
	
	public int compareTo(Manager other)
	{
		return (priority - other.priority);
	}
}
