package fp4g.data.expresion;

import java.util.HashMap;

import fp4g.data.IValue;

// también deberia ser literal
public final class ArrayMap extends Literal<Map> implements Map
{
	private final java.util.Map<String,IValue<?>> map;
	
	public ArrayMap(String keys[],Literal<?> exprs[])
	{		
		map = new HashMap<String, IValue<?>>();		
		for(int i=0;i<keys.length;i++)
		{
			map.put(keys[i], exprs[i]);
		}
	}
	
	public ArrayMap()
	{
		map = new HashMap<String, IValue<?>>();
	}
	
	public IValue<?> get(String key)
	{
		return map.get(key);		
	}

		@Override
	public void set(String key, IValue<?> value) {
		map.put(key, value);
	}

	@Override
	public Map getValue() {
		return this;
	}
}
