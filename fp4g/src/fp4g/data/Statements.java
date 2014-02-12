package fp4g.data;

import java.util.Iterator;
import java.util.LinkedList;

public class Statements extends Code implements Iterable<ILine>{

	//TODO una lista de codes, (por ahora)
	private final LinkedList<ILine> codigo = new LinkedList<ILine>();
	
	public void add(ILine code)
	{
		codigo.add(code);
	}	
	
	
	public int size()
	{
		return codigo.size();
	}
	@Override
	public Iterator<ILine> iterator() 
	{
		return codigo.iterator();		
	}	
	
}