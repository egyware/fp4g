package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;


public class EndContactMessage extends Message
{
	public Entity other;
	public Fixture ownFixture;
	public Fixture otherFixture;
	public Contact contact;

	@Override
	public Class<? extends Message> getType() 
	{
		return EndContactMessage.class;
	}

}
