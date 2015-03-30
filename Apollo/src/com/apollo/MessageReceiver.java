package com.apollo;

public interface MessageReceiver
{
	public void onMessage(Object sender, Message message);
}