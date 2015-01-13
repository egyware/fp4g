package com.apollo.messages;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum AutoGunMessage implements IMessage<AutoGunMessageHandler> 
{
	onSetDelayShotAutoGun,
	onSetShotAutoGun	
	;

	@Override
	public void dispatch(IMessageReceiver h, Object... args)
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
	public Class<AutoGunMessageHandler> getClassHandler() 
	{
		return AutoGunMessageHandler.class;		
	}

}
