package fp4g.generator.gdx.models.On;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.add.AddMethod;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.gdx.JavaExpresionGenerator;

public class FiltersD implements Iterable<String>
{
	//que necesito acá. Por cada FilterS necesito:
	//Una lista de conjunciones
	private final List<String> condiciones;
	
	public FiltersD()
	{
		condiciones = new LinkedList<String>();
	}
	
	public List<String> getConditions()
	{
		return condiciones;
	}

	@Override
	public Iterator<String> iterator()
	{
		return condiciones.iterator();
	}
	
	/**
	 * 
	 * @param mm Metodo de un mensaje
	 * @param list Lista de Expresiones distinto de nulo
	 * @param jeg Generador de Expresiones para Java
	 * @throws CannotEvalException 
	 */
	public void add(AddMethod mm, ExprList list, JavaExpresionGenerator jeg) throws CannotEvalException 
	{
		Iterator<Expresion> iterator = list.iterator();
		if(iterator.hasNext())
		{
			Expresion first = iterator.next();
			final String valueReplace = mm.getReplace();
			if(valueReplace == null)
			{
				condiciones.add(jeg.generate(null, first));
			}
			else
			{
				condiciones.add(String.format(valueReplace,jeg.generate(null, first)));
			}
		}
		for(;iterator.hasNext();)
		{
			Expresion expr = iterator.next();
			condiciones.add(jeg.generate(null, expr));
		}
	}	
	
}