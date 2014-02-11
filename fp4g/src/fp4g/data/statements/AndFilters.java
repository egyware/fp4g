package fp4g.data.statements;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp4g.data.Line;

public class AndFilters extends Line implements Iterable<Filter> 
{
	public final List<Filter> filters = new LinkedList<Filter>();
	
	public AndFilters()
	{		
	}
	
	public void AddFilter(Filter filter)
	{
		filters.add(filter);
	}

	@Override
	public Iterator<Filter> iterator() 
	{		
		return filters.iterator();
	}	
}
