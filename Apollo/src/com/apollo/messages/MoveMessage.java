package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum MoveMessage implements Message<MoveMessageHandler>
{
	onAngularSpeedMove,
	onSpeedMove,	
	onForwardMove;

	@Override
	public Class<MoveMessageHandler> getClassHandler() 
	{		
		return MoveMessageHandler.class;
	}

	@Override
	public void dispatch(MessageHandler h, Object... args) {
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
