package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum EntityMessage implements IMessage<EntityMessageHandler> 
{
	onAddedEntity,
	onRemovedEntity,	
	;

	@Override
	public void dispatch(IMessageReceiver h, Object... args)
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
