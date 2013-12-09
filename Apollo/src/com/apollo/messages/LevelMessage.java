package com.apollo.messages;

import com.apollo.Message;

public enum LevelMessage implements Message {
	onChangeLevel,
	onReloadLevel;

	@Override
	public Class<?> getClassHandler() 
	{
		return LevelMessageHandler.class;
	}

}
