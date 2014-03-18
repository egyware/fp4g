package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.MessageHandler;

public enum CameraMessage implements Message<CameraMessageHandler>
{
	onFollowCamera,
	onUnfollowCamera,	
	;

	@Override
	public void dispatch(MessageHandler h, Object... args)
	{
		final CameraMessageHandler handler = (CameraMessageHandler)h;
		switch(this)
		{		
		case onFollowCamera:
			handler.onFollow((Entity)args[0]);
			break;
		case onUnfollowCamera:
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
