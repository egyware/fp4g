package fp4g.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fp4g.BeanAccess;
import fp4g.data.add.AddAsset;
import fp4g.data.add.AddDefine;
import fp4g.data.add.AddMethod;
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
		
		addDefines = new HashMap<DefineType, List<AddDefine>>(DefineType.values().length,1);
		addAssets  = new HashMap<String,     AddAsset>();
		addMethods = new HashMap<String,     AddMethod>();
		
		onMessages= new HashMap<String, On>();
		
		beanAccess = BeanAccess.getBeanAccess(type.getDefineClass());		
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
		beanAccess.set(this, key, value.getValue());			
	}
		
	/**
	 * Devuelve el valor de una variable.
	 * @param key
	 * @return
	 */
	public final IValue<?> get(String key)
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
		else
		{
			return new ObjectLiteral(r);
		}		
	}
	
	public <T extends Define> T getDefine(String name)
	{
		T define = lib.findDefine(name);
		if(define == null)
		{
			throw new DefineNotFoundException(name);			
		}
		return define;			
	}
	public <T extends Define> T getDefine(DefineType type, String name)
	{
		T define = lib.findDefine(type, name);
		if(define == null)
		{
			throw new DefineNotFoundException(name);			
		}
		return define;			
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
	public ILib getLibrary() 
	{
		return lib;
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
}
