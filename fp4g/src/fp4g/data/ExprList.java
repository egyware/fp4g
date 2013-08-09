package fp4g.data;

import java.util.LinkedList;
import java.util.List;

public class ExprList {
	public List<Expresion> list;
	public ExprList()
	{
		list = new LinkedList<>();
	}
	
	public void add(Expresion expr)
	{
		list.add(expr);
	}
}
