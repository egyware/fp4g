package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;

public class EntityAddedMessage extends Message 
{
	public Entity entity;
	

	@Override
	public Class<? extends Message> getType() 
	{
		return EntityAddedMessage.class;
	}
}
