package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum TimerMessage implements Message<AutoGunMessageHandler> 
{
	onActiveTimer,
	onSetTimeTimer,
	onCancelTimer,
	;

	@Override
	public void dispatch(MessageHandler h, Object... args)
	{
		final TimerMessageHandler handler = (TimerMessageHandler)h;
		switch(this)
		{		
		case onActiveTimer:
			handler.onActiveTimer(((Number)args[0]).intValue());
			break;
		case onSetTimeTimer:
			handler.onSetTimeTimer(((Number)args[0]).intValue(),((Number)args[0]).intValue());
			break;
		case onCancelTimer:
			handler.onCancelTimer(((Number)args[0]).intValue());
			break;
		}
		
	}

	@Override
	public Class<AutoGunMessageHandler> getClassHandler() 
	{
		return AutoGunMessageHandler.class;		
	}

}
