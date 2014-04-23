package fp4g.data.expresion;

import java.util.Iterator;

import com.esotericsoftware.reflectasm.ConstructorAccess;

import fp4g.data.IValue;

public class CustomClassList extends Literal<IList> implements IList 
{
	private IList bean;
	public CustomClassList(Class<? extends IList> type)
	{
		bean = ConstructorAccess.get(type).newInstance();		
	}
	public CustomClassList(IList value)
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
	public IList getValue() 
	{	
		return bean;
	}
}
