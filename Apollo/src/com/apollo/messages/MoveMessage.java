package com.apollo.messages;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum MoveMessage implements IMessage<MoveMessageHandler>
{
	onAngularSpeedMove,
	onSpeedMove,	
	onForwardMove;

	@Override
	public void dispatch(IMessageReceiver h, Object... args) {
		final MoveMessageHandler handler = (MoveMessageHandler)h;	
		switch(this)
		{
		case onForwardMove:
			handler.onForwardMove(((Number)args[0]).floatValue());
			break;
		case onAngularSpeedMove:
			handler.onAngularSpeedMove(((Number)args[0]).floatValue());
			break;
		case onSpeedMove:
			handler.onSpeedMove(((Number)args[0]).floatValue(), ((Number)args[1]).floatValue());
			break;		
		}		
	}
}
