package fp4g.data.expresion;

import java.util.Iterator;

import com.esotericsoftware.reflectasm.ConstructorAccess;

import fp4g.data.IValue;
import fp4g.exceptions.NotAllowedOperatorException;

public class CustomClassList extends Literal<List> implements List 
{
	private List bean;
	public CustomClassList(Class<? extends List> type)
	{
		bean = ConstructorAccess.get(type).newInstance();		
	}
	public CustomClassList(List value)
	{
		bean = value;		
	}

	@Override
	public Iterator<IValue<?>> iterator() 
	{
		return bean.iterator();
	}

	@Override
	public void add(IValue<?> item) 
	{
		bean.add(item);
	}

	@Override
	public IValue<?> get(int index)
	{
		return bean.get(index);
	}

	@Override
	public int size() 
	{
		return bean.size();
	}

	@Override
	public List getValue() 
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
