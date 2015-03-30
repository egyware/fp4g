package com.apollo.messages;

import com.apollo.Message;

public class KeyUpMessage extends Message
{
	public int key;
		
	@Override
	public Class<? extends Message> getType() 
	{
		return KeyUpMessage.class;
	}	
}
