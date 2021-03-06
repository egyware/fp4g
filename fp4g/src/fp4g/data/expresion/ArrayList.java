package fp4g.data.expresion;

import java.util.Iterator;

import fp4g.core.IValue;

public final class ArrayList extends Literal<IList> implements IList
{
	private final java.util.List<IValue<?>> list;
	
	public ArrayList(IValue<?> lits[])
	{		
		list = new java.util.ArrayList<IValue<?>>(lits.length);		
		for(IValue<?> lit:lits)
		{
			list.add(lit);
		}
	}
	
	public ArrayList()
	{
		list = new java.util.ArrayList<IValue<?>>();
	}
	
	
	@Override	
	public IList getValue() {
		return this;
	}

	@Override
	public Iterator<IValue<?>> iterator() 
	{
		return list.iterator();
	}

	@Override
	public void add(IValue<?> item) 
	{
		list.add(item);		
	}

	@Override
	public IValue<?> get(int index) 
	{
		return list.get(index);
	}

	@Override
	public int size() 
	{		
		return list.size();
	}
}
