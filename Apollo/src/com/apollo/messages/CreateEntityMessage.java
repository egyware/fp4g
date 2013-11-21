package com.apollo.messages;

import com.apollo.Message;

public enum CreateEntityMessage implements Message {
	onCreateEntity;

	@Override
	public Class<?> getClassHandler() 
	{
		return CreateEntityMessageHandler.class;
	}

}
