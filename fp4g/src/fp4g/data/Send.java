package fp4g.data;

import fp4g.classes.MessageMethod;

public class Send extends Code 
{
	public static enum SendTo
	{
		Self,Other,System
	}
	//Send que se caracteriza por tener
	//Mensaje a enviar (methodo de message y el mensaje)
	public final MessageMethod method;
	public final SendTo toReceiverType;
	public String toReceiverName;
	//A quien enviarle el mensaje		
	public ExprList args;
	
	public Send(SendTo type,MessageMethod mm)
	{
		this.method = mm;
		toReceiverType = type;
	}
	
	public void setArguments(ExprList list)
	{
		args = list;
	}
	
	public void setTo(String receiverName)
	{
		toReceiverName = receiverName;
	}
}
