package fp4g.data.operators;

import fp4g.data.IValue;
import fp4g.exceptions.NotAllowedOperatorException;

public interface IAddable
{		
	public IValue<?> add(IValue<?> right) throws NotAllowedOperatorException;;
}
	