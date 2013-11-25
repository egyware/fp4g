package com.apollo;

import com.apollo.utils.ImmutableBag;

public interface MessageReceiver{
	
	public ImmutableBag<MessageHandler> getMessageHandler(Message message);
	
}
