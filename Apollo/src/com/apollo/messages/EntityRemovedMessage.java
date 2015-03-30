package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;

public class EntityRemovedMessage extends Message 
{
	public static final int ADDED = 1;
	public static final int REMOVED = 2;
	
	public int operation;
	public Entity entity;
	

	@Override
	public Class<? extends Message> getType() 
	{
		return EntityRemovedMessage.class;
	}
}
