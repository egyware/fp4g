package com.apollo.messages;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum PlatformMessage implements  IMessage<PlatformMessageHandler>
{
	onBeginContactPlatform, 
	onEndContactPlatform,
	;
	public final static int GROUND = 0;
	public final static int LEFTWALL = 1;
	public final static int RIGHTWALL = 2;

	@Override
	public void dispatch(IMessageReceiver handler, Object... args) 
	{
		PlatformMessageHandler h = (PlatformMessageHandler)handler;
		switch(this)
		{
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
