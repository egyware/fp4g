package fp4g.data;

public class Code {
	private int line;
	private boolean build = true;
	
	public void setLine(int line)
	{	
		this.line = line;
	}
	public int getLine()
	{
		return line;
	}
	public void setBuild(boolean b)
	{
		build = b;
	}
	public boolean canBuild()
	{
		return build;
	}
}
