package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.IMessage;
import com.apollo.IMessageReceiver;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;

public enum ContactMessage implements IMessage<ContactMessageHandler> {
	onBeginContact,onEndContact;

	@Override
	public Class<ContactMessageHandler> getClassHandler() 
	{		
		return ContactMessageHandler.class;
	}

	@Override
	public void dispatch(IMessageReceiver h, Object... args) {
		final ContactMessageHandler handler = (ContactMessageHandler)h;
		switch(this)
		{
		case onBeginContact:
			handler.onBeginContact((Entity)args[0], (Fixture)args[1], (Fixture)args[2], (Contact)args[3]);
			break;
		case onEndContact:
			handler.onEndContact((Entity)args[0], (Fixture)args[1], (Fixture)args[2], (Contact)args[3]);
			break;
		default:
			break;		
		}
		
	}

}
