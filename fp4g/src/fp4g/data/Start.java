package fp4g.data;

public class Start extends Value{
	private Define start;
	private Start(Define _start){
		super(String.format("Start %s", _start.name));
		start = _start;
		
	}
	public Define getStart()
	{
		return start;
	}
	public static Start Set(Define define)
	{
		if(define.getType() == Type.STATE)
		{
			return new Start(define);
		}
		else
		{
			return null;
		}
	}

}
