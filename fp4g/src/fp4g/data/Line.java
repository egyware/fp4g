package fp4g.data;

public class Line implements ILine
{
	private int line;

	@Override
	public final void setLine(int line) 
	{
		this.line = line;		
	}

	@Override
	public final int getLine()
	{
		return line;
	}
}
