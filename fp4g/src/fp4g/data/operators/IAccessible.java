package fp4g.data.operators;

import fp4g.data.IValue;
import fp4g.exceptions.NotAllowedOperatorException;

/**
 * @author Edgardo
 *
 */
public interface IAccessible
{
	public IValue<?> get(String key) throws NotAllowedOperatorException;
	public IValue<?> getParent()  throws NotAllowedOperatorException;
}
