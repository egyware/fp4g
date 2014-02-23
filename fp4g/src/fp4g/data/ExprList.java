package fp4g.data;

import java.util.Iterator;
import java.util.Vector;

public class ExprList implements Iterable<Expresion> 
{	
	private final Vector<Expresion> list;		
	
	public ExprList(int n)
	{
		list = new Vector<Expresion>(n,2);				
	}
	
	/**
	 * Parche para la inserción con una lista.
	 * Cumple la misma función de add, pero a la inversa.
	 * @param expr
	 */
	public void addFirst(Expresion expr)
	{		
		list.insertElementAt(expr, 0);
	}
	public void add(Expresion expr) 
	{
		list.add(expr);		
	}
	public void insertElementAt(Expresion expr, int index)
	{
		list.insertElementAt(expr, index);
	}
	
	public Expresion get(int index)
	{
		return list.get(index);
	}
	public int size()
	{
		return list.size();
	}

	@Override
	public Iterator<Expresion> iterator() 
	{		
		return list.iterator();
	}


}
