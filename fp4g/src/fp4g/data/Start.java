package fp4g.data;

public class Start extends Value{
	private String start;
	private Start(String _start){
		super(String.format("Start %s", _start));
		start = _start;
		
	}
	public String getStartName()
	{
		return start;
	}
	public static Start Set(Define define)
	{
		if(define.getType() == Type.STATE)
		{
			return new Start(define.getName());
		}
		else
		{
			return null;
		}
	}
	public static Start Set(Add add)
	{
		if(add.getType() == Type.STATE)
		{
			return new Start(add.getName());
		}
		else
		{
			return null;
		}
	}

}
