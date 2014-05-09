package fp4g.data;

import java.util.Iterator;
import java.util.LinkedList;

public class Statements extends Code implements Iterable<Statement>
{

	private final LinkedList<Statement> codigo = new LinkedList<Statement>();
	
	public void add(Statement code)
	{
		codigo.add(code);
	}	
	
	
	public int size()
	{
		return codigo.size();
	}
	@Override
	public Iterator<Statement> iterator() 
	{
		return codigo.iterator();		
	}	
	
}