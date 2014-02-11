package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum CreateEntityMessage implements Message<CreateEntityMessageHandler> {
	onCreateEntity;

	@Override
	public Class<CreateEntityMessageHandler> getClassHandler() 
	{
		return CreateEntityMessageHandler.class;
	}

	@Override
	public void dispatch(MessageHandler h, Object... args) {
		final CreateEntityMessageHandler handler = (CreateEntityMessageHandler)h;
		
	}

}
