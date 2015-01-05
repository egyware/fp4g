package fp4g.data.statements;

import fp4g.core.Line;
import fp4g.data.ExprList;
import fp4g.data.add.AddMethod;

public final class Filter extends Line
{	
	public final AddMethod method;
	public final ExprList exprList;
	
	public Filter(AddMethod method, ExprList exprList)
	{					
		this.method = method;
		this.exprList = exprList;
	}	
	
	public String toString()
	{
		return method.name.concat("(...)");
	}
}
