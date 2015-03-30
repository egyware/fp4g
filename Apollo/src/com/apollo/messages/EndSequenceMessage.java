package com.apollo.messages;

import com.apollo.Message;

public class EndSequenceMessage extends Message
{
	@Override
	public Class<? extends Message> getType() 
	{
		return EndSequenceMessage.class;
	}
}
