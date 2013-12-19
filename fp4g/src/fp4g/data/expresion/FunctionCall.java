package fp4g.data.expresion;

import fp4g.data.Define;
import fp4g.data.ExprList;
import fp4g.data.Expresion;

public class FunctionCall extends Expresion {
	public final String functionName;
	public final ExprList params;
	public FunctionCall(String function,ExprList params)
	{
		this.functionName = function;
		this.params = params;
	}
	
	
	@Override
	public Literal<?> eval(Define define) 
	{
		throw new RuntimeException("No Implementado");
	}

}
