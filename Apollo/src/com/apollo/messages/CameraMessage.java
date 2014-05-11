package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.MessageHandler;

public enum CameraMessage implements Message<CameraMessageHandler>
{
	onFollowCamera,
	onUnfollowCamera,	
	onExitFollowZoneCamera,
	onCheckAndFollowCamera,
	;

	@Override
	public void dispatch(MessageHandler h, Object... args)
	{
		final CameraMessageHandler handler = (CameraMessageHandler)h;
		switch(this)
		{		
		case onFollowCamera:
			handler.onFollowCamera((Entity)args[0]);
			break;
		case onUnfollowCamera:
			handler.onUnfollowCamera();
			break;
		case onCheckAndFollowCamera:
			handler.onCheckAndFollowCamera((Entity)args[0]);
			break;
		case onExitFollowZoneCamera:
			handler.onExitFollowZoneCamera((Entity)args[0]);
			break;		
		}
		
	}

	@Override
	public Class<CameraMessageHandler> getClassHandler() 
	{
		return CameraMessageHandler.class;		
	}
}
