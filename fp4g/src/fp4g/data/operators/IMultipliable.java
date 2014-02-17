package fp4g.data.operators;

import fp4g.data.IValue;
import fp4g.exceptions.NotAllowedOperatorException;

public interface IMultipliable
{		
	public IValue<?> mult(IValue<?> right) throws NotAllowedOperatorException;;
}
	