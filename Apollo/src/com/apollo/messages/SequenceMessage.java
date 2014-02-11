package com.apollo.messages;

import com.apollo.Message;

public enum SequenceMessage implements Message 
{
	onChangeSequence,
	onEndSequence;

	@Override
	public Class<?> getClassHandler() 
	{		
		return SequenceMessageHandler.class;
	}
}
