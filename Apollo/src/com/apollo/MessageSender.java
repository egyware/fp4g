package com.apollo;


public interface MessageSender extends MessageReceiver
{
	public void    addMessageHandler(Class<? extends Message> type, MessageReceiver handler); 
	public void removeMessageHandler(Class<? extends Message> type, MessageReceiver handler);	
}
