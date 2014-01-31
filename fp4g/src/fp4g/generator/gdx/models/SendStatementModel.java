package fp4g.generator.gdx.models;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.misc.Utils;

import fp4g.data.define.Message;
import fp4g.data.statements.Send;

public final class SendStatementModel extends StatementModel 
{	
	private final String message;
	private final String to;
	private List<String> params;
	public SendStatementModel(Send send) {
		super(StatementModel.Type.SendStatement);
		
		Message msg = send.method.getMessage();
		
		message = String.format("%1$sMessage.on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
		switch(send.toReceiverType)
		{
		case Other:
			to = "other";
			break;
		case Behavior:
			//TODO chequear cuando es init/deinit
			to = "this.".concat(send.toReceiverName);
			break;
		case System:
			//TODO falta importar dependencia
			to = "owner.getWorld().getManager(".concat(send.toReceiverName).concat(".class)");			
			break;
		case Self:
		default:
			to = "this";			
			break;
		}		
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

}
