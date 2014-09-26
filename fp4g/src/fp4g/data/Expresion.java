package fp4g.data;

import fp4g.exceptions.CannotEvalException;

/**
 * Clase base para definir una expresi�n.
 * 
 * Esta clase define las funciones basicas que debe tener una expresi�n para poder ser usada por todo el sistema.
 * @author Edgardo
 *
 */
public interface Expresion
{	
	/**
	 * Permite evualar esta expresi�n
	 * 
	 * @param value El valor inicial o padre de esta expresi�n.
	 * @return Regresa el valor resultante de esta expresi�n
	 * @throws CannotEvalException En caso que no se pueda evaluar la expresi�n
	 */
	public IValue<?> eval(IValue<?> value) throws CannotEvalException;
}
