package com.apollo.messages;

import com.apollo.Message;

public class DamageLifeMessage extends Message 
{
	public int amount;
	
	@Override
	public Class<? extends Message> getType()
	{
		return DamageLifeMessage.class;
	}

}
