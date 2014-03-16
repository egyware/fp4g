package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.MessageHandler;

public enum CameraMessage implements Message<CameraMessageHandler>
{
	onFollow,
	onUnfollow,	
	;

	@Override
	public void dispatch(MessageHandler h, Object... args)
	{
		final CameraMessageHandler handler = (CameraMessageHandler)h;
		switch(this)
		{		
		case onFollow:
			handler.onFollow((Entity)args[0]);
			break;
		case onUnfollow:
			handler.onUnfollow();
			break;
		}
		
	}

	@Override
	public Class<CameraMessageHandler> getClassHandler() 
	{
		return CameraMessageHandler.class;		
	}
}
