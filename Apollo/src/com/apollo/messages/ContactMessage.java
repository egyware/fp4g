package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;
import com.badlogic.gdx.physics.box2d.Contact;

public final class ContactMessage implements Message{	
	public Entity other;
	public Contact contact;
	public boolean begin;	
}
