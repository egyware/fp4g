package fp4g.data;


/**
 * Encapsula un Manager
 * Esta clase permite agregarle funcionalidad al juego, asi que solo nos bastará con saber su nombre
 * @author Edgardo
 *
 */
public abstract class Manager extends Define {
	
	public Manager(String name) {
		super(ObjectType.MANAGER, name);		 
	}

	public String name;	

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
}
