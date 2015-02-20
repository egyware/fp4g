package com.apollo.messages;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum LifeMessage implements IMessage<LifeMessageHandler> 
{
	onDamage, 
	onHeal;

	@Override
	public void dispatch(IMessageReceiver h, Object... args) 
	{
		final LifeMessageHandler handler = (LifeMessageHandler)h;
		switch(this)
		{
		case onDamage:
			handler.onDamage(((Number)args[0]).intValue());
			break;
		case onHeal:
			handler.onHeal(((Number)args[0]).intValue());
			break;	
		}		
	}
}
