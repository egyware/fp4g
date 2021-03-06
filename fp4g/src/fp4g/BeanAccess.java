package fp4g;

import java.util.HashMap;
import java.util.LinkedList;

import org.antlr.v4.misc.Utils;

import com.esotericsoftware.reflectasm.MethodAccess;

import fp4g.exceptions.CannotEvalException;

public final class BeanAccess
{
	private final MethodAccess method;
	private final String properties[];
	
	private BeanAccess(Class<?> clazz)
	{
		method = MethodAccess.get(clazz);
		LinkedList<String> _p = new LinkedList<String>();
		final String methods[] = method.getMethodNames();		
		for(int indexMethod = 0; indexMethod < methods.length;indexMethod++)
		{
			final String nameMethod = methods[indexMethod];
			final int len = nameMethod.length();
			if(methods[indexMethod].startsWith("get") && len > 3)					
			{
				_p.add(Utils.decapitalize(methods[indexMethod].substring(3)));			
			}
			else if(nameMethod.startsWith("is") && len > 2)
			{
				_p.add(Utils.decapitalize(methods[indexMethod].substring(2)));
			}
		}
		properties = new String[_p.size()];
		_p.toArray(properties);
	}
	
	public void set(final Object thiz,final String key,final Object value)
	{
		try
		{		
			method.invoke(thiz, String.format("set%s",Utils.capitalize(key)), value);
			return;
		}		
		catch(IllegalArgumentException e)
		{
			throw new CannotEvalException(CannotEvalException.Types.CannotSetProperty,thiz, key,value,e);
		}
	}
	
	public Object get(final Object thiz, final String key)
	{
		final String methods[] = method.getMethodNames();
		String keyMethod = Utils.capitalize(key);
		int indexMethod;
		for(indexMethod = 0; indexMethod < methods.length;indexMethod++)
		{
			final String nameMethod = methods[indexMethod];
			final int lenMethod = nameMethod.length();
			
			if(nameMethod.endsWith(keyMethod) && ((methods[indexMethod].startsWith("get") && (keyMethod.length() + 3 == lenMethod))||(nameMethod.startsWith("is") && (keyMethod.length() + 2 == lenMethod))))
			{
				return method.invoke(thiz,indexMethod);
			}
		}
		return null;
		//regresa null si no existe, no se da ning�n warning ni error critico ya que esto es un comportamiento deseable y no deseo cambiar todo para que quede "elegante la wea"
		//throw new CannotEvalException(CannotEvalException.Types.CannotGetProperty,thiz, key);
	}
	
	public String[] getProperties()
	{
		return properties;
	}
	
	
	private static HashMap<Class<?>,BeanAccess> map = new HashMap<Class<?>,BeanAccess>();
	public static BeanAccess getBeanAccess(Class<?> key)
	{
		BeanAccess ba = map.get(key);
		if(ba == null)
		{
			ba = new BeanAccess(key);
			map.put(key, ba);
		}
		return ba;
	}
	public static BeanAccess getBeanAccess(Object object)
	{
		return getBeanAccess(object.getClass());
	}
	public static void setValue(Object thizz, String key, Object value)
	{
		getBeanAccess(thizz).set(thizz, key, value);
	}

}
