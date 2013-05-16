package com.apollo.messages;

import com.apollo.Message;
import com.apollo.utils.Bag;

public final class BagSignal implements MessageSender {
	private final Bag<MessageReceiver> receivers;
	public BagSignal()
	{
		receivers = new Bag<MessageReceiver>();
	}
	/* (non-Javadoc)
	 * @see com.apollo.ISignal#send(T)
	 */
	@Override
	public void send(Message message)
	{		
		for(MessageReceiver slot: receivers)
		{
			slot.onMessage(message);
		}	
	}
	/* (non-Javadoc)
	 * @see com.apollo.ISignal#subscribe(com.apollo.Slot)
	 */
	@Override
	public void addMessageReceiver(MessageReceiver slot)
	{
		receivers.add(slot);		
	}
	/* (non-Javadoc)
	 * @see com.apollo.ISignal#unsubscribe(com.apollo.Slot)
	 */
	@Override
	public void removeMessangeReceiver(MessageReceiver slot)
	{
		receivers.remove(slot);
	}
}
