package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.MessageHandler;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;

public interface ContactMessageHandler extends MessageHandler
{	
	public void onBeginContact(Entity other,Fixture otherFixture, Fixture ownFixture,Contact contact);
	public void onEndContact(Entity other,Fixture otherFixture, Fixture ownFixture,Contact contact);
}
