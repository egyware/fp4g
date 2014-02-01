package fp4g.data.statements;

import fp4g.classes.MessageMethod;
import fp4g.data.Code;
import fp4g.data.ExprList;
import fp4g.data.define.Manager;

public class Send extends Code 
{
	public static enum SendTo
	{
		Self,Other,Behavior,System,Game
	}
	//Send que se caracteriza por tener
	//Mensaje a enviar (methodo de message y el mensaje)
	public final MessageMethod method;
	public final SendTo toReceiverType;
	public final String toReceiverName;
	public final Manager toReceiverSystem; //si es que hay
	//A quien enviarle el mensaje		
	public ExprList args;
	
	public Send(SendTo type,MessageMethod mm, String receiver)
	{
		method = mm;
		toReceiverType = type;
		toReceiverName = receiver;
		toReceiverSystem = null;
	}
	
	public Send(SendTo type,MessageMethod mm, Manager manager)
	{
		this.method = mm;
		toReceiverType = type;
		toReceiverName = manager.name;
		toReceiverSystem = manager;
	}
	
	public void setArguments(ExprList list)
	{
		args = list;
	}

}
