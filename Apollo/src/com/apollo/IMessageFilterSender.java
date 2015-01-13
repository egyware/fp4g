package com.apollo;

public interface IMessageFilterSender extends IMessageFilterReceiver
{
	public <T extends IMessage<?>> void    addMessageFilter(IMessageFilter<?> messageType, IMessageFilterReceiver listener); 
	public <T extends IMessage<?>> void removeMessageFilter(IMessageFilter<?> messagetType, IMessageFilterReceiver listener);	
}
