package com.apollo.behaviors;

import com.apollo.BaseBehavior;
import com.apollo.messages.LifeMessage;
import com.apollo.messages.LifeMessageHandler;

public class LifeBehavior extends BaseBehavior 
implements LifeMessageHandler
{	
	public int hp;
	public LifeBehavior(int hp)
	{		
		this.hp = hp;
	}
	
	public void initialize()
	{
		owner.addMessageHandler(LifeMessage.onDamageLife, this);
		owner.addMessageHandler(LifeMessage.onHealLife, this);
	}
	
	public void uninitialize()
	{
		owner.removeMessageHandler(LifeMessage.onDamageLife, this);
		owner.removeMessageHandler(LifeMessage.onHealLife, this);
	}

	@Override
	public boolean onDamageLife(int damage) 
	{
		hp -= damage;
		if(hp <= 0)
		{
			owner.onMessage(LifeMessage.onDeathLife);
		}		
		return false;
	}

	@Override
	public boolean onHealLife(int heal) 
	{			
		hp += heal;
		return false;
	}

	@Override
	public boolean onDeathLife() 
	{			
		return false;
	}		
}
