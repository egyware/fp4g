package fp4g.new_data;

/**
 * Clase común que agrega algunas funciones relevantes
 * @author Edgardo
 *
 */
public abstract class GameDataCommon implements IGameData {
	private int count = 0;
	public void add(Object value)
	{
		add(String.valueOf(count++),value);
	}
	public abstract void add(String name,Object value);
	
	//get Define
	public abstract Behavior getDefinedBehavior(String name);
	public abstract Manager getDefinedManager(String name);	
	public abstract Entity getDefinedEntity(String name);
}
