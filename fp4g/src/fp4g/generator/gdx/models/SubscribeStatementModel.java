package fp4g.generator.gdx.models;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.statements.Subscribe;
import fp4g.data.statements.Unsubscribe;


public final class SubscribeStatementModel extends StatementModel 
{		
	private final String subscribeTo;
	private final String message;
	private final List<String> method; 
	private final boolean isSubscribe;
	
	public SubscribeStatementModel(Subscribe subscribe) 
	{
		super(StatementModel.Type.SubscribeStatement);
		isSubscribe = true;
		subscribeTo = subscribe.instance;
		message = subscribe.message.name;
		method = new LinkedList<String>();
		if(subscribe.method == null)
		{	
			//TODO nadaa? en serio? Sii quiero dormir -.-'
		}
		else
		{
			method.add(subscribe.method.getName());
		}
	}
	
	public SubscribeStatementModel(Unsubscribe subscribe) 
	{
		super(StatementModel.Type.SubscribeStatement);
		isSubscribe = false;
		subscribeTo = subscribe.instance;
		message = subscribe.message.name;
		method = new LinkedList<String>();
		if(subscribe.method == null)
		{	
			//TODO nadaa? en serio? Sii quiero dormir -.-'
		}
		else
		{
			method.add(subscribe.method.getName());
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

	public final boolean isSubscribe() {
		return isSubscribe;
	}
}
