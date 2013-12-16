package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum LevelMessage implements Message<LevelMessageHandler> {
	onChangeLevel,
	onReloadLevel;

	@Override
	public Class<LevelMessageHandler> getClassHandler() 
	{
		return LevelMessageHandler.class;
	}

	@Override
	public void dispatch(MessageHandler h, Object... args) {
		final LevelMessageHandler handler = (LevelMessageHandler)h;
		// TODO Auto-generated method stub
		
	}

}
