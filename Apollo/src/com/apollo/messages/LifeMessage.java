package com.apollo.messages;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum LifeMessage implements IMessage<LifeMessageHandler> 
{
	onDamageLife, 
	onHealLife,
	onDeathLife;

	@Override
	public void dispatch(IMessageReceiver h, Object... args) 
	{
		final LifeMessageHandler handler = (LifeMessageHandler)h;
		switch(this)
		{
		case onDamageLife:
			handler.onDamageLife(((Number)args[0]).intValue());
			break;
		case onHealLife:
			handler.onHealLife(((Number)args[0]).intValue());
			break;
		case onDeathLife:
			handler.onDeathLife();
			break;
		}		
	}
}
