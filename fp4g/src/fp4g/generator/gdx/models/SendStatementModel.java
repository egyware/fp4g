package fp4g.generator.gdx.models;

import java.util.LinkedList;
import java.util.List;

public final class SendStatementModel extends StatementModel 
{	
	private final String message;
	private final String to;
	private final boolean direct;
	private List<String> params;
	
	public SendStatementModel(String message, String to)
	{
		this(message, to, false);
	}
	
	public SendStatementModel(String message, String to, boolean direct) 
	{
		super(StatementModel.Type.SendStatement);
		this.message = message;
		this.to = to;
		this.direct = direct;		
	}
	
	public String getMessage()
	{
		return message;
	}
	public String getTo()
	{
		return to;
	}
	public List<String> getParams()
	{
		if(params == null)
		{
			params = new LinkedList<String>();
		}				
		return params;
	}

	public boolean isDirect() {
		return direct;
	}	

}
