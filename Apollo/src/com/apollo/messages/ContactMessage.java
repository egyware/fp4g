package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;

public final class ContactMessage implements Message{	
	public Entity other;
	public Fixture otherFixture;
	public Fixture ownFixture;
	public Contact contact;
	public boolean begin;	
}
