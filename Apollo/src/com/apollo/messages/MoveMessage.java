package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum MoveMessage implements Message<MoveMessageHandler>
{
	onTranslateMove, onSpeedMove;

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
		case onSpeedMove:
			handler.onSpeedMove(((Number)args[0]).floatValue(), ((Number)args[1]).floatValue());
			break;
		case onTranslateMove:
			handler.onTranslateMove(((Number)args[0]).floatValue(), ((Number)args[1]).floatValue());
			break;				
		}		
	}
}
