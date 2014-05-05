package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum PlatformMessage implements  Message<PlatformMessageHandler>
{
	onMovePlatform,
	onJumpPlatform
	;

	@Override
	public void dispatch(MessageHandler handler, Object... args) 
	{
		PlatformMessageHandler h = (PlatformMessageHandler)handler;
		switch(this)
		{
		case onMovePlatform:
			h.onMovePlatform(((Number)args[0]).floatValue());
			break;
		case onJumpPlatform:
			h.onJumpPlatform(((Number)args[0]).floatValue());
			break;
		}		
	}

	@Override
	public Class<PlatformMessageHandler> getClassHandler()
	{
		return PlatformMessageHandler.class;
	}
}
