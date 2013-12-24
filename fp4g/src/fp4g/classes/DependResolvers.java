package fp4g.classes;

import java.util.HashMap;

import fp4g.data.Define;
import fp4g.data.expresion.CustomClassMap;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.Map;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.generator.Depend;

public class DependResolvers implements Map
{		
	private HashMap<String, CustomClassMap> resolvers;
	
	public DependResolvers()
	{
		resolvers = new HashMap<String, CustomClassMap>();
	}
	
	@Override
	public void set(String key, Literal<?> value)
	{
		resolvers.put(key.toLowerCase(), (CustomClassMap)value);		
	}

	@Override
	public Literal<?> get(String key)
	{		
		return resolvers.get(key);
	}
	
	public Depend getResolver(Define define) throws DependResolverNotFoundException
	{
		CustomClassMap dependInMap = resolvers.get(define.type.name().toLowerCase());
		if(null == dependInMap) throw new DependResolverNotFoundException(define.name);
		
		return (Depend)dependInMap.getValue();
	}

}