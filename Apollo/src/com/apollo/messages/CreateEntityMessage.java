package com.apollo.messages;

import java.util.Arrays;

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
		switch(this)
		{
		case onCreateEntity:
			handler.onCreateEntity(args[0].toString(), Arrays.copyOfRange(args, 1, args.length));			
			break;
		default:
			break;		
		}
	}

}
