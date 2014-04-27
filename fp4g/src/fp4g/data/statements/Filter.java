package fp4g.data.statements;

import fp4g.data.AddMethod;
import fp4g.data.ExprList;
import fp4g.data.ILine;
import fp4g.data.Line;

public final class Filter extends Line implements ILine
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
