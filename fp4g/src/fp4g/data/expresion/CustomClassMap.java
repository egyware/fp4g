package fp4g.data.expresion;

import com.esotericsoftware.reflectasm.ConstructorAccess;

import fp4g.data.IValue;
import fp4g.exceptions.NotAllowedOperatorException;

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
	public void set(String key, IValue<?> literal) 
	{
		bean.set(key, literal);
	}
	@Override
	public IValue<?> get(String key) 
	{
		return bean.get(key);		
	}
	
	@Override
	public Map getValue() 
	{
		return bean;
	}
	
	@Override
	public IValue<?> sum(IValue<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Add);		
	}

	@Override
	public IValue<?> mult(IValue<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Mult);
	}

	@Override
	public IValue<?> div(IValue<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Div);
	}

	@Override
	public IValue<?> sub(IValue<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Sub);
	}
	
}
