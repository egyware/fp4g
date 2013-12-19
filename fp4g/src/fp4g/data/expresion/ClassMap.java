package fp4g.data.expresion;

import org.antlr.v4.misc.Utils;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

public final class ClassMap<T> extends Literal<T> implements Map
{	
	private MethodAccess method;
	private T bean;	
	
	/**
	 * Cuando se desconoce el tipo
	 * @param type
	 */
	@SuppressWarnings("unchecked")
	public ClassMap(Class<?> type)
	{	
		bean = (T)ConstructorAccess.get(type).newInstance();
		method = MethodAccess.get(type);		
	}
	public ClassMap(T value)
	{
		bean = value;
		method = MethodAccess.get(value.getClass());	
	}
	@Override
	public void set(String key, Literal<?> literal) 
	{			
		method.invoke(bean, String.format("set%s",Utils.capitalize(key)),literal.getValue());		
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
	
	@Override
	public T getValue() {
		return bean;
	}
	

}
