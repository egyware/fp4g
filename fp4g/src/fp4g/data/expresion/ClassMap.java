package fp4g.data.expresion;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

public final class ClassMap extends Literal<Map> implements Map{
	private MethodAccess method;
	private Object bean;
	public ClassMap(Class<?> type)
	{
		bean = ConstructorAccess.get(type).newInstance();
		method = MethodAccess.get(type);
	}
	public ClassMap(Object value)
	{
		bean = value;
		method = MethodAccess.get(value.getClass());
	}
	@Override
	public Literal<?> set(String key, Literal<?> literal) 
	{
		Literal<?> old = get(key);
		method.invoke(bean, String.format("set%s",capitalize(key)),literal.getValue());
		return old;
	}
	@Override
	public Literal<?> get(String key) 
	{
		return new ValueLiteral<Object>(method.invoke(bean, String.format("get%s",capitalize(key))));		
	}
	
	//TODO To utils
	public static String capitalize(String key)
	{
		char chars[] = key.toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);
		return String.valueOf(chars);
	}
	
	public Object getBean()
	{
		return bean;
	}
	
	@Override
	public Map getValue() {
		return this;
	}
	

}
