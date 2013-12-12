package com.apollo.messages;

import com.apollo.Message;

public enum MoveMessage implements Message
{
	onTranslateMove, onSpeedMove;

	@Override
	public Class<?> getClassHandler() 
	{		
		return MoveMessageHandler.class;
	}
}
