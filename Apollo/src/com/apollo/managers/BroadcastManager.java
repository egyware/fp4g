package com.apollo.managers;

import java.util.HashMap;
import java.util.Map;

import com.apollo.Message;
import com.apollo.MessageHandler;
import com.apollo.MessageReceiver;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

/**
 * @author Edgardo
 *
 */
public class BroadcastManager extends Manager implements MessageReceiver
{
	private final Map<Message<?>,Bag<MessageHandler>> handlersByEventType;
	public BroadcastManager()
	{
		handlersByEventType = new HashMap<Message<?>,Bag<MessageHandler>>();
	}
	@Override
	public ImmutableBag<MessageHandler> getMessageHandler(Message<?> message) 
	{
		return handlersByEventType.get(message); 
	}
	
	/**
	 * 
	 * @param messageType Class of Message Type
	 * @param listener
	 */	
	public <T extends Message<?>> void addEventHandler(Message<?> messageType, MessageHandler listener) 
	{
		Bag<MessageHandler> listeners = handlersByEventType.get(messageType);
		if(listeners == null) {
			listeners = new Bag<MessageHandler>();
			handlersByEventType.put(messageType,listeners);
		}
		listeners.add(listener);
	}
	
	public <T extends Message<?>> void removeEventHandler(Message<?> messageType, MessageHandler listener) 
	{
		final Bag<MessageHandler> listeners = handlersByEventType.get(messageType);
		if(listeners == null) 
		{
			return;
		}
		listeners.remove(listener);
	}

	@Override
	public void onMessage(Message<? extends MessageHandler> message, Object... args) 
	{
		ImmutableBag<MessageHandler> listeners = getMessageHandler(message);
		if(listeners != null)
		{
			final int size = listeners.size();
			for(int i=0; i<size; i++)
			{
				MessageHandler handler = listeners.get(i);
				handler.onMessage(message,args);			
			}
		}
	}
	
	
}
