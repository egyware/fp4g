package com.apollo.messages;

import com.apollo.Message;

public class MouseMoveMessage extends Message 
{
	public int x;
	public int y;
	
	@Override
	public Class<? extends Message> getType() 
	{
		return MouseMoveMessage.class;
	}

}
