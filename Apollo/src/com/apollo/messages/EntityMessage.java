package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.MessageHandler;

public enum EntityMessage implements Message<EntityMessageHandler> 
{
	onInitEntity,
	onDeinitEntity,
	onAddedEntity, 
	onRemoveEntity,
	;

	@Override
	public void dispatch(MessageHandler h, Object... args)
	{
		final EntityMessageHandler handler = (EntityMessageHandler)h;
		switch(this)
		{		
		case onInitEntity:
			handler.onInitEntity();
			break;
		case onDeinitEntity:
			handler.onDeinitEntity();
			break;
		case onAddedEntity:
			handler.onAddedEntity((Entity)args[0]);
			break;
		case onRemoveEntity:
			handler.onRemoveEntity((Entity)args[0]);
			break;
		}		
	}

	@Override
	public Class<EntityMessageHandler> getClassHandler() 
	{
		return EntityMessageHandler.class;		
	}

}
