package fp4g.debug.data;

public final class DebugMessage
{
	public Instruction instruction;
	public Object[] args;
	
	public DebugMessage()
	{		
	}
	public DebugMessage(Instruction i, Object ...args)
	{
		instruction = i;
		this.args = args;
	}
}
