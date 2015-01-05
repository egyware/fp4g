package fp4g.data.expresion;

import fp4g.core.Expresion;
import fp4g.core.IValue;
import fp4g.data.Add;
import fp4g.exceptions.CannotEvalException;

public class AddExpr implements Expresion, IValue<AddExpr> 
{
	public final Add add;		
	public AddExpr(Add add) 
	{
		this.add = add;				
	}	

	@Override
	public IValue<?> eval(IValue<?> value) throws CannotEvalException 
	{
		return add;
	}	

	@Override
	public AddExpr getValue()
	{
		return this;
	}

}
