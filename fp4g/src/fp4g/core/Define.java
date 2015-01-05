package fp4g.core;

/**
 *  Guarda la definici�n de una estructura.
 *  <h3>Instrucci�n</h3>
 *  DEFINE name ("controller") 
 *  [
 *  	SET name = key;
 *  	-modifiers-
 *  ] 
 * 
 * @author Edgardo
 *
 */
public class Define extends Line
{
	private final Type type;	
	
	public Define(Type type)
	{	
		this.type = type;
	}
	
	public Type getType()
	{
		return type;
	}

}
