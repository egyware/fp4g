package fp4g.data;

import fp4g.exceptions.CannotEvalException;

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
	
	public abstract IValue<?> eval(IValue<?> value) throws CannotEvalException;
}
