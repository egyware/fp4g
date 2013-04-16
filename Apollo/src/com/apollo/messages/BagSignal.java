package com.apollo.messages;

import com.apollo.Message;
import com.apollo.utils.Bag;

public final class BagSignal implements Signal {
	private final Bag<Slot> receivers;
	public BagSignal()
	{
		receivers = new Bag<Slot>();
	}
	/* (non-Javadoc)
	 * @see com.apollo.ISignal#send(T)
	 */
	@Override
	public void send(Message message)
	{		
		for(Slot slot: receivers)
		{
			slot.onMessage(message);
		}	
	}
	/* (non-Javadoc)
	 * @see com.apollo.ISignal#subscribe(com.apollo.Slot)
	 */
	@Override
	public void subscribe(Slot slot)
	{
		receivers.add(slot);		
	}
	/* (non-Javadoc)
	 * @see com.apollo.ISignal#unsubscribe(com.apollo.Slot)
	 */
	@Override
	public void unsubscribe(Slot slot)
	{
		receivers.remove(slot);
	}
}
