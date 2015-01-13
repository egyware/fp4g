package com.apollo;

public interface IMessageReceiver
{
	public void onMessage(IMessage<? extends IMessageReceiver> message, Object... args);
}
