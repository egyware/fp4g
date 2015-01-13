package com.apollo.messages;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;
import com.apollo.messages.SequenceMessageHandler;

public enum SequenceMessage implements IMessage<SequenceMessageHandler>
{
	onChangeSequence,
	onEndSequence;

	@Override
	public Class<SequenceMessageHandler> getClassHandler() 
	{		
		return SequenceMessageHandler.class;
	}

	@Override
	public void dispatch(IMessageReceiver h, Object... args) 
	{
		SequenceMessageHandler handler = (SequenceMessageHandler)h;
		switch(this)
		{
		case onChangeSequence:
			handler.onChangeSequence(args[0].toString());
			break;
		case onEndSequence:
			handler.onEndSequence();
			break;		
		}		
	}
}
