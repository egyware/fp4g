package fp4g.data.libs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.data.Add;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.IValue;
import fp4g.data.Namespace;
import fp4g.data.On;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.NotAllowedException;
import fp4g.log.info.NotAllowed;

/**
 * Esta clase nos permite integrar las bibliotecas sin tener que "modificar tanto" codigo. (Mentira, ok no solo muchas refractorizaciones) 
 * 
 * Puede ser confusa al principio, pero fue diseñado asi para poder cargar los datos del parser sin tener que rediseñar todo.
 * Esta clase es ahora el padre de Define, hace que el define se comporte como una biblioteca, pero no se trata como tal vea \see Lib
 * 
 * @author Edgardo
 *
 */
public class Lib extends Code implements fp4g.data.expresion.IMap,ILib,IDefine
{
	private final Map<DefineType,Map<String,? extends IDefine>> defines;
	private final Map<String,IValue<?>> variables;
	
	public Lib()
	{			
		defines = new HashMap<DefineType, Map<String, ? extends IDefine>>(DefineType.values().length,1);
		variables = new HashMap<String,IValue<?>>();
		
		//definir namespaces o algo por el estilo.
		for(DefineType t: DefineType.values())
		{
			set(t.name(), new Namespace(t,this));
		}
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
	
	@Override
	public IValue<?> getWithoutDefines(String key) 
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

	@Override
	public DefineType getType() 
	{	
		return null;
	}

	@Override
	public String getName() 
	{
		return Lib.class.getName();
	}

	@Override
	public On getOn(String messageName) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDefine getParent() 
	{	
		return null;
	}

	@Override
	public void setOn(On on) 
	{
		throw new NotAllowedException(NotAllowed.NotExpectedOn, on, "No se esperaba una instrucción ON en Lib");		
	}

	@Override
	public <T extends IDefine> T getDefine(String defineName)
	throws DefineNotFoundException 
	{
		T define = findDefine(defineName);
		if(define == null)
		{
			throw new DefineNotFoundException(defineName);
		}
		return define;
	}

	@Override
	public <T extends Define> T getDefine(DefineType type, String name)
	throws DefineNotFoundException 
	{
		T define = findDefine(type,name);
		if(define == null)
		{
			throw new DefineNotFoundException(type, name);
		}
		return define;
	}

	@Override
	public void setAdd(Add add) 
	{
		throw new NotAllowedException(NotAllowed.NotExpectedAdd, add, "No se esperaba una instrución Add en Lib");		
	}

	@Override
	public IDefine getValue() 
	{	
		return this;
	}

	@Override
	public <V extends IValue<?>> Set<Entry<String, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}
