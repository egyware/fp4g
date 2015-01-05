package fp4g.data.expresion;

import fp4g.core.Expresion;
import fp4g.core.IValue;
import fp4g.data.ExprList;
import fp4g.data.IDefine;
import fp4g.data.Statement;

public class FunctionCall extends Statement implements Expresion, IValue<FunctionCall>
{
	public final String functionName;
	public final ExprList params;
	public final IDefine current;	
	public FunctionCall(IDefine current, String function, ExprList params)
	{
		this.functionName = function;
		this.params = params;
		this.current = current;
	}	
	
	@Override
	public IValue<?> eval(IValue<?> define) 
	{
		return this;
	}

	@Override
	public FunctionCall getValue() 
	{
		return this;
	}

}
