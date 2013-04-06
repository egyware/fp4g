/**
 * 
 */
package fp4g.data;

/**
 * @author egyware
 *
 */
public class Value {
	protected String name;
	private int line;
	private int ordinal;
	public Value(String _name)
	{
		this(_name,-1);		
	}
	public Value(String _name,int _ordinal)
	{
		name = _name;
		ordinal = _ordinal;
		
	}
	public final void setLine(int l){
		line = l;
	}
	public final int getLine()
	{
		return line;
	}
	
	public final int getOrdinal()
	{
		return ordinal;
	}
	
	public final String getName()
	{
		return name;
	}
	
}
