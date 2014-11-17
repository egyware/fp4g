package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageReciever;

public enum AutoGunMessage implements Message<AutoGunMessageHandler> 
{
	onSetDelayShotAutoGun,
	onSetShotAutoGun	
	;

	@Override
	public void dispatch(MessageReciever h, Object... args)
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
