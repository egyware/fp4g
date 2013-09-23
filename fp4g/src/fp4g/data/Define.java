package fp4g.data;

import java.util.HashMap;
import java.util.Map;

public abstract class Define extends Code{
	public ObjectType type;
	public String name;
	public Define parent;
	public NameList list;
	
	private Map<String,Object> map;
	
	public Define(ObjectType type,String name)
	{
		this(type,name,null);		
	}
	
	public Define(ObjectType type,String name, Define parent)
	{
		this.type = type;
		this.name = name;
		this.parent = parent;
		map = new HashMap<String,Object>();
	}
		
	public ObjectType getType()
	{
		return type;
	}	
	public String getName()
	{
		return name;
	}
	public void setNameList(NameList list) {
		this.list = list;		
	}	
	
	/**
	 * Agrega una adición de codigo
	 * @param code
	 */
	public abstract void addAdd(Add add);	
	/**
	 * Agrega una definición de codigo
	 * @param define
	 */
	public abstract void addDefine(Define define);
	/**
	 * Agrega un evento
	 * @param on
	 */
	public abstract void addOn(On on);
	
	/**
	 * Busca un evento ya agregado y definido
	 * @param message Nombre del mensaje
	 * @return regresa una instancia definida de On si es que existe, si no devuelve null
	 */
	public abstract On getOn(String message);
	
	
	/**
	 * Pregunta si está la definicion
	 * @param name
	 * @return
	 */
	public abstract boolean isDefined(ObjectType type,String name);
	
	/**
	 * Pregunta si está la definicion
	 * @param name
	 * @return
	 */
	public abstract Define getDefine(ObjectType type,String name);
	
	/**
	 * Establece una variable  
	 * @param key nombre de la variable
	 * @param value valor de la variable
	 */
	public final void set(String key, Object value)
	{
		map.put(key, value);
	}
	
	/**
	 * Devuelve el valor de una variable.
	 * @param key
	 * @return
	 */
	public final Object get(String key)
	{
		return map.get(key);
	}	
	
	/**
	 * Verifica si la variable existe.
	 * @param key
	 * @return true, si encontró la variable. False si no existe.
	 */
	public final boolean isSet(String key)
	{
		return map.containsKey(key);
	}
}
