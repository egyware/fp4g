package com.apollo.messages;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum LevelMessage implements IMessage<LevelMessageHandler> {
	onChangeLevel,
	onReloadLevel;

	@Override
	public Class<LevelMessageHandler> getClassHandler() 
	{
		return LevelMessageHandler.class;
	}

	@Override
	public void dispatch(IMessageReceiver h, Object... args) 
	{
		final LevelMessageHandler handler = (LevelMessageHandler)h;
		switch(this)
		{
		case onChangeLevel:
			handler.onChangeLevel((String)args[0]);
			break;
		case onReloadLevel:
			handler.onReloadLevel();
			break;
		}		
	}

}
