package fp4g.data;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExprList implements Iterable<Expresion> {
	public List<Expresion> list;
	public ExprList()
	{
		list = new LinkedList<>();
	}
	
	public void add(Expresion expr)
	{
		list.add(expr);
	}

	@Override
	public Iterator<Expresion> iterator() {
		return list.iterator();
	}
}
