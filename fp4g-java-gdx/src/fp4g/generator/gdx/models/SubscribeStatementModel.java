package fp4g.generator.gdx.models;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.Statement;
import fp4g.data.statements.Subscribe;
import fp4g.data.statements.Unsubscribe;
import fp4g.generator.StatementModel;


public final class SubscribeStatementModel extends StatementModel 
{		
	private final String subscribeTo;
	private final String message;
	private final List<String> method;
	private final String attach;
	
	public SubscribeStatementModel(Subscribe subscribe,boolean b) 
	{
		super(Statement.Type.Subscribe);
		attach = b?"entity":"this";		
		subscribeTo = subscribe.instance.name;
		message = subscribe.message.name;
		method = new LinkedList<String>();
		if(subscribe.method == null)
		{	
			//TODO nadaa? en serio? Sii quiero dormir -.-'
			//06-05-2014 WTF!??? que traté de hacer acá, y porque chucha estaba cagao de sueño xD
		}
		else
		{
			method.add(subscribe.method.name);
		}
	}
	
	public SubscribeStatementModel(Unsubscribe subscribe,boolean b) 
	{
		super(Statement.Type.Unsubscribe);
		attach = b?"entity":"this";		
		subscribeTo = subscribe.instance.name;
		message = subscribe.message.name;
		method = new LinkedList<String>();
		if(subscribe.method == null)
		{	
			//TODO nadaa? en serio? Sii quiero dormir -.-'
		}
		else
		{
			method.add(subscribe.method.name);
		}
	}

	public final String getSubscribeTo() {
		return subscribeTo;
	}

	public final String getMessage() {
		return message;
	}

	public final List<String> getMethod() {
		return method;
	}

	public final String getAttach() {
		return attach;
	}
}
