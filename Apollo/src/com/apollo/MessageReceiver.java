package com.apollo;

import com.apollo.utils.ImmutableBag;

public interface MessageReceiver extends MessageHandler
{
	public ImmutableBag<MessageHandler> getMessageHandler(Message<?> message);	
}
