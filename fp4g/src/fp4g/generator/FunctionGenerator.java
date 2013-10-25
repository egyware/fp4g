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
	//el generador para que est� disponible para las dem�s instancias...
	protected final T generator;
	
	public FunctionGenerator(T generator)
	{
		this.generator = generator;
	}
	
	/**
	 * A partir de los parametros puestos en el generador, devolver� una expresi�n.
	 * Tal expresi�n, ser� luego convertida en codigo seg�n el generador.
	 * 
	 * @param generator Generador actual
	 * @param parent padre quien contiene a la funci�n actual.
	 * @param model modelo del codigo fuente que se genera
	 * @param list
	 * @return una expresion, la cual puede ser codigo directo o algo...
	 */
	public abstract Expresion generate(Code parent,Model model,FunctionCall function);
	
	
}
