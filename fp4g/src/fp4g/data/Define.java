package fp4g.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.BeanAccess;
import fp4g.core.Expresion;
import fp4g.core.IValue;
import fp4g.data.add.AddAsset;
import fp4g.data.add.AddDefine;
import fp4g.data.add.AddMethod;
import fp4g.data.expresion.literals.BoolLiteral;
import fp4g.data.expresion.literals.FloatLiteral;
import fp4g.data.expresion.literals.IntegerLiteral;
import fp4g.data.expresion.literals.ObjectLiteral;
import fp4g.data.expresion.literals.StringLiteral;
import fp4g.data.vartypes.BasicType;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.FP4GError;

public abstract class Define extends Code implements IDefine
{
	public final static List<AddDefine> emptyList = new ArrayList<AddDefine>(0);
	
	public final DefineType type;	
	
	public String name;
	private NameList flags;
	public NameList paramNameList;
	public LinkedList<When> whenList;
		
	public final ILib lib;
	
	private final Map<DefineType,List<AddDefine>> addDefines;	
	private final Map<String,AddAsset> addAssets;
	private final Map<String,AddMethod> addMethods;
	private final Map<String,On> onMessages;	
	
	private final BeanAccess beanAccess;
	
	
	public Define(DefineType type,String name)
	{
		this(type,name,null);		
	}
	
	public Define(DefineType type,String name, ILib lib)
	{
		this.lib = lib;
		this.type = type;
		this.name = name;
		
		addDefines = new HashMap<DefineType, List<AddDefine>>(DefineTypes.values().length,1);
		addAssets  = new HashMap<String,     AddAsset>();
		addMethods = new HashMap<String,     AddMethod>();
		
		onMessages= new HashMap<String, On>();
		
		beanAccess = BeanAccess.getBeanAccess(getClass());		
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
	public NameList getFlags()
	{
		return flags;
	}
	
	public void addFlags(NameList list) 
	{
		flags = list;		
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
			throw new FP4GRuntimeException(FP4GError.IllegalState, add.getAddType().toString());			
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
		beanAccess.set(this, key, value.getValue());			
	}
	
	public final IValue<?> get(String key)
	{
		IValue<?> ret = find(key);
		if(ret == null)
		{
			ret = lib.get(key);
		}
		return ret;
	}
		
	/**
	 * Devuelve el valor de una variable.
	 * @param key
	 * @return
	 */
	public final IValue<?> find(String key)
	{
		Object r = beanAccess.get(this, key);		
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
		else if(r != null)
		{
			return new ObjectLiteral(r);
		}		
		else
		{
			return null;
		}
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		if(this.isGenerable())
			builder.append("DEFINE ");
		if(this.isUsable())
			builder.append("USING ");
		builder.append(type.name());
		builder.append(' ');
		builder.append(name);
		if(paramNameList != null)
		{
			builder.append(" (");
			for(Iterator<DeclVar> it = paramNameList.iterator();it.hasNext();)
			{
				DeclVar paramName = it.next();
				builder.append(paramName.type.name());
				builder.append(' ');
				builder.append(paramName.name);
				if(paramName.initValue != null)
				{
					builder.append(" = ");
					builder.append(paramName.initValue);
				}
				if(it.hasNext())
				{
					builder.append(", ");
				}
			}
			builder.append(')');
		}
		//(Number x, Number y)
		
		builder.append("[ ... ]");		
					
		return builder.toString();
	}

	@Override
	public ILib getLibrary() 
	{
		return lib;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Set<Entry<String, IValue<?>>> entrySet() 
	{
		String properties[] = beanAccess.getProperties();
		HashMap<String, IValue<?>> map = new HashMap<String,IValue<?>>();
		for(String property:properties)
		{
			map.put(property, get(property));
		}		
		return map.entrySet();
	}		

	
	private int when_counter;	
	public void addWhen(Expresion expresion, Statement statement)
	{
		final DeclVar flag = new DeclVar(BasicType.Bool,String.format("whenFlag_%d", ++when_counter));
		addFlag(flag);
		if(whenList == null)
		{
			whenList = new LinkedList<When>();
		}
		whenList.add(new When(expresion, statement, flag));		
	}
	
	@Override
	public IValue<?> eval(IValue<?> value) throws CannotEvalException 
	{
		return this;
	}

	@Override
	public Add findAddDefineByName(String name) 
	{
		Add found = addAssets.get(name);
		if(found != null)
		{
			return found;
		}
		found = addMethods.get(name);
		if(found != null)
		{
			return found;
		}
		for(List<AddDefine> list:addDefines.values())
		{
			for(AddDefine add:list)
			{
				if(add.name.compareTo(name) == 0)
				{
					return add;
				}
			}
		}			
		return null;
	}	
}
