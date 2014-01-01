package fp4g.data.statements;

import fp4g.classes.MessageMethod;
import fp4g.data.Code;
import fp4g.data.ExprList;

public class Send extends Code 
{
	public static enum SendTo
	{
		Self,Other,Behavior,System
	}
	//Send que se caracteriza por tener
	//Mensaje a enviar (methodo de message y el mensaje)
	public final MessageMethod method;
	public final SendTo toReceiverType;
	public final String toReceiverName;
	//A quien enviarle el mensaje		
	public ExprList args;
	
	public Send(SendTo type,MessageMethod mm, String receiver)
	{
		this.method = mm;
		toReceiverType = type;
		toReceiverName = receiver;
	}
	
	public void setArguments(ExprList list)
	{
		args = list;
	}

}
