package fp4g.data;

import java.util.HashMap;

import fp4g.core.IValue;
import fp4g.core.Line;
import fp4g.data.operators.IAccessible;

/**
 * Esta clase está diseñada
 * @author Edgardo
 *
 */
public class Container extends Line implements IAccessible, IValue<Container>
{
	private final IAccessible parent;
	private final HashMap<String, IValue<?>> map;
	public Container(IAccessible parent)
	{
		this.parent = parent;
		this.map = new HashMap<String, IValue<?>>();
	}
	
	public void set(String key, IValue<?> value)
	{
		map.put(key, value);
	}
	
	@Override
	public IValue<?> get(String key) 
	{
		IValue<?> ret = map.get(key);
		if(ret == null && parent != null)
		{
			ret = parent.get(key);
		}
		return ret;
	}

	@Override
	public Container getValue() 
	{
		return this;
	}

}
