package com.apollo.messages;

import com.apollo.Message;

public class KeyDownMessage extends Message
{
	public int key;	
	
	@Override
	public Class<? extends Message> getType() 
	{
		return KeyDownMessage.class;
	}	
}
