package com.apollo.behaviors;

import com.apollo.BaseBehavior;
import com.apollo.Message;
import com.apollo.MessageHandler;
import com.apollo.messages.LifeMessage;
import com.apollo.messages.LifeMessage;

public class LifeBehavior extends BaseBehavior
implements MessageHandler
{	
	public int hp;	
	public int hp_max;
	public LifeBehavior(int hp_max)
	{
		this(hp_max, hp_max);
	}
	public LifeBehavior(int hp, int hp_max)
	{		
		this.hp = hp;
		this.hp_max = hp_max;
	}
	
	public void initialize()
	{
		owner.addMessageHandler(LifeMessage.onDamage, this);
		owner.addMessageHandler(LifeMessage.onHeal, this);
	}
	
	public void uninitialize()
	{
		owner.removeMessageHandler(LifeMessage.onDamage, this);
		owner.removeMessageHandler(LifeMessage.onHeal, this);
	}

	public void onDamage(int damage) 
	{
		if(hp > damage) hp -= damage;
		else hp = 0;		
	}
	
	public void onHeal(int heal) 
	{			
		if(hp + heal < hp_max) hp += heal;
		else hp = hp_max;		
	}
	
	@Override
	public void onMessage(Object sender, Message message) 
	{
		final LifeMessage lifeMessage = (LifeMessage)message;
		switch(lifeMessage.type)
		{
		case onDamage:
			break;
		case onHeal:
			break;
		default:
			break;			
		}
	}
}
