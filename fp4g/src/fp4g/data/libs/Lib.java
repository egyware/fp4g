package fp4g.data.libs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import fp4g.data.Add;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;
import fp4g.data.expresion.Literal;
import fp4g.exceptions.DefineNotFoundException;

/**
 * Esta clase nos permite integrar las bibliotecas sin tener que modificar tanto codigo. 
 * 
 * Puede ser confusa al principio, pero fue diseñado asi para poder cargar los datos del parser sin tener que rediseñar todo.
 * 
 * @author Edgardo
 *
 */
public class Lib extends Code implements IDefine
{
	public final IDefine parent;	
	private final Map<DefineType,Map<String,? extends IDefine>> defines;
	
	public static Lib createLib()
	{
		return new Lib();
	}
	
	private Lib()
	{
		this(null);
	}
	public Lib(IDefine parent)
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

	
	//TODO de aqui en adelante implementar todas estas burradas
	@Override
	public Literal<?> get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefineType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public On getOn(String messageName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOn(On on) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends Define> T getDefine(DefineType type, String name)
			throws DefineNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAdd(Add add) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(String key, Literal<?> eval) {
		// TODO Auto-generated method stub
		
	}
		
}
