package fp4g.data.expresion;

import com.esotericsoftware.reflectasm.ConstructorAccess;

public final class CustomClassMap extends Literal<Map> implements Map
{	
	private Map bean;
	public CustomClassMap(Class<? extends Map> type)
	{
		bean = ConstructorAccess.get(type).newInstance();		
	}
	public CustomClassMap(Map value)
	{
		bean = value;		
	}
	@Override
	public void set(String key, Literal<?> literal) 
	{
		bean.set(key, literal);
	}
	@Override
	public Literal<?> get(String key) 
	{
		return bean.get(key);		
	}
	
	@Override
	public Map getValue() 
	{
		return bean;
	}	

}
