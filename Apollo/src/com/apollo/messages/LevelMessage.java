package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageReciever;

public enum LevelMessage implements Message<LevelMessageHandler> {
	onChangeLevel,
	onReloadLevel;

	@Override
	public Class<LevelMessageHandler> getClassHandler() 
	{
		return LevelMessageHandler.class;
	}

	@Override
	public void dispatch(MessageReciever h, Object... args) 
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
