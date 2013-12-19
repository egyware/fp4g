package fp4g.data.expresion;

public interface List extends Iterable<Literal<?>> 
{	
	public void add(Literal<?> item);
	public Literal<?> get(int index);
	public int size();	
}
