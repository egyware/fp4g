package fp4g.data.expresion;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.core.IValue;

// también deberia ser literal
public final class ArrayMap extends Literal<IMap> implements IMap
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
	public void set(String key, IValue<?> value) 
	{
		map.put(key, value);
	}

	
	@Override
	public IMap getValue() {
		return this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<Entry<String, IValue<?>>> entrySet() 
	{
		return map.entrySet();
	}
}
