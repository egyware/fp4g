package fp4g.data.operators;

import fp4g.data.IValue;
import fp4g.exceptions.NotAllowedOperatorException;

public interface IDivisible
{
	public IValue<?> div(IValue<?> right) throws NotAllowedOperatorException;;	
}
	