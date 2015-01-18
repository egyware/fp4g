package com.apollo.messages;

import java.util.Arrays;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum CreateEntityMessage implements IMessage<CreateEntityMessageHandler> {
	onCreateEntity;
	
	@Override
	public void dispatch(IMessageReceiver h, Object... args) {
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
