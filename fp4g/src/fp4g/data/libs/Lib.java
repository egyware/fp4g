package fp4g.data.libs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.data.Code;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.IValue;
import fp4g.data.expresion.IMap;
import fp4g.exceptions.DefineNotFoundException;

/**
 * Esta clase nos permite integrar las bibliotecas sin tener que "modificar tanto" codigo. (Mentira, ok no solo muchas refractorizaciones) 
 * 
 * Puede ser confusa al principio, pero fue diseñado asi para poder cargar los datos del parser sin tener que rediseñar todo.
 * Esta clase es ahora el padre de Define, hace que el define se comporte como una biblioteca, pero no se trata como tal vea \see Lib
 * 
 * @author Edgardo
 *
 */
public class Lib extends Code implements IMap,ILib
{
	private final Map<DefineType,Map<String,? extends IDefine>> defines;
	private final Map<String,IValue<?>> variables;
	
	public Lib()
	{			
		defines = new HashMap<DefineType, Map<String, ? extends IDefine>>(DefineType.values().length,1);
		variables = new HashMap<String,IValue<?>>();		
	}
	
	@SuppressWarnings("unchecked")
	public final <T extends IDefine> Collection<T> getDefines(DefineType type)
	{
		Map<String,T> map = (Map<String, T>) defines.get(type);
		if(map != null)
		{
			return map.values();
		}
		return null;
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
		for(DefineType type: DefineType.values())
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
		IDefine define = findDefine(key);
		if(define != null)
		{
			return define;
		}
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
	public <V extends IValue<?>> Set<Entry<String, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends IDefine> T getDefine(DefineType defineType, String defineName)
	{
		T define = findDefine(defineType, defineName);
		if(define == null)
		{
			throw new DefineNotFoundException(defineName);
		}
		return define;
			
	}

	@Override
	public <T extends IDefine> T getDefine(String defineName) 
	{
		T define = findDefine(defineName);
		if(define == null)
		{
			throw new DefineNotFoundException(defineName);
		}
		return define;
	}

}
