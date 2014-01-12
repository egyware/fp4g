package fp4g.data.libs;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.ILib;


public class LibContainer implements ILib
{
	public final List<Lib> libs;
	
	public LibContainer()
	{
		libs = new LinkedList<Lib>();
	}

	@Override
	public <T extends Define> T getDefine(String defineName)
	{
		for(Lib lib:libs)
		{
			T define = lib.getDefine(defineName);
			if(define != null)
			{
				return define;
			}
		}
		return null;
	}

	@Override
	public <T extends Define> T getDefine(DefineType defineType, String defineName) {
		for(Lib lib:libs)
		{
			T define = lib.getDefine(defineType,defineName);
			if(define != null)
			{
				return define;
			}
		}
		return null;
	}

	@Override
	public <T extends Define> Collection<T> getDefines(DefineType defineType) 
	{
		for(Lib lib:libs)
		{
			Collection<T> collection = lib.getDefines(defineType);
			if(collection != null)
			{
				return collection;
			}
		}
		return null;
	}
	
}
