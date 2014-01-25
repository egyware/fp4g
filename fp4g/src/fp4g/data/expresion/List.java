package fp4g.data.expresion;

import fp4g.data.IValue;

public interface List extends Iterable<IValue<?>> 
{	
	public void add(IValue<?> item);
	public IValue<?> get(int index);
	public int size();	
}
