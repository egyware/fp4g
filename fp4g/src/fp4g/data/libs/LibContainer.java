package fp4g.data.libs;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.data.Code;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.IValue;
import fp4g.exceptions.DefineNotFoundException;

public class LibContainer extends Code implements ILib
{
	public final List<Lib> libs;
	
	public LibContainer()
	{	
		libs = new LinkedList<Lib>();		
	}
	
	public void addLib(Lib lib) {
		libs.add(lib);		
	}

	@Override
	public <T extends IDefine> T findDefine(String defineName) 
	{
		for(Lib lib:libs)
		{
			T define = lib.findDefine(defineName);
			if(define != null)
			{
				return define;
			}			
		}
		return null;
	}

	@Override
	public <T extends IDefine> T findDefine(DefineType defineType,String defineName) 
	{		
		for(Lib lib:libs)
		{
			T define = lib.findDefine(defineType,defineName);
			if(define != null)
			{
				return define;
			}			
		}
		return null;
	}

	@Override
	public <T extends IDefine> Collection<T> getDefines(DefineType defineType) 
	{
		List<T> list = new LinkedList<T>();
		for(Lib lib:libs)
		{
			Collection<T> collection = lib.getDefines(defineType);
			if(collection != null)
			{
				list.addAll(collection);
			}
		}
		return list;
	}

	@Override
	public <T extends IDefine> boolean isSetDefine(DefineType type, String name) 
	{
		for(Lib lib:libs)
		{
			if(lib.isSetDefine(type,name)) return true;			
		}
		return false;
	}

	
	@Override
	public IValue<?> get(String key)
	{
		for(Lib lib:libs)
		{
			IValue<?> value = lib.get(key);
			if(value != null) return value;
		}
		return null;
	}
	
	//IDefine implements
	
	@Override
	public String getName() 
	{
		return LibContainer.class.getSimpleName();
	}

	@Override
	public void set(String key, IValue<?> value) {
		// TODO Auto-generated method stub
		
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

	@Override
	public <T extends IDefine> void setDefine(T define)
	{
		// TODO Auto-generated method stub		
	}

	
		
}
