package com.apollo.actions;

import com.apollo.Action;
import com.apollo.IMessage;

public class SendMessageAction extends Action
{
	private IMessage<?> message;
	private Object[] args;
	
	public void setArgs(Object ...args)
	{
		this.args = args;
	}
	public void setMessage(IMessage<?> message)
	{
		this.message = message;
	}	
	public void setMessage(IMessage<?> message, Object ...args)
	{
		this.message = message;
		this.args = args;
	}
	
	@Override
	public boolean act(float delta)
	{
		entity.onMessage(message, args);
		return true;
	}
}
