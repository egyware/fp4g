package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.MessageHandler;
//TODO no me tinca este nombre...
public enum SpawnMessage implements Message<SpawnMessageHandler> 
{	
	onAddedSpawn, 
	onRemoveSpawn,
	;

	@Override
	public void dispatch(MessageHandler h, Object... args)
	{
		final SpawnMessageHandler handler = (SpawnMessageHandler)h;
		switch(this)
		{
		case onAddedSpawn:
			handler.onAddedSpawn((Entity)args[0]);
			break;
		case onRemoveSpawn:
			handler.onRemovedSpawn((Entity)args[0]);
			break;
		}		
	}

	@Override
	public Class<SpawnMessageHandler> getClassHandler() 
	{
		return SpawnMessageHandler.class;		
	}

}
