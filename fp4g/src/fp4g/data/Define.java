package fp4g.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.data.expresion.ClassMap;
import fp4g.data.expresion.CustomClassMap;
import fp4g.data.expresion.Literal;
import fp4g.data.libs.LibDefine;
import fp4g.exceptions.DefineNotFoundException;

public abstract class Define extends LibDefine implements fp4g.data.expresion.Map,IDefine
{
	public final static List<Add> emptyList = new ArrayList<Add>(0);
	
	public final DefineType type;	
	
	public String name;
	public NameList paramNameList;
		
	private final Map<String,Literal<?>> variables;
	
	private final Map<DefineType,List<Add>> adds;	
	private final Map<String,On> onMessages;	
	
	
	public Define(DefineType type,String name)
	{
		this(type,name,null);		
	}
	
	public Define(DefineType type,String name, IDefine parent)
	{
		super(parent);
		this.type = type;
		this.name = name;		
		variables = new HashMap<String,Literal<?>>();		
		adds    = new HashMap<DefineType, List<Add>>(DefineType.values().length,1);		
		onMessages= new HashMap<String, On>();		
	}
		
	public DefineType getType()
	{
		return type;
	}	
	public String getName()
	{
		return name;
	}
	public void setNameList(NameList list) {
		this.paramNameList = list;		
	}	
	
	public void setAdd(Add add)
	{
		List<Add> list = adds.get(add.getType());
		if(list == null)
		{
			list = new LinkedList<Add>();
			adds.put(add.getType(), list);
		}
		list.add(add);
	}
	
	public void setOn(On on)
	{
		onMessages.put(on.name, on);
	}
	
	/**
	 * Devuelve una lista de adiciones seg�n el tipo
	 * @param type
	 * @return
	 */
	public List<Add> getAdd(DefineType type)
	{
		List<Add> list = adds.get(type);
		if(list == null)
		{
			list = emptyList;
		}
		return list;
	}
	/**
	 * Busca un evento ya agregado y definido
	 * @param message Nombre del mensaje
	 * @return regresa una instancia definida de On si es que existe, si no devuelve null
	 */
	public final On getOn(String messageName)
	{
		return onMessages.get(messageName);
	}
	
	public final <T extends Define> T getDefine(DefineType type,String name) throws DefineNotFoundException 
	{	
		T value = findDefine(type,name);
		if(value == null)throw new DefineNotFoundException(name);
		return value;
	}
		
	public final Collection<On> getOnMessages()
	{
		return onMessages.values();
	}
	
	
	/**
	 * Establece una variable  
	 * @param key nombre de la variable
	 * @param value valor de la variable
	 */
	public void set(String key, Literal<?> value)
	{
		variables.put(key, value);
	}
	/**
	 * Establece una variable  
	 * @param key nombre de la variable
	 * @param value valor de la variable
	 */
	public final void set(String key, Object  value)
	{		
		if(value instanceof fp4g.data.expresion.Map)
		{
			variables.put(key,new CustomClassMap((fp4g.data.expresion.Map)value));
		}
		else
		{
			variables.put(key, new ClassMap<Object>(value));
		}		
	}
		
	/**
	 * Devuelve el valor de una variable.
	 * @param key
	 * @return
	 */
	public Literal<?> get(String key)
	{
		Literal<?> ret = variables.get(key);
		if(ret == null && parent != null)			
		{
			ret = parent.get(key);
		}
		return ret;		 
	}
	
	
	public final Set<Entry<String,Literal<?>>> entrySet()
	{
		return variables.entrySet();
	}
	
	
	/**
	 * Verifica si la variable existe.
	 * @param key
	 * @return true, si encontr� la variable. False si no existe.
	 */
	public final boolean isSet(String key)
	{
		return variables.containsKey(key);
	}
	
}
