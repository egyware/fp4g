package fp4g;

import java.util.HashMap;

import org.antlr.v4.misc.Utils;

import com.esotericsoftware.reflectasm.MethodAccess;

public final class BeanAccess
{
	private final MethodAccess method;
	
	private BeanAccess(Class<?> clazz)
	{
		method = MethodAccess.get(clazz);	
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
			//TODO ERROR ignorado
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
				return method.invoke(this,indexMethod);
			}
		}
		return null; //TODO falta error aqui
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

}
