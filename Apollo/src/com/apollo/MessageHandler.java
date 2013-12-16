package com.apollo;

public interface MessageHandler
{
	public void onMessage(Message<? extends MessageHandler> message,Object ...args);
}
