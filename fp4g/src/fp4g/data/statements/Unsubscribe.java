package fp4g.data.statements;

import fp4g.data.AddMethod;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.Instance;
import fp4g.data.define.Message;


public class Unsubscribe extends Code
{
	//SUBSCRIBE EntityManager ON Entity:added;
	public final Instance where;
	public final Define instance;
	public final Message message;
	public final AddMethod method;
	
	public Unsubscribe(Instance where,Define instance, Message message, AddMethod method)
	{
		this.where = where;
		this.instance = instance;
		this.message = message;
		this.method = method;		
	}	
}
