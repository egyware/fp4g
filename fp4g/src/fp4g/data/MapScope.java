/**
 * 
 */
package fp4g.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.generator.Utils;

/**
 * Esta clase permite guardar variables, definiciones, adiciones, mensajes, etc...
 * Guarda datos como un par (String key, Object value) en un Map
 * Finalmente cuando se necesitan recorrer los datos, este los devuelve ordenados con algún criterio establecido.
 * @author egyware
 *
 */
public final class MapScope extends Value implements Cloneable, IScope{
	private HashMap<String, Object> values = new HashMap<String,Object>();
	private int last_insert = 0;
	private final IScope parent;
	
	public MapScope()
	{	
		this(null);
	}
	
	public MapScope(IScope _parent)
	{	
		super("Scope");
		parent = _parent;
	}
	
	/* (non-Javadoc)
	 * @see fp4g.data.IScope#get(java.lang.String)
	 */
	@Override
	public Object get(String key)
	{
		Object o = values.get(key);
		if(o == null && parent != null)
		{
			o = parent.get(key);
		}
		return o;
	}
	
	/* (non-Javadoc)
	 * @see fp4g.data.IScope#set(java.lang.String, java.lang.Object)
	 */
	@Override
	public void set(String key, Object value)
	{		
		values.put(key, value);
	}
	
	/* (non-Javadoc)
	 * @see fp4g.data.IScope#add(java.lang.Object)
	 */
	@Override
	public void add(Object value)
	{
		values.put(String.valueOf(last_insert++), value);
	}
	
	/* (non-Javadoc)
	 * @see fp4g.data.IScope#getLastInsert()
	 */
	@Override
	public int getLastInsert()
	{
		return last_insert;
	}
	
	/* (non-Javadoc)
	 * @see fp4g.data.IScope#write(fp4g.data.IScope)
	 */
	@Override
	public void writeAndOverride(IScope other){
		for(Entry<String, Object> entry :values.entrySet())
		{
			other.set(entry.getKey(),entry.getValue());			
		}
	}
	/* (non-Javadoc)
	 * @see fp4g.data.IScope#writeWithoutOverride(fp4g.data.IScope)
	 */
	@Override
	public void writeWithoutOverride(IScope other){
		for(Entry<String, Object> entry :values.entrySet())
		{
			//sobre escribe las propiedades
			String key = entry.getKey();
			if(other.get(key) == null)
			{
				other.set(key,entry.getValue());
			}
		}
	}
	
	
	public Set<Entry<String,Object>> EntrySet()
	{		
		return values.entrySet();
	}
	
	/* (non-Javadoc)
	 * @see fp4g.data.IScope#clone()
	 */
	@Override
	public IScope clone() throws CloneNotSupportedException
	{
		MapScope clone = (MapScope)super.clone();
		clone.values = new HashMap<String,Object>();
		values.putAll(clone.values);		
		return clone;
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#toArray()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Entry<String, Object>[] toArray() {
		Entry<String,Object> array[] = new Entry[values.size()];
		values.entrySet().toArray(array); 
		Arrays.sort(array, Utils.Sort());
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
	 * @see fp4g.data.IScope#localGet(java.lang.String)
	 */
	@Override
	public Object localGet(String string) {		
		return values.get(string);	
	}

	/* (non-Javadoc)
	 * @see fp4g.data.IScope#superGet(java.lang.String)
	 */
	@Override
	public Object superGet(String string) {
		Object o = null;
		if(parent != null)
		{
			o = parent.superGet(string);
		}
		if(o == null)
		{
			o = values.get(string);
		}
		return o;		
	}
	
}
