package fp4g.data.expresion;

import org.antlr.v4.misc.Utils;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

public final class ClassMap extends Literal<Map> implements Map
{	
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
		final String methods[] = method.getMethodNames();
		key = Utils.capitalize(key);
		int indexMethod;
		for(indexMethod = 0 ;indexMethod<methods.length;indexMethod++)
		{
			if(methods[indexMethod].endsWith(key) && (methods[indexMethod].startsWith("get")||methods[indexMethod].startsWith("is")))
			{
				return new ValueLiteral<Object>(method.invoke(bean,indexMethod));
			}
		}
		throw new IllegalArgumentException(String.format("Unable to find public method: set/is%s", key));
				
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
