package com.apollo;


public interface IMessageSender extends IMessageReceiver
{
	public <T extends IMessage<?>> void    addMessageHandler(IMessage<?> messageType, IMessageReceiver listener); 
	public <T extends IMessage<?>> void removeMessageHandler(IMessage<?> messagetType, IMessageReceiver listener);	
}
