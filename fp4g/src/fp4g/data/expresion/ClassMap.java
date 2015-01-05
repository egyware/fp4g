package fp4g.data.expresion;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.antlr.v4.misc.Utils;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

import fp4g.core.IValue;
import fp4g.data.expresion.literals.BoolLiteral;
import fp4g.data.expresion.literals.FloatLiteral;
import fp4g.data.expresion.literals.IntegerLiteral;
import fp4g.data.expresion.literals.ObjectLiteral;
import fp4g.data.expresion.literals.StringLiteral;

public final class ClassMap<T> extends Literal<T> implements IMap
{	
	public String toString()
	{
		return String.format("ClassMap<%s> (%s)",bean.getClass().getSimpleName(),bean);
	}
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
	public void set(String key, IValue<?> literal) 
	{			
		method.invoke(bean, String.format("set%s",Utils.capitalize(key)),literal.getValue());		
	}
	
	@Override
	public IValue<?> get(String key) 
	{
		final String methods[] = method.getMethodNames();
		key = Utils.capitalize(key);
		int indexMethod;
		for(indexMethod = 0 ;indexMethod<methods.length;indexMethod++)
		{
			if(methods[indexMethod].endsWith(key) && (methods[indexMethod].startsWith("get")||methods[indexMethod].startsWith("is")))
			{
				Object ret = method.invoke(bean,indexMethod);
				if(ret instanceof Float)
				{
					return new FloatLiteral((Float)ret);
				}
				else
				if(ret instanceof Integer)
				{
					return new IntegerLiteral((Integer)ret);
				}
				else
				if(ret instanceof Boolean)
				{
					return new BoolLiteral((Boolean)ret);
				}
				else
				if(ret instanceof String)
				{
					return new StringLiteral((String)ret);
				}
				else
				{
					return new ObjectLiteral(ret);
				}
			}
		}
		throw new IllegalArgumentException(String.format("Unable to find public method: set/is%s", key));				
	}	
	
	@Override
	public T getValue() {
		return bean;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Set<Entry<String, IValue<?>>> entrySet() 
	{
		Set<Entry<String, IValue<?>>> set = new TreeSet<Entry<String, IValue<?>>>();
		final String methods[] = method.getMethodNames();
		for(int i = 0; i < methods.length; i++)
		{
			if(methods[i].startsWith("is"))				
			{
				final String key = Utils.decapitalize(methods[i].substring(2));
				IValue<?> value = get(key);
				set.add(new IMap.MapEntry<String,IValue<?>>(key,value));
			}
			else
			if(methods[i].startsWith("get"))
			{				
				final String key = Utils.decapitalize(methods[i].substring(3));
				IValue<?> value = get(key);
				set.add(new IMap.MapEntry<String,IValue<?>>(key,value));
			}
		}
		
		return set;
	}
}
