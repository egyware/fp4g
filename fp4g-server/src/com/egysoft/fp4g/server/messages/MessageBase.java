package com.egysoft.fp4g.server.messages;

public abstract class MessageBase 
{
	public final Message type;
	public MessageBase(Message message)
	{
		this.type = message;		
	}

}
