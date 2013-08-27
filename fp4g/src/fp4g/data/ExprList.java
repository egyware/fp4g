package fp4g.data;

import java.util.Iterator;



public class ExprList implements Iterable<Expresion> {
	private final Expresion[] list;	
	private int tail;
	private int head;
	public ExprList(int n)
	{
		list = new Expresion[n];				
		tail = n-1;
		head = 0;		
	}
	
	public void add(Expresion expr)
	{
		list[head++] = expr;		
	}
	/**
	 * Parche para la inserción con una lista.
	 * Cumple la misma función de add, pero a la inversa.
	 * @param expr
	 */
	public void addFirst(Expresion expr) {		
		list[tail--] = expr;
	}
	
	public Expresion get(int index)
	{
		return list[index];
	}

	@Override
	public Iterator<Expresion> iterator() {		
		return new ExprListIterator(list);
	}
	
	private static class ExprListIterator implements Iterator<Expresion>
	{
		private final Expresion[] list;
		private int index = 0;		

		public ExprListIterator(Expresion[] list) {
			this.list = list;
		}

		@Override
		public boolean hasNext() {			
			return index < list.length;
		}

		@Override
		public Expresion next() {			
			return list[index++];
		}

		@Override
		public void remove() {
			//nope, no remove			
		}
	}
	
}
