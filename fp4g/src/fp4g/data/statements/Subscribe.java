package fp4g.data.statements;

import fp4g.classes.MessageMethod;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.Instance;
import fp4g.data.define.Message;


public class Subscribe extends Code
{
	//SUBSCRIBE EntityManager ON Entity:added;
	public final Instance where;
	public final Define instance;
	public final Message message;
	public final MessageMethod method;
	
	public Subscribe(Instance where,Define instance, Message message, MessageMethod method)
	{
		this.where = where;
		this.instance = instance;
		this.message = message;
		this.method = method;		
	}
}
