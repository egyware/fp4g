package fp4g.data;

public class Code implements ICode {
	private int line = -1; //cuando es menos 1 no se ha especificado la linea
	private boolean build = true;
	private boolean using = false;
	
	@Override
	public void setLine(int line)
	{	
		this.line = line;
	}
	
	@Override
	public int getLine()
	{
		return line;
	}
	
	@Override
	public void setGenerable(boolean b)
	{
		build = b;
	}
	
	@Override
	public boolean isGenerable()
	{
		return build;
	}
	@Override
	public void setUsable(boolean b) 
	{
		using = b;
		
	}
	@Override
	public boolean isUsable() 
	{
		return using;
	}
}
