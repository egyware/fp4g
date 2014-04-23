package fp4g.data.expresion;

import java.util.Map.Entry;
import java.util.Set;

import com.esotericsoftware.reflectasm.ConstructorAccess;

import fp4g.data.IValue;

public final class CustomClassMap extends Literal<IMap> implements IMap
{	
	private IMap bean;
	public CustomClassMap(Class<? extends IMap> type)
	{
		bean = ConstructorAccess.get(type).newInstance();		
	}
	public CustomClassMap(IMap value)
	{
		bean = value;		
	}
	@Override
	public void set(String key, IValue<?> literal) 
	{
		bean.set(key, literal);
	}
	@Override
	public IValue<?> get(String key) 
	{
		return bean.get(key);		
	}
	
	@Override
	public IMap getValue() 
	{
		return bean;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Set<Entry<String, IValue<?>>> entrySet() 
	{
		return bean.entrySet();
	}
}
