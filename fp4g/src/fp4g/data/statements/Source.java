package fp4g.data.statements;

import fp4g.core.Line;
import fp4g.data.Statements;

public final class Source extends Line
{	
	public final OrFilters filters;
	public final Statements statements;
	public Source(Statements statements)
	{
		this.filters = new OrFilters();
		this.statements = statements;
	}	
	
}