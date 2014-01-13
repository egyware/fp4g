package fp4g.data.libs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import fp4g.data.Code;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
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
public abstract class LibDefine extends Code implements IDefine
{
	public final IDefine parent;	
	private final Map<DefineType,Map<String,? extends IDefine>> defines;
	
	public LibDefine(IDefine parent)
	{
		this.parent = parent;		
		defines = new HashMap<DefineType, Map<String, ? extends IDefine>>(DefineType.values().length,1);
		
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
	
	public final <T extends IDefine> T getDefine(String defineName) throws DefineNotFoundException 
	{
		for(DefineType type :DefineType.values())
		{
			T define = findDefine(type,defineName);
			if(define != null) return define;
								
		}
		throw new DefineNotFoundException(defineName);		
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
		if(value == null && parent != null)
		{
			value = parent.findDefine(type, name);
		}
		return value;
	}
	
	@Override
	public final <T extends IDefine> T findDefine(String defineName) 
	{
		// TODO Auto-generated method stub
		return null;
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
		if(parent != null)
		{
			return parent.isSetDefine(type, name);
		}
		return false;
	}
	
	public final IDefine getParent()
	{
		return parent;
	}

	
		
}
