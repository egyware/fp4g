package fp4g.log.info;

import fp4g.log.WarnType;

public enum NotAllowed implements WarnType 
{
	NotExpectedGame,
	NotExpectedDefine,
	NotExpectedOn, 
	NotExpectedAdd,
	NotImplementedYet,;
	
	private final String message;
	private NotAllowed()
	{
		message = this.name();
	}
	private NotAllowed(String msg)		
	{		
		message = msg;
	}	
	
	@Override
	public String getMessage()
	{	
		return message;
	}
}
