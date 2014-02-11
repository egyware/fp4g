package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum KeyMessage implements Message<KeyMessageHandler> {
	onPressKey,
	onReleaseKey;

	@Override
	public Class<KeyMessageHandler> getClassHandler() 
	{		
		return KeyMessageHandler.class;
	}

	@Override
	public void dispatch(MessageHandler h, Object... args) {
		final KeyMessageHandler handler = (KeyMessageHandler)h;
		switch(this)
		{
		case onPressKey:
			handler.onPressKey((Integer)args[0]);
			break;
		case onReleaseKey:
			handler.onReleaseKey((Integer)args[0]);
			break;		
		}
		
	}

	
}
