package fp4g.generator.gdx.models.On;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp4g.classes.MessageMethod;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.Model;
import fp4g.generator.gdx.JavaExpresionGenerator;

public class FiltersC implements Model, Iterable<String>
{
	//que necesito ac�. Por cada FilterS necesito:
	//Una lista de condiciones
	private final List<String> condiciones;
	
	public FiltersC()
	{
		condiciones = new LinkedList<String>();
	}

	/**
	 * 
	 * @param mm Metodo de un mensaje
	 * @param list Lista de Expresiones distinto de nulo
	 * @param jeg Generador de Expresiones para Java
	 * @throws CannotEvalException 
	 */
	public void add(MessageMethod mm, ExprList list, JavaExpresionGenerator jeg) throws CannotEvalException 
	{
		Iterator<Expresion> iterator = list.iterator();
		if(iterator.hasNext())
		{
			Expresion first = iterator.next();
			condiciones.add(String.format(mm.getValueReplace(),jeg.generate(null, first)));
		}
		for(;iterator.hasNext();)
		{
			Expresion expr = iterator.next();
			condiciones.add(jeg.generate(null, expr));
		}
	}
	
	public List<String> getCondiciones()
	{
		return condiciones;
	}

	@Override
	public Iterator<String> iterator() 
	{
		return condiciones.iterator();
	}
}