package fp4g.data.expresion;

import org.antlr.v4.misc.Utils;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

import fp4g.data.expresion.literals.BoolLiteral;
import fp4g.data.expresion.literals.FloatLiteral;
import fp4g.data.expresion.literals.IntegerLiteral;
import fp4g.data.expresion.literals.ObjectLiteral;
import fp4g.data.expresion.literals.StringLiteral;
import fp4g.exceptions.NotAllowedOperatorException;

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
	public Literal<?> sum(Literal<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Add);		
	}

	@Override
	public Literal<?> mult(Literal<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Mult);
	}

	@Override
	public Literal<?> div(Literal<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Div);
	}

	@Override
	public Literal<?> sub(Literal<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Sub);
	}


}
