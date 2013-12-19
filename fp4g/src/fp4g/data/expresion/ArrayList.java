package fp4g.data.expresion;

import java.util.Iterator;

// tambi�n deberia ser literal
public final class ArrayList extends Literal<List> implements List
{
	private final java.util.List<Literal<?>> list;
	
	public ArrayList(Literal<?> lits[])
	{		
		list = new java.util.ArrayList<Literal<?>>(lits.length);		
		for(Literal<?> lit:lits)
		{
			list.add(lit);
		}
	}
	
	public ArrayList()
	{
		list = new java.util.ArrayList<Literal<?>>();
	}
	
	@Override
	public List getValue() {
		return this;
	}

	@Override
	public Iterator<Literal<?>> iterator() 
	{
		return list.iterator();
	}

	@Override
	public void add(Literal<?> item) 
	{
		list.add(item);		
	}

	@Override
	public Literal<?> get(int index) 
	{
		return list.get(index);
	}

	@Override
	public int size() 
	{		
		return list.size();
	}
}
