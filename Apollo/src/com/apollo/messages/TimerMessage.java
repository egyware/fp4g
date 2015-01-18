package com.apollo.messages;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum TimerMessage implements IMessage<AutoGunMessageHandler> 
{
	onActiveTimer,
	onSetTimeTimer,
	onCancelTimer,
	;

	@Override
	public void dispatch(IMessageReceiver h, Object... args)
	{
		final TimerMessageHandler handler = (TimerMessageHandler)h;
		switch(this)
		{		
		case onActiveTimer:
			handler.onActiveTimer(((Number)args[0]).intValue());
			break;
		case onSetTimeTimer:
			handler.onSetTimeTimer(((Number)args[0]).intValue(),((Number)args[1]).intValue());
			break;
		case onCancelTimer:
			handler.onCancelTimer(((Number)args[0]).intValue());
			break;
		}
		
	}
}
