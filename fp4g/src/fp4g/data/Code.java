package fp4g.data;

public class Code {
	private int line = -1; //cuando es menos 1 no se ha especificado la linea
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
