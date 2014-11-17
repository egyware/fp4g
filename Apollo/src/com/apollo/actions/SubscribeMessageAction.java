package com.apollo.actions;

import com.apollo.Action;
import com.apollo.Message;
import com.apollo.MessageReciever;

public class SubscribeMessageAction extends Action
{
	private Message<?> message;
	private MessageReciever handler;
	
	public void setMessageHandler(MessageReciever handler)
	{
		this.handler = handler;
	}
	
	public void setMessage(Message<?> message)
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
		entity.addEventHandler(message, handler);
		return true;
	}
	
}
