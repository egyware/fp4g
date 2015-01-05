package fp4g.data.expresion;

import fp4g.core.IValue;

public interface IList extends Iterable<IValue<?>> 
{	
	public void add(IValue<?> item);
	public IValue<?> get(int index);
	public int size();	
}
