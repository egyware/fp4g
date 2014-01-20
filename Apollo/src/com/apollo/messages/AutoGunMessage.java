package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum AutoGunMessage implements Message<GunMessageHandler> 
{
	onSetDelayShotAutoGun,
	onSetShotAutoGun	
	;

	@Override
	public void dispatch(MessageHandler h, Object... args)
	{
		final AutoGunMessageHandler handler = (AutoGunMessageHandler)h;
		switch(this)
		{		
		case onSetDelayShotAutoGun:
			handler.onSetDelayShotAutoGun(((Number)args[0]).intValue());
			break;
		case onSetShotAutoGun:
			handler.onSetShotAutoGun(((Number)args[0]).floatValue(),((Number)args[1]).floatValue(),((Number)args[2]).floatValue());
			break;
		}
		
	}

	@Override
	public Class<GunMessageHandler> getClassHandler() 
	{
		return GunMessageHandler.class;		
	}

}
