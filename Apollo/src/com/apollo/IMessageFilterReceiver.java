package com.apollo;

public interface IMessageFilterReceiver
{
	public boolean onMessage(IMessageFilter<? extends IMessageFilterReceiver> message, Object... args);
}
