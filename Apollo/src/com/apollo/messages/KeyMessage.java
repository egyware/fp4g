package com.apollo.messages;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum KeyMessage implements IMessage<KeyMessageHandler> {
	onPressKey,
	onReleaseKey;

	@Override
	public Class<KeyMessageHandler> getClassHandler() 
	{		
		return KeyMessageHandler.class;
	}

	@Override
	public void dispatch(IMessageReceiver h, Object... args) {
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
