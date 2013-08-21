package fp4g.data;

import java.util.Iterator;
import java.util.LinkedList;

public class ExprList implements Iterable<Expresion> {
	public LinkedList<Expresion> list;
	public ExprList()
	{
		list = new LinkedList<>();
	}
	
	public void add(Expresion expr)
	{
		list.add(expr);		
	}
	/**
	 * Parche para la inserción con una lista.
	 * Cumple la misma función de add, pero a la inversa.
	 * @param expr
	 */
	public void addFirst(Expresion expr) {
		list.addFirst(expr);
	}

	@Override
	public Iterator<Expresion> iterator() {
		return list.iterator();
	}
	
}
