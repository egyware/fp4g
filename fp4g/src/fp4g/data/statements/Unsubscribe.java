package fp4g.data.statements;

import fp4g.data.Define;
import fp4g.data.Instance;
import fp4g.data.Statement;
import fp4g.data.add.AddMethod;
import fp4g.data.define.Message;


public class Unsubscribe extends Statement
{
	//SUBSCRIBE EntityManager ON Entity:added;
	public final Instance where;
	public final Define instance;
	public final Message message;
	public final AddMethod method;
	
	public Unsubscribe(Instance where,Define instance, Message message, AddMethod method)
	{
		super(Statement.Type.Unsubscribe);
		this.where = where;
		this.instance = instance;
		this.message = message;
		this.method = method;		
	}	
}
