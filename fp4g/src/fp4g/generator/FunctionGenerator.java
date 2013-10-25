/**
 * 
 */
package fp4g.generator;

import fp4g.data.Code;
import fp4g.data.Expresion;
import fp4g.data.expresion.FunctionCall;

/**
 * @author Edgardo
 *
 */
public abstract class FunctionGenerator <T extends Generator,Model>
{
	//el generador para que esté disponible para las demás instancias...
	protected final T generator;
	
	public FunctionGenerator(T generator)
	{
		this.generator = generator;
	}
	
	/**
	 * A partir de los parametros puestos en el generador, devolverá una expresión.
	 * Tal expresión, será luego convertida en codigo según el generador.
	 * 
	 * @param generator Generador actual
	 * @param parent padre quien contiene a la función actual.
	 * @param model modelo del codigo fuente que se genera
	 * @param list
	 * @return una expresion, la cual puede ser codigo directo o algo...
	 */
	public abstract Expresion generate(Code parent,Model model,FunctionCall function);
	
	
}
