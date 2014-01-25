package fp4g.data.expresion;

import java.util.Iterator;

import fp4g.data.IValue;
import fp4g.exceptions.NotAllowedOperatorException;


public final class ArrayList extends Literal<List> implements List
{
	private final java.util.List<IValue<?>> list;
	
	public ArrayList(IValue<?> lits[])
	{		
		list = new java.util.ArrayList<IValue<?>>(lits.length);		
		for(IValue<?> lit:lits)
		{
			list.add(lit);
		}
	}
	
	public ArrayList()
	{
		list = new java.util.ArrayList<IValue<?>>();
	}
	
	@Override
	public List getValue() {
		return this;
	}

	@Override
	public Iterator<IValue<?>> iterator() 
	{
		return list.iterator();
	}

	@Override
	public void add(IValue<?> item) 
	{
		list.add(item);		
	}

	@Override
	public IValue<?> get(int index) 
	{
		return list.get(index);
	}

	@Override
	public int size() 
	{		
		return list.size();
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
