package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.MessageReciever;

public enum EntityMessage implements Message<EntityMessageHandler> 
{
	onAddedEntity,
	onRemovedEntity,	
	;

	@Override
	public void dispatch(MessageReciever h, Object... args)
	{
		final EntityMessageHandler handler = (EntityMessageHandler)h;
		switch(this)
		{		
		case onAddedEntity:
			handler.onAddedEntity((Entity)args[0]);
			break;
		case onRemovedEntity:
			handler.onRemovedEntity((Entity)args[0]);
			break;	
		}		
	}

	@Override
	public Class<EntityMessageHandler> getClassHandler() 
	{
		return EntityMessageHandler.class;		
	}

}
