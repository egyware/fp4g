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
 * @author egyware
 *
 */
public class Scope extends Value implements Cloneable{
//	private List<Source>
	private HashMap<String, Object> values = new HashMap<String,Object>();
	private int last_insert = 0;
	private Scope parent;
	
	public Scope()
	{	
		this(null);
	}
	
	public Scope(Scope _parent)
	{	
		super("Scope");
		parent = _parent;
	}
	
	public Object get(String key)
	{
		Object o = values.get(key);
		if(o == null && parent != null)
		{
			o = parent.get(key);
		}
		return o;
	}
	
	public void set(String key, Object value)
	{		
		values.put(key, value);
	}
	
	public void add(Object value)
	{
		values.put(String.valueOf(last_insert++), value);
	}
	
	public int getLastInsert()
	{
		return last_insert;
	}
	
	/**
	 * Copia y sobre escribe de este scope a otro
	 * @param other El otro Scope a copiar
	 * @see writeWithoutOverride
	 */
	public void write(Scope other){
		for(Entry<String, Object> entry :values.entrySet())
		{
			other.set(entry.getKey(),entry.getValue());			
		}
	}
	/**
	 * Copia hacia el otro, pero no sobreescribe las propiedades definidas en el otro Scope hacia este scope
	 * @param other El otro Scope a copiar
	 * @see combine
	 */
	public void writeWithoutOverride(Scope other){
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
	
	public Scope clone() throws CloneNotSupportedException
	{
		Scope clone = (Scope)super.clone();
		clone.values = new HashMap<String,Object>();
		values.putAll(clone.values);		
		return clone;
	}

	@SuppressWarnings("unchecked")
	public Entry<String, Object>[] toArray() {
		Entry<String,Object> array[] = new Entry[values.size()];
		values.entrySet().toArray(array); 
		Arrays.sort(array, Utils.Sort());
		return array;
	}

	public int size() {		
		return values.size();
	}
	public Object localGet(String string) {		
		return values.get(string);	
	}

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
