package fp4g.data.expresion;

import java.util.Map;
import java.util.Set;

import fp4g.core.IValue;

public interface IMap
{
	public void set(String key, IValue<?> value);
	public IValue<?> get(String key);	
	
	public <V extends IValue<?>> Set<Map.Entry<String,V>> entrySet();
	
	public static class MapEntry<K, V> implements Map.Entry<K,V>
	{
		private K key;
		private V value;
		
		public MapEntry(K k, V v)
		{
			key = k;
			value = v;
		}

		@Override
		public K getKey() 
		{
			return key;
		}

		@Override
		public V getValue() 
		{
			return value;
		}

		@Override
		public V setValue(V v) 
		{
			V old = value;
			value = v;
			return old;
		}		
	}

}
