package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum PlatformMessage implements  Message<PlatformMessageHandler>
{
	onMovePlatform,
	onJumpPlatform,
	onBeginContactPlatform, 
	onEndContactPlatform,
	;
	public final static int GROUND = 0;
	public final static int LEFTWALL = 1;
	public final static int RIGHTWALL = 2;

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
		case onBeginContactPlatform:
			h.onBeginContactPlatform(((Number)args[0]).intValue());
			break;
		case onEndContactPlatform:
			h.onEndContactPlatform(((Number)args[0]).intValue());
			break;
		}		
	}

	@Override
	public Class<PlatformMessageHandler> getClassHandler()
	{
		return PlatformMessageHandler.class;
	}
}
