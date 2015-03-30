package com.apollo.messages;

import com.apollo.Message;

public class TimerCanceledMessage extends Message
{

	public int timer;

	@Override
	public Class<? extends Message> getType() 
	{
		return TimerCanceledMessage.class;
	}
	
}
