package fp4g.data;

import java.util.Iterator;
import java.util.LinkedList;

public class Statements extends Code implements Iterable<Code>{

	//TODO una lista de codes, (por ahora)
	private final LinkedList<Code> codigo = new LinkedList<>();
	
	public void add(Code code)
	{
		codigo.add(code);
	}	
	
	
	public int size()
	{
		return codigo.size();
	}
	@Override
	public Iterator<Code> iterator() {
		return codigo.iterator();		
	}	
	
}
