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
	private final boolean direct;
	private List<String> params;
	public SendStatementModel(Send send) {
		super(StatementModel.Type.SendStatement);
		
		Message msg = send.method.getMessage();
		
		switch(send.toReceiverType)
		{
		case Other:
			to = "other";
			message = String.format("%1$sMessage.on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
			direct = false;
			break;
		case Behavior:
			//TODO acá deberia haber un sistema que detecte todas las variables accedibles, para transformar el this a entity en caso que estemos en EntityBuilder
			to = "this.".concat(Utils.decapitalize(send.toReceiverName));
			message = String.format("on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
			direct = true;
			break;
		case System:
			//TODO falta importar dependencia			
			to = "this.getWorld().getManager(".concat(send.toReceiverName).concat(".class)");
			message = String.format("on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
			direct = true;
			break;
		case Self:
		default:
			to = "this";
			message = String.format("%1$sMessage.on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
			direct = false;
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

	public boolean isDirect() {
		return direct;
	}	

}
