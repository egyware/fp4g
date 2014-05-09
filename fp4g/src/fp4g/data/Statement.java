package fp4g.data;

/**
 * Clase generica para las oraciones
 * @author Edgardo
 *
 */
public abstract class Statement extends Line
{
	public static enum Type 
	{
		Send,
		Destroy,
		Subscribe,
		Unsubscribe,
		Assignment,
		
		
	}
	public final Type statementType;
	
	public Statement(Type type)
	{
		statementType = type;
	}

}
