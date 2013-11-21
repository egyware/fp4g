package com.apollo.messages;

import com.apollo.Message;

public enum ContactMessage implements Message {
	onBeginContact,onEndContact;

	@Override
	public Class<?> getClassHandler() 
	{		
		return ContactMessageHandler.class;
	}

}
