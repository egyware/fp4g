package fp4g.data.expresion;

import fp4g.data.ExprList;

public class FunctionCall {
	public final String function;
	public ExprList params;
	public FunctionCall(String function)
	{
		this.function = function;
	}
	public void addParams(ExprList params)
	{
		this.params = params;
	}

}
