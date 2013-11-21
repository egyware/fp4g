package com.apollo.messages;

import com.apollo.Message;

public enum KeyMessage implements Message {
	onPressKey,
	onReleaseKey;

	@Override
	public Class<?> getClassHandler() 
	{		
		return KeyMessageHandler.class;
	}
	
}
