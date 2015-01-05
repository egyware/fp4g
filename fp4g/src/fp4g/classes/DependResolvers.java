package fp4g.classes;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.core.IValue;
import fp4g.data.Define;
import fp4g.data.expresion.IMap;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.generator.Depend;

public class DependResolvers implements IMap
{		
	private HashMap<String, IValue<?>> resolvers;
	
	public DependResolvers()
	{
		resolvers = new HashMap<String, IValue<?>>();
	}
	
	@Override
	public void set(String key, IValue<?> value)
	{
		resolvers.put(key.toLowerCase(), value);		
	}

	@Override
	public IValue<?> get(String key)
	{		
		return resolvers.get(key);
	}
	
	public Depend getResolver(Define define) throws DependResolverNotFoundException
	{
		IValue<?> dependInMap = resolvers.get(define.type.name().toLowerCase());
		if(null == dependInMap) throw new DependResolverNotFoundException(define.name);
		
		return (Depend)dependInMap.getValue();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<Entry<String, IValue<?>>> entrySet() 
	{
		return resolvers.entrySet();
	}

}
