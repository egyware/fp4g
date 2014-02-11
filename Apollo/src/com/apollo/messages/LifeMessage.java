package com.apollo.messages;

import com.apollo.Message;

public enum LifeMessage implements Message 
{
	onDamageLife, onHealLife;

	@Override
	public Class<?> getClassHandler() 
	{
		return LifeMessageHandler.class;
	}
}
