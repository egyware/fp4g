package com.apollo;


public interface IMessageSender extends MessageHandler
{
	public void    addMessageHandler(MessageType messageType, MessageHandler listener); 
	public void removeMessageHandler(MessageType messageType, MessageHandler listener);	
}
