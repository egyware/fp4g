package fp4g.data.expresion;

import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.IValue;

public class FunctionCall extends Expresion implements IValue<FunctionCall>
{
	public final String functionName;
	public final ExprList params;
	public final IDefine current;	
	public FunctionCall(String function, IDefine current, ExprList params)
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
