package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageReciever;
import com.apollo.messages.SequenceMessageHandler;

public enum SequenceMessage implements Message<SequenceMessageHandler>
{
	onChangeSequence,
	onEndSequence;

	@Override
	public Class<SequenceMessageHandler> getClassHandler() 
	{		
		return SequenceMessageHandler.class;
	}

	@Override
	public void dispatch(MessageReciever h, Object... args) 
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
