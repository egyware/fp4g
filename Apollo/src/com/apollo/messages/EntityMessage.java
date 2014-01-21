package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum EntityMessage implements Message<EntityMessageHandler> 
{
	onInitEntity,
	onDeinitEntity	
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
		}
		
	}

	@Override
	public Class<EntityMessageHandler> getClassHandler() 
	{
		return EntityMessageHandler.class;		
	}

}
