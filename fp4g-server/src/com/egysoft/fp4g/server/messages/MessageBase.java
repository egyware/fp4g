package com.egysoft.fp4g.server.messages;

import com.egysoft.fp4g.net.IEngine;
import com.egysoft.fp4g.net.IUser;

public abstract class MessageBase 
{
	public final Message type;
	public MessageBase(Message message)
	{
		this.type = message;		
	}
	
	public abstract void processMessage(final IEngine engine,final IUser user);

}
