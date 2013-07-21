package fp4g.new_data;

/**
 * Encapsula un Manager
 * Esta clase permite agregarle funcionalidad al juego, asi que solo nos bastará con saber su nombre
 * @author Edgardo
 *
 */
public abstract class Manager {
	public String name;	

	public Manager add() {
		//TODO mientras que no hayan diferencias de clases, entre la definida y la agregada esto está correcto
		Manager clone = null;
		try {
			clone = (Manager) clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clone;
	}	
}
