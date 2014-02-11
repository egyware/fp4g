package fp4g.data.statements;

import fp4g.classes.MessageMethod;
import fp4g.data.ExprList;
import fp4g.data.ILine;
import fp4g.data.Line;

public final class Filter extends Line implements ILine
{	
	public final MessageMethod method;
	public final ExprList exprList;
	
	public Filter(MessageMethod method, ExprList exprList)
	{					
		this.method = method;
		this.exprList = exprList;
	}	
	
	public String toString()
	{
		return method.getName().concat("(...)");
	}
}
