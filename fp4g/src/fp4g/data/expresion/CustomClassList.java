package fp4g.data.expresion;

import java.util.Iterator;

import com.esotericsoftware.reflectasm.ConstructorAccess;

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
	public Iterator<Literal<?>> iterator() 
	{
		return bean.iterator();
	}

	@Override
	public void add(Literal<?> item) 
	{
		bean.add(item);
	}

	@Override
	public Literal<?> get(int index)
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

}
