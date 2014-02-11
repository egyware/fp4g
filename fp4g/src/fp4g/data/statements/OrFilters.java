package fp4g.data.statements;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp4g.data.Line;

public class OrFilters extends Line implements Iterable<AndFilters> 
{
	public final List<AndFilters> filters = new LinkedList<AndFilters>();
	
	@Override
	public Iterator<AndFilters> iterator() 
	{
		return filters.iterator();		
	}

	public void addAnd(AndFilters andFilters) 
	{
		filters.add(andFilters);
		
	}

}
