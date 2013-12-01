package fp4g.data.expresion;

import com.esotericsoftware.reflectasm.ConstructorAccess;

public final class CustomClassMap extends Literal<Map> implements Map{	
	private CustomMap bean;
	public CustomClassMap(Class<? extends CustomMap> type)
	{
		bean = ConstructorAccess.get(type).newInstance();		
	}
	public CustomClassMap(CustomMap value)
	{
		bean = value;		
	}
	@Override
	public Literal<?> set(String key, Literal<?> literal) 
	{
		return bean.set(key, literal);
	}
	@Override
	public Literal<?> get(String key) 
	{
		return bean.get(key);		
	}
	
	public CustomMap getBean()
	{
		return bean;
	}
	
	@Override
	public Map getValue() {
		return this;
	}	

}
