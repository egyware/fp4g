package fp4g.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.misc.Utils;

import com.esotericsoftware.reflectasm.MethodAccess;

import fp4g.data.expresion.ClassMap;
import fp4g.data.expresion.CustomClassMap;
import fp4g.data.expresion.literals.BoolLiteral;
import fp4g.data.expresion.literals.FloatLiteral;
import fp4g.data.expresion.literals.IntegerLiteral;
import fp4g.data.expresion.literals.ObjectLiteral;
import fp4g.data.expresion.literals.StringLiteral;
import fp4g.data.vartypes.BasicType;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.info.GeneratorError;

public abstract class Define extends Code implements IDefine
{
	public final static List<AddDefine> emptyList = new ArrayList<AddDefine>(0);
	
	public final DefineType type;	
	
	public String name;	
	public NameList flags;
	public NameList paramNameList;
	public LinkedList<When> whenList;
		
	public final IDefine parent;
	
	private final Map<DefineType,Map<String,? extends IDefine>> defines;
	private final Map<String,IValue<?>> variables;
	
	private final Map<DefineType,List<AddDefine>> addDefines;	
	private final Map<String,AddAsset> addAssets;
	private final Map<String,AddMethod> addMethods;
	private final Map<String,On> onMessages;	
	
	private final MethodAccess method;
	
	
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
		
		addDefines = new HashMap<DefineType, List<AddDefine>>(DefineType.values().length,1);
		addAssets  = new HashMap<String,     AddAsset>();
		addMethods = new HashMap<String,     AddMethod>();
		
		onMessages= new HashMap<String, On>();
		defines = new HashMap<DefineType,Map<String,? extends IDefine>>();
		
		method = MethodAccess.get(type.getDefineClass());
		
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
	
	public void addFlag(DeclVar flag) 
	{
		if(flags == null)
		{
			flags = new NameList();
		}
		flags.add(flag);		
	}
	
	public void addFlags(NameList list) 
	{
		if(flags == null)
		{
			flags = new NameList();
		}
		for(DeclVar flag: list)
		{
			flags.add(flag);
		}
	}
	
	public void setAdd(Add add)
	{
		switch(add.getAddType())
		{
		case AddAsset:
			addAssets.put(add.name, (AddAsset)add);
			break;
		case AddDefine:
			AddDefine addDefine = (AddDefine)add;
			List<AddDefine> list = addDefines.get(addDefine.type);
			if(list == null)
			{
				list = new LinkedList<AddDefine>();
				addDefines.put(addDefine.getType(), list);
			}
			list.add(addDefine);
			break;
		case AddMethod:
			addMethods.put(add.name, (AddMethod)add);
			break;
		default:
			throw new FP4GRuntimeException(GeneratorError.IllegalState, add.getAddType().toString());			
		}
	}
	
	public void setOn(On on)
	{
		onMessages.put(on.name, on);
	}
	
	/**
	 * Devuelve una lista de adiciones según el tipo
	 * @param type
	 * @return
	 */
	public List<AddDefine> getAddDefines(DefineType type)
	{		
		List<AddDefine> list = addDefines.get(type);
		if(list == null)
		{
			list = emptyList;
		}
		return list;
	}
	
	public Collection<AddAsset> getAddAssets()
	{
		return addAssets.values();
	}
	
	public Collection<AddMethod> getAddMethods()
	{
		return addMethods.values();
	}
	
	public AddMethod getAddMethod(String method) 
	{
		return addMethods.get(method);
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
	public final void set(String key, IValue<?> value) 
	{			
		try
		{		
			method.invoke(this, String.format("set%s",Utils.capitalize(key)), value.getValue());
			return;
		}
		catch(IllegalArgumentException e)
		{
			//solo ignoro el error
		}
		variables.put(key, value);		
	}
	/**
	 * Establece una variable  
	 * @param key nombre de la variable
	 * @param value valor de la variable
	 */
	public final void set(String key, Object value)
	{		
		try
		{
			method.invoke(this, String.format("set%s",Utils.capitalize(key)), value);
			return;
		}
		catch(IllegalArgumentException e)
		{
			//solo te ignoro
		}
		if(value instanceof fp4g.data.expresion.IMap)
		{
			variables.put(key,new CustomClassMap((fp4g.data.expresion.IMap)value));
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
	public final IValue<?> get(String key)
	{
		IValue<?> ret = findDefine(key);
		if(ret == null)
		{
			final String methods[] = method.getMethodNames();
			String keyMethod = Utils.capitalize(key);
			int indexMethod;
			for(indexMethod = 0; indexMethod < methods.length;indexMethod++)
			{
				final String nameMethod = methods[indexMethod];
				final int lenMethod = nameMethod.length();
				
				if(nameMethod.endsWith(keyMethod) && ((methods[indexMethod].startsWith("get") && (keyMethod.length() + 3 == lenMethod))||(nameMethod.startsWith("is") && (keyMethod.length() + 2 == lenMethod))))
				{
					Object r = method.invoke(this,indexMethod);
					if(r instanceof Float)
					{
						return new FloatLiteral((Float)r);
					}
					else
					if(r instanceof Integer)
					{
						return new IntegerLiteral((Integer)r);
					}
					else
					if(r instanceof Boolean)
					{
						return new BoolLiteral((Boolean)r);
					}
					else
					if(r instanceof String)
					{
						return new StringLiteral((String)r);
					}
					else
					{
						return new ObjectLiteral(r);
					}
				}
			}
		}
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
	@SuppressWarnings("unchecked")
	public final Set<Entry<String,IValue<?>>> entrySet()
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
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("DEFINE ");
		builder.append(type.name());
		builder.append(' ');
		builder.append(name);
		builder.append("[ ... ]");		
					
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

	
	private int when_counter;	
	public void addWhen(Expresion expresion, ILine statement)
	{
		final DeclVar flag = new DeclVar(BasicType.Bool,String.format("whenFlag_%d", ++when_counter));
		addFlag(flag);
		if(whenList == null)
		{
			whenList = new LinkedList<When>();
		}
		whenList.add(new When(expresion, statement, flag));		
	}
	

}
