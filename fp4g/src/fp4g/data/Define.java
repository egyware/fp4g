package fp4g.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public abstract class Define extends Code{
	public final static List<Add> emptyList = new ArrayList<>(0);
	
	public final DefineType type;
	public final Define parent;
	
	public String name;
	public NameList paramNameList;
	
	private Map<String,Object> variables;
	
	private final Map<DefineType,List<Add>> adds;
	private final Map<DefineType,Map<String,? extends Define>> defines;
	private final Map<String,On> onMessages;
	
	public Define(DefineType type,String name)
	{
		this(type,name,null);		
	}
	
	public Define(DefineType type,String name, Define parent)
	{
		this.type = type;
		this.name = name;
		this.parent = parent;
		variables = new HashMap<String,Object>();
		adds    = new HashMap<>(DefineType.values().length,1);
		defines = new HashMap<>(DefineType.values().length,1);
		onMessages= new HashMap<>();
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
	
	/**
	 * Agrega una adición de codigo
	 * @param code
	 */
	public void setAdd(Add add)
	{
		List<Add> list = adds.get(add.getType());
		if(list == null)
		{
			list = new LinkedList<>();
			adds.put(add.getType(), list);
		}
		list.add(add);
	}
	/**
	 * Agrega una definición de codigo
	 * @param define
	 */	
	public <T extends Define> void setDefine(T define)
	{
		final DefineType type = define.getType();
		Map<String,T> map = (Map<String, T>) defines.get(type);
		if(map == null)
		{
			map = new HashMap<>();
			defines.put(type, map);
		}
		map.put(define.name, define);
	}
	/**
	 * Agrega un evento
	 * @param on
	 */
	public void setOn(On on)
	{
		onMessages.put(on.name, on);
	}
	
	/**
	 * Devuelve una lista de adiciones según el tipo
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
	
	/**
	 * Obtiene una definición
	 * @param name
	 * @return
	 */	
	public final <T extends Define> T getDefine(DefineType type,String name)
	{	
		final Map<String,T> map = (Map<String, T>) defines.get(type);
		T value = null;		
		if(map != null)
		{
			value = map.get(name);
		}
		if(value == null && parent != null)
		{
			value = parent.getDefine(type, name);
		}
		return value;
	}
	
	public final <T extends Define> Collection<T> getDefines(DefineType type)
	{
		Map<String,T> map = (Map<String, T>) defines.get(type);
		if(map != null)
		{
			return map.values();
		}
		return null;
	}
	
	public final Collection<On> getOnMessages()
	{
		return onMessages.values();
	}
	
	/**
	 * Pregunta si está la definicion
	 * @param name
	 * @return
	 */
	public final <T extends Define> boolean isSetDefine(DefineType type,String name)
	{
		Map<String,T> map = (Map<String, T>) defines.get(type);
		if(map != null)
		{
			return map.containsKey(name);
		}
		return false;
	}
	
	
	/**
	 * Establece una variable  
	 * @param key nombre de la variable
	 * @param value valor de la variable
	 */
	public final void set(String key, Object value)
	{
		variables.put(key, value);
	}
	
	/**
	 * Devuelve el valor de una variable.
	 * @param key
	 * @return
	 */
	public final Object get(String key)
	{
		return variables.get(key);
	}	
	
	/**
	 * Verifica si la variable existe.
	 * @param key
	 * @return true, si encontró la variable. False si no existe.
	 */
	public final boolean isSet(String key)
	{
		return variables.containsKey(key);
	}
}
