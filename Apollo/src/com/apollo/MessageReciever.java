package com.apollo;

public interface MessageReciever
{
	public void onMessage(Message<? extends MessageReciever> message, Object... args);
}
