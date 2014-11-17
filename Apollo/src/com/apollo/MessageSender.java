package com.apollo;


public interface MessageSender extends MessageReciever
{
	public <T extends Message<?>> void addEventHandler(Message<?> messageType, MessageReciever listener); 
	public <T extends Message<?>> void removeEventHandler(Message<?> messagetType, MessageReciever listener);	
}
