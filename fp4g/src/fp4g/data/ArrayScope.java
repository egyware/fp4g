/**
 * 
 */
package fp4g.data;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

/**
 * @author egyware
 *
 */
public final class ArrayScope implements IScope {
	public static class ArrayEntry implements Map.Entry<String, Object>
	{
		private final String key;
		private Object value;
		public ArrayEntry(String k,Object v)
		{
			key = k;
			value = v;
		}

		@Override
		public String getKey() {			
			return key;
		}

		@Override
		public Object getValue() {			
			return value;
		}

		@Override
		public Object setValue(Object v) {
			Object old = value;
			value = v;
			return old;
		}
		
	}
	private Vector<ArrayEntry> values;
	private int last_insert = 0;
	private final IScope parent;
	
	public ArrayScope()
	{
		this(null);
	}
	public ArrayScope(IScope p)
	{
		values = new Vector<ArrayEntry>();
		parent = p;
	}
	/* (non-Javadoc)
	 * @see fp4g.data.IScope#set(java.lang.String, java.lang.Object)
	 */
	@Override
	public void set(String key, Object value) {
		//primero buscar
		for(Entry<String,Object> entry:values)
		{
			if(key.equals(entry.getKey()))
			{
				entry.setValue(value);
				return;
			}
		}		
		values.add(new ArrayEntry(key,value));
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#add(java.lang.Object)
	 */
	@Override
	public void add(Object value) {
		values.add(new ArrayEntry(String.valueOf(last_insert++), value));
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#getLastInsert()
	 */
	@Override
	public int getLastInsert() {		
		return last_insert;
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#writeAndOverride(fp4g.data.IScope)
	 */
	@Override
	public void writeAndOverride(IScope other) {
		for(Entry<String, Object> entry :values)
		{
			other.set(entry.getKey(),entry.getValue());			
		}
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#writeWithoutOverride(fp4g.data.IScope)
	 */
	@Override
	public void writeWithoutOverride(IScope other) {
		for(Entry<String, Object> entry :values)
		{
			//sobre escribe las propiedades
			String key = entry.getKey();
			if(other.get(key) == null)
			{
				other.set(key,entry.getValue());
			}
		}
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#toArray()
	 */
	@Override
	public Entry<String, Object>[] toArray() {
		ArrayEntry array[] = new ArrayEntry[values.size()];
		values.toArray(array);
		return array;
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#size()
	 */
	@Override
	public int size() {		
		return values.size();
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#get(java.lang.String)
	 */
	@Override
	public Object get(String key) {
		Object find = null;
		for(Entry<String,Object> entry:values)
		{
			if(key.equals(entry.getKey()))
			{
				find =  entry.getValue();
				break;
			}
		}		
		if(find == null && parent != null)
		{
			find = parent.get(key);			
		}
		return find;
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#localGet(java.lang.String)
	 */
	@Override
	public Object localGet(String key) {
		for(Entry<String,Object> entry:values)
		{
			if(key.equals(entry.getKey()))
			{
				return entry.getValue();				
			}
		}		
		return null;
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#superGet(java.lang.String)
	 */
	@Override
	public Object superGet(String key) {
		Object o = null;
		if(parent != null)
		{
			o = parent.superGet(key);
		}
		if(o == null)
		{
			for(Entry<String,Object> entry:values)
			{
				if(key.equals(entry.getKey()))
				{
					o =  entry.getValue();				
				}
			}		
		}
		return o;	
	}
	
	/* (non-Javadoc)
	 * @see fp4g.data.IScope#clone()
	 */
	@SuppressWarnings("unchecked")
	public IScope clone() throws CloneNotSupportedException
	{
		ArrayScope clone = (ArrayScope)super.clone();
		clone.values = (Vector<ArrayEntry>)values.clone();				
		return clone;		
	}

}
