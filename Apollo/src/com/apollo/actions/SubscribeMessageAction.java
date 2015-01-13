package com.apollo.actions;

import com.apollo.Action;
import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public class SubscribeMessageAction extends Action
{
	private IMessage<?> message;
	private IMessageReceiver handler;
	
	public void setMessageHandler(IMessageReceiver handler)
	{
		this.handler = handler;
	}
	
	public void setMessage(IMessage<?> message)
	{
		this.message = message; 
	}
	
	public void restart()
	{
		message = null;
		handler = null;
	}
	
	@Override
	public boolean act(float delta) 
	{
		entity.addMessageHandler(message, handler);
		return true;
	}
	
}
