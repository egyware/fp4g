package fp4g.data.expresion;

import fp4g.data.Expresion;
import fp4g.data.IValue;
import fp4g.data.define.Manager;
import fp4g.exceptions.CannotEvalException;

public class ManagerExpr implements IValue<Manager>, Expresion
{
	public final Manager manager;
	public ManagerExpr(Manager manager)
	{
		this.manager = manager;
	}
	
	@Override
	public IValue<?> eval(IValue<?> value) throws CannotEvalException
	{
		return this;
	}

	@Override
	public Manager getValue() 
	{
		return manager;
	}

}
