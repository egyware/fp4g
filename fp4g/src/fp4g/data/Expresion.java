package fp4g.data;

/**
 * Clase base para las expresiones!
 * @author Edgardo
 *
 */
public abstract class Expresion {	
	private boolean hasPar;
	
	public boolean hasPar()
	{
		return hasPar;
	}
	
	public void setPar(boolean p)
	{
		hasPar = p;
	}
}
