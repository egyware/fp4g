package com.apollo.actions;
import com.apollo.Action;
import com.apollo.Message;
import com.apollo.MessageHandler;

public class OnMessageAction extends Action implements MessageHandler
{
	private Message<?> message;
	private boolean received;
	
	public void restart()
	{
		received = false;
		message = null;
	}
	
	public void setReceived(boolean received)
	{
		this.received = received;
	}
	
	public void setMessage(Message<?> message)
	{
		this.message = message;		
	}
	
	@Override
	public void begin()
	{
		entity.addEventHandler(message, this);
	}
	
	@Override
	public void end()
	{
		entity.removeEventHandler(message, this);
	}
	
	@Override
	public boolean act(float delta) 
	{
		return received;
	}

	@Override
	public void onMessage(Message<? extends MessageHandler> message, Object... args) 
	{
		message.dispatch(this, args);
	}

}
