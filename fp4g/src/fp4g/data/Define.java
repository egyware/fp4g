package fp4g.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.ClassMap;
import fp4g.data.expresion.CustomClassMap;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.NotAllowedOperatorException;

public abstract class Define extends Code implements IDefine
{
	public final static List<Add> emptyList = new ArrayList<Add>(0);
	
	public final DefineType type;	
	
	public String name;
	public NameList paramNameList;
		
	public final IDefine parent;
	
	private final Map<DefineType,Map<String,? extends IDefine>> defines;
	private final Map<String,IValue<?>> variables;
	
	private final Map<DefineType,List<Add>> adds;	
	private final Map<String,On> onMessages;	
	
	
	public Define(DefineType type,String name)
	{
		this(type,name,null);		
	}
	
	public Define(DefineType type,String name, IDefine parent)
	{
		this.parent = parent;
		this.type = type;
		this.name = name;		
		variables = new HashMap<String, IValue<?>>();		
		adds    = new HashMap<DefineType, List<Add>>(DefineType.values().length,1);		
		onMessages= new HashMap<String, On>();
		defines = new HashMap<DefineType,Map<String,? extends IDefine>>();
		
		//definir namespaces o algo por el estilo.
		for(DefineType t: DefineType.values())
		{
			set(t.name(), new Namespace(t,this));
		}
	}
	
	public Define getValue()
	{
		return this;
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
	
	public final Collection<On> getOnMessages()
	{
		return onMessages.values();
	}
	
	/**
	 * Establece una variable  
	 * @param key nombre de la variable
	 * @param value valor de la variable
	 */
	@Override
	public void set(String key, IValue<?> value)
	{
		variables.put(key, value);
	}
	/**
	 * Establece una variable  
	 * @param key nombre de la variable
	 * @param value valor de la variable
	 */
	public final void set(String key, Object value)
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
	public IValue<?> get(String key)
	{
		IValue<?> ret = findDefine(key); 
		if(ret == null)
		{
			ret = variables.get(key);
		}				
		if(ret == null && parent != null)
		{
				ret = parent.get(key);
		}		
		return ret;		 
	}
	
	
	public IValue<?> getWithoutDefines(String key)
	{
		IValue<?> ret = variables.get(key);		
		if(ret == null && parent != null)
		{
				ret = parent.getWithoutDefines(key);
		}		
		return ret;		 
	}
	
	/**
	 * 
	 * Devuelve todos las variables definidas en este define
	 * 
	 * @return
	 */
	public final Set<Entry<String,IValue<?>>> entrySet()
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
	
	public String toString()
	{
		//TODO mostrar los add y On
		StringBuilder builder = new StringBuilder();
		builder.append("DEFINE ");
		builder.append(type.name());
		builder.append(' ');
		builder.append(name);
		//builder.append('\n');
					
		return builder.toString();
	}

	@Override
	public final <T extends IDefine> T findDefine(String defineName) 
	{
		for(DefineType type: DefineType.values())
		{
			T define = findDefine(type,defineName);
			if(define != null)
			{
				return define;
			}
			if(define == null && parent != null)
			{
				define = parent.findDefine(type,defineName);
			}
		}		
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public final <T extends IDefine> T findDefine(DefineType type,String defineName)
	{
		final Map<String,T> map = (Map<String, T>) defines.get(type);
		T value = null;		
		if(map != null)
		{
			value = map.get(defineName);
		}
		if(value == null && parent != null)
		{
			value = parent.findDefine(type,defineName);
		}
		return value;
	}
	
	@Override
	@SuppressWarnings("unchecked")	
	public <T extends IDefine> Collection<T> getDefines(DefineType defineType) 
	{
		Map<String,T> map = (Map<String, T>) defines.get(defineType);
		Collection<T> defines = null;
		if(map != null)
		{
			defines = map.values();
		}
		if(parent != null)
		{
			Collection<T> parentsCollection = parent.getDefines(defineType);
			if(defines == null)
			{
				defines = parentsCollection;
			}
			else if(parentsCollection != null)
			{
				ArrayList<T> defines2= new ArrayList<T>(defines.size()+parentsCollection.size());
				
				defines2.addAll(defines);
				defines2.addAll(parentsCollection);
				
				defines = defines2;				
			}
		}
		
		return defines;
	}
	
	@Override
	public final <T extends Define> T getDefine(DefineType type,String name) throws DefineNotFoundException 
	{	
		T value = findDefine(type,name);
		if(value == null)throw new DefineNotFoundException(type,name);
		return value;
	}
	
	@Override
	public <T extends IDefine> T getDefine(String defineName)
	throws DefineNotFoundException 
	{
		for(DefineType type :DefineType.values())
		{
			T define = findDefine(type,defineName);
			if(define != null) 
			{
				return define;
			}						
		}
		throw new DefineNotFoundException(defineName);	
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T extends IDefine> boolean isSetDefine(DefineType type, String name) 
	{
		Map<String,T> map = (Map<String, T>) defines.get(type);
		if(map != null)
		{
			if(map.containsKey(name))
			{
				return true; 
			}
		}
		if(parent != null)
		{
			return parent.isSetDefine(type,name);
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends IDefine> void setDefine(T define) {
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
	public IDefine getParent() 
	{
		return parent;
	}
	
	public IValue<?> sum(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Add);
	}
	
	public IValue<?> mult(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Mult);
	}
	
	public IValue<?> div(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Div);
	}
	
	public IValue<?> sub(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Sub);
	}
}
