package com.apollo.messages;

import com.apollo.Message;

public class HealLifeMessage extends Message 
{
	public int amount;
	
	@Override
	public Class<? extends Message> getType()
	{
		return HealLifeMessage.class;
	}

}
