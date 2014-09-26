package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum LifeMessage implements Message<LifeMessageHandler> 
{
	onDamageLife, 
	onHealLife,
	onDeathLife;

	@Override
	public Class<LifeMessageHandler> getClassHandler() 
	{
		return LifeMessageHandler.class;
	}

	@Override
	public void dispatch(MessageHandler h, Object... args) {
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
