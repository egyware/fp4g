package fp4g.data;

import fp4g.exceptions.CannotEvalException;

/**
 * Clase base para definir una expresión.
 * 
 * Esta clase define las funciones basicas que debe tener una expresión para poder ser usada por todo el sistema.
 * @author Edgardo
 *
 */
public interface Expresion
{	
	/**
	 * Permite evualar esta expresión
	 * 
	 * @param value El valor inicial o padre de esta expresión.
	 * @return Regresa el valor resultante de esta expresión
	 * @throws CannotEvalException En caso que no se pueda evaluar la expresión
	 */
	public IValue<?> eval(IValue<?> value) throws CannotEvalException;
}
