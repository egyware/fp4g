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
import fp4g.exceptions.DefineNotFoundException;

@SuppressWarnings("unchecked")
public abstract class Define extends Code implements fp4g.data.expresion.Map
{
	public final static List<Add> emptyList = new ArrayList<Add>(0);
	
	public final DefineType type;
	public final Define parent;
	
	public String name;
	public NameList paramNameList;
		
	private final Map<String,Literal<?>> variables;	
	
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
		variables = new HashMap<String,Literal<?>>();		
		adds    = new HashMap<DefineType, List<Add>>(DefineType.values().length,1);
		defines = new HashMap<DefineType, Map<String, ? extends Define>>(DefineType.values().length,1);
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
	
	/**
	 * Agrega una adición de codigo
	 * @param code
	 */
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
	/**
	 * Agrega una definiciï¿½n de codigo
	 * @param define
	 */	
	public <T extends Define> void setDefine(T define)
	{
		final DefineType type = define.getType();
		Map<String,T> map = (Map<String, T>) defines.get(type);
		if(map == null)
		{
			map = new HashMap<String, T>();
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
	 * Devuelve una lista de adiciones segï¿½n el tipo
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
	 * @throws DefineNotFoundException 
	 */	
	public final <T extends Define> T getDefine(DefineType type,String name) throws DefineNotFoundException 
	{	
		T value = getDefinePriv(type,name);
		if(value == null)throw new DefineNotFoundException(name);
		return value;
	}
	
	private final <T extends Define> T getDefinePriv(DefineType type,String name)
	{
		final Map<String,T> map = (Map<String, T>) defines.get(type);
		T value = null;		
		if(map != null)
		{
			value = map.get(name);
		}
		if(value == null && parent != null)
		{
			value = parent.getDefinePriv(type, name);
		}
		return value;
	}
	
	/**
	 * Busca un define de tipo desconocido
	 * @param name Nombre de la definición
	 * @return Define La definición buscada, si no devuelve null
	 * @throws DefineNotFoundException 
	 */
	public Define getDefine(String name) throws DefineNotFoundException 
	{
		for(DefineType type :DefineType.values())
		{
			Define define = getDefinePriv(type,name);
			if(define != null) return define;
								
		}
		throw new DefineNotFoundException(name);		
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
	 * Pregunta si estï¿½ la definicion
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
		if(parent != null)
		{
			return parent.isSetDefine(type, name);
		}
		return false;
	}
	
	
	/**
	 * Establece una variable  
	 * @param key nombre de la variable
	 * @param value valor de la variable
	 */
	public final void set(String key, Literal<?> value)
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
	public final Literal<?> get(String key)
	{
		return variables.get(key);		 
	}
	
	/**
	 * Devuelve todas las variables de tiene almacenado este define
	 * @return
	 */
	public final Set<Entry<String,Literal<?>>> entrySet()
	{
		return variables.entrySet();
	}
	
	
	/**
	 * Verifica si la variable existe.
	 * @param key
	 * @return true, si encontrï¿½ la variable. False si no existe.
	 */
	public final boolean isSet(String key)
	{
		return variables.containsKey(key);
	}
	
}
