package fp4g.data.expresion;

import org.antlr.v4.misc.Utils;

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
		method.invoke(bean, String.format("set%s",Utils.capitalize(key)),literal.getValue());
		return old;
	}
	@Override
	public Literal<?> get(String key) 
	{
		return new ValueLiteral<Object>(method.invoke(bean, String.format("get%s",Utils.capitalize(key))));		
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
