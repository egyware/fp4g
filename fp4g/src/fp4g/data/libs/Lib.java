package fp4g.data.libs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import fp4g.data.Code;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.IValue;

/**
 * Esta clase nos permite integrar las bibliotecas sin tener que "modificar tanto" codigo. (Mentira, ok no solo muchas refractorizaciones) 
 * 
 * Puede ser confusa al principio, pero fue dise�ado asi para poder cargar los datos del parser sin tener que redise�ar todo.
 * Esta clase es ahora el padre de Define, hace que el define se comporte como una biblioteca, pero no se trata como tal vea \see Lib
 * 
 * @author Edgardo
 *
 */
public class Lib extends Code implements fp4g.data.expresion.Map,ILib
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
		return variables.get(key);
	}
	
	
	@SuppressWarnings("unchecked")
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

//	public final <T extends IDefine> T getDefine(String defineName) throws DefineNotFoundException 
//	{
//		for(DefineType type :DefineType.values())
//		{
//			T define = findDefine(type,defineName);
//			if(define != null) return define;
//								
//		}
//		throw new DefineNotFoundException(defineName);		
//	}	
		
}
