package fp4g.data;

import java.util.Iterator;

import java.util.Vector;

/**
 * Clase utilitaria para almacenar expresión y aumentar la semantica del código.
 * 
 * @author Edgardo
 */
public class ExprList implements Iterable<Expresion> 
{	
	private final Vector<Expresion> list;		
	
	public ExprList(int n)
	{
		list = new Vector<Expresion>(n,1);				
	}
	public ExprList()
	{
		list = new Vector<Expresion>();				
	}
	
	public void add(Expresion expr) 
	{
		list.add(expr);		
	}
	
	public void addFirst(Expresion expr)
	{
		list.add(0, expr);
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
