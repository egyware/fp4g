package fp4g.data.libs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.core.IValue;
import fp4g.data.Code;
import fp4g.data.DefineType;
import fp4g.data.DefineTypes;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.expresion.IMap;
import fp4g.exceptions.DefineNotFoundException;

/**
 * Esta clase nos permite integrar las bibliotecas sin tener que "modificar tanto" codigo. (Mentira, ok no solo muchas refractorizaciones) 
 * 
 * Puede ser confusa al principio, pero fue dise�ado asi para poder cargar los datos del parser sin tener que redise�ar todo.
 * Esta clase es ahora el padre de Define, hace que el define se comporte como una biblioteca, pero no se trata como tal vea \see Lib
 * 
 * @author Edgardo
 *
 */
public class Lib extends Code implements IMap,ILib
{
	private final Map<DefineType,Map<String,? extends IDefine>> defines;
	private final Map<String,IValue<?>> variables;
	private final ILib parent;	
	
	public Lib(ILib parent)
	{			
		defines = new HashMap<DefineType, Map<String, ? extends IDefine>>(DefineTypes.values().length,1);
		variables = new HashMap<String,IValue<?>>();
		this.parent = parent;
	}
	
	@SuppressWarnings("unchecked")
	public final <T extends IDefine> Collection<T> getLocalDefines(DefineType type)
	{
		Map<String,T> map = (Map<String, T>) defines.get(type);
		if(map != null)
		{
			return map.values();
		}
		return null;
	}
	
	public final <T extends IDefine> Collection<T> getDefines(DefineType type)
	{
		return parent.getDefines(type);
	}
	
	@SuppressWarnings("unchecked")
	public final <T extends IDefine> boolean isSetDefine(DefineType type,String name)
	{
		Map<String,T> map = (Map<String, T>) defines.get(type);
		if(map != null)
		{
			return map.containsKey(name);
		}		
		return false;
	}	
	@Override
	public final <T extends IDefine> boolean isGlobalSetDefine(DefineType type, String name) 
	{
		if(isSetDefine(type,name))
		{
			return true;
		}
		else if(parent != null)
		{
			return parent.isGlobalSetDefine(type, name);
		}
		else
		{
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public final <T extends IDefine> T findDefine(DefineType type,String name)
	{
		final Map<String,T> map = (Map<String, T>) defines.get(type);
		T value = null;		
		if(map != null)
		{
			value = map.get(name);
		}		
		return value;
	}
	
	public final <T extends IDefine> T findDefine(String defineName) 
	{
		for(DefineType type: DefineTypes.values())
		{
			T define = findDefine(type,defineName);
			if(define != null)
			{
				return define;
			}
		}
		return null;
	}

	@Override
	public void set(String key, IValue<?> value)
	{
		variables.put(key, value);
	}
	
	@Override
	public IValue<?> get(String key) 
	{
		IValue<?> value = find(key);
		if(value == null)
		{
			value = parent.find(key);
		}
		return value;		
	}
	
	@Override
	public IValue<?> find(String key) 
	{
		IDefine define = findDefine(key);
		if(define != null)
		{
			return define;
		}
		//no deber�a seguir buscando hacia abajo, solo conformarse con encontrar una variable de biblioteca o un define
		return variables.get(key);		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends IDefine> void setDefine(T define)
	{
		final DefineType type = define.getType();	
		Map<String,T> map = (Map<String, T>) defines.get(type);
		if(map == null)
		{
			map = new HashMap<String, T>();
			defines.put(type, map);
		}
		map.put(define.getName(), define);	
		
	}

	
	@Override
	public String getName() 
	{
		return Lib.class.getName();
	}

	@Override
	public <V extends IValue<?>> Set<Entry<String, V>> entrySet() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends IDefine> T getDefine(DefineType defineType, String defineName) throws DefineNotFoundException
	{
		T define = findDefine(defineType, defineName);
		if(define == null)
		{
			return parent.getDefine(defineType, defineName); //al uzar get, lanzar� una excepci�n si no lo encuentra
		}
		return define;
			
	}

	@Override
	public <T extends IDefine> T getDefine(String defineName) throws DefineNotFoundException 
	{
		T define = findDefine(defineName);
		if(define == null)
		{
			return parent.getDefine(defineName);
		}
		return define;
	}

		@Override
	public ILib getValue() 
	{
		return this;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("DEFINE GAME\n");
		builder.append("[\n");
		for(Entry<String, IValue<?>> entry:variables.entrySet())
		{
			builder.append('\t');
			builder.append("SET ");
			builder.append(entry.getKey());
			builder.append(' ');
			builder.append(entry.getValue());
			builder.append('\n');
		}
	for(Map<String, ? extends IDefine> listDefines:defines.values())
		{
			for(IDefine define:listDefines.values())
			{
				builder.append('\t');
				builder.append(define);
				builder.append('\n');
			}			
		}
		builder.append("]\n");		
		return builder.toString();
	}

	

}
