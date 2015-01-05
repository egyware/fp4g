package fp4g.data.statements;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp4g.core.Line;

public class OrFilters extends Line implements Iterable<Filter> 
{
	public final List<Filter> filters = new LinkedList<Filter>();
	
	@Override
	public Iterator<Filter> iterator() 
	{
		return filters.iterator();		
	}

	public void addAnd(Filter filter) 
	{
		filters.add(filter);		
	}
	
	public int size()
	{
		return filters.size();
	}

}
