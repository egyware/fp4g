package com.apollo.behaviors;

import com.apollo.BaseBehavior;
import com.apollo.Message;
import com.apollo.MessageReceiver;
import com.apollo.messages.DamageLifeMessage;
import com.apollo.messages.HealLifeMessage;


public class LifeBehavior extends BaseBehavior
implements MessageReceiver
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
		owner.addMessageHandler(HealLifeMessage.class, this);
		owner.addMessageHandler(DamageLifeMessage.class, this);
	}
	
	public void uninitialize()
	{
		owner.removeMessageHandler(HealLifeMessage.class, this);
		owner.removeMessageHandler(DamageLifeMessage.class, this);
	}

	public void damage(int damage) 
	{
		if(hp > damage) hp -= damage;
		else hp = 0;		
	}
	
	public void heal(int heal) 
	{			
		if(hp + heal < hp_max) hp += heal;
		else hp = hp_max;		
	}
	
	@Override
	public void onMessage(Object sender, Message m) 
	{
		if(m instanceof HealLifeMessage)
		{
			heal(((HealLifeMessage) m).amount);
		}
		if(m instanceof DamageLifeMessage)
		{
			damage(((DamageLifeMessage) m).amount);
		}	
		
	}
}
