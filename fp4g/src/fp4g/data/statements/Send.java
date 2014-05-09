package fp4g.data.statements;

import fp4g.data.ExprList;
import fp4g.data.Instance;
import fp4g.data.Statement;
import fp4g.data.add.AddMethod;
import fp4g.data.define.Manager;

public class Send extends Statement
{
	//Send que se caracteriza por tener
	//Mensaje a enviar (methodo de message y el mensaje)
	public final AddMethod method;
	public final Instance toReceiverType;
	public final String toReceiverName;
	public final Manager toReceiverSystem; //si es que hay a quien enviarle el mensaje		
	public ExprList args;
	
	public Send(Instance type,AddMethod mm, String receiver)
	{
		super(Statement.Type.Send);
		method = mm;
		toReceiverType = type;
		toReceiverName = receiver;
		toReceiverSystem = null;
	}
	
	public Send(Instance type,AddMethod mm, Manager manager)
	{
		super(Statement.Type.Send);
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
