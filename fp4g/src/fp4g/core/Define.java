package fp4g.core;

/**
 *  Guarda la definición de una estructura.
 *  <h3>Instrucción</h3>
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
