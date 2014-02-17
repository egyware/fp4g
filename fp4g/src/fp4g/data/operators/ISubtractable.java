package fp4g.data.operators;

import fp4g.data.IValue;
import fp4g.exceptions.NotAllowedOperatorException;

public interface ISubtractable
{		
	public IValue<?> sub(IValue<?> right) throws NotAllowedOperatorException;;
}
	