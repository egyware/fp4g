package fp4g.data.expresion;

import java.util.HashMap;

// también deberia ser literal
public final class ArrayMap extends Literal<Map> implements Map{
	private final java.util.Map<String,Literal<?>> map;
	
	public ArrayMap(String keys[],Literal<?> exprs[])
	{		
		map = new HashMap<>();		
		for(int i=0;i<keys.length;i++)
		{
			map.put(keys[i], exprs[i]);
		}
	}
	
	public ArrayMap()
	{
		map = new HashMap<>();
	}
	
	public Literal<?> get(String key)
	{
		return map.get(key);		
	}

		@Override
	public Literal<?> set(String key, Literal<?> value) {
		return map.put(key, value);
	}

	@Override
	public Map getValue() {
		return this;
	}
}
