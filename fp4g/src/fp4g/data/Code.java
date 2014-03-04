package fp4g.data;

public class Code implements ICode {
	private int line = -1; //cuando es menos 1 no se ha especificado la linea
	private boolean build = true;
	private boolean using = false;
	
	/* (non-Javadoc)
	 * @see fp4g.data.ICode#setLine(int)
	 */
	@Override
	public void setLine(int line)
	{	
		this.line = line;
	}
	/* (non-Javadoc)
	 * @see fp4g.data.ICode#getLine()
	 */
	@Override
	public int getLine()
	{
		return line;
	}
	/* (non-Javadoc)
	 * @see fp4g.data.ICode#setBuild(boolean)
	 */
	@Override
	public void setGenerable(boolean b)
	{
		build = b;
	}
	/* (non-Javadoc)
	 * @see fp4g.data.ICode#canBuild()
	 */
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
