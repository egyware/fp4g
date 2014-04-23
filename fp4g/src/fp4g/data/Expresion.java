package fp4g.data;

import fp4g.exceptions.CannotEvalException;

/**
 * Clase base para definir una expresión.
 * 
 * Esta clase define las funciones basicas que debe tener una expresión para poder ser usada por todo el sistema.
 * @author Edgardo
 *
 */
public abstract class Expresion
{	
	private boolean hasPar;
	
	/**
	 * Indica si tiene parentesis esta expresión.
	 * 
	 * Util para la serialización de datos.
	 * 
	 * @return Devuelve si esta expresión usa parentesis. 
	 */
	public final boolean hasPar()
	{
		return hasPar;
	}
	
	/**
	 * Establece si esta expresión usa parentesis.
	 * 
	 * @param p un boolean indicando si tiene parentesis o no.
	 */	
	public final void setPar(boolean p)
	{
		hasPar = p;
	}
	
	/**
	 * Permite evualar esta expresión
	 * 
	 * @param value El valor inicial o padre de esta expresión.
	 * @return Regresa el valor resultante de esta expresión
	 * @throws CannotEvalException En caso que no se pueda evaluar la expresión
	 */
	public abstract IValue<?> eval(IValue<?> value) throws CannotEvalException;
}
