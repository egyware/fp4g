package com.apollo.messages;

import com.apollo.Message;

public class TimerActivedMessage extends Message
{

	public int timer;

	@Override
	public Class<? extends Message> getType() 
	{
		return TimerActivedMessage.class;
	}
	
}
