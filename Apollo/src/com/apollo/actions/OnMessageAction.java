package com.apollo.actions;
import com.apollo.Action;
import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public class OnMessageAction extends Action implements IMessageReceiver
{
	private IMessage<?> message;
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
	
	public void setMessage(IMessage<?> message)
	{
		this.message = message;		
	}
	
	@Override
	public void begin()
	{
		entity.addMessageHandler(message, this);
	}
	
	@Override
	public void end()
	{
		entity.removeMessageHandler(message, this);
	}
	
	@Override
	public boolean act(float delta) 
	{
		return received;
	}

	@Override
	public void onMessage(IMessage<? extends IMessageReceiver> message, Object... args) 
	{
		message.dispatch(this, args);
	}

}
