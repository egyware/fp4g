package com.apollo.components;

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
		owner.addEventHandler(LifeMessage.onDamageLife, this);
		owner.addEventHandler(LifeMessage.onHealLife, this);
	}
	
	public void uninitialize()
	{
		owner.removeEventHandler(LifeMessage.onDamageLife, this);
		owner.removeEventHandler(LifeMessage.onHealLife, this);
	}

	@Override
	public void onDamageLife(int damage) 
	{
		hp -= damage;
		if(hp <= 0)
		{
			owner.onMessage(LifeMessage.onDeathLife);
		}
	}

	@Override
	public void onHealLife(int heal) 
	{			
		hp += heal;
	}

	@Override
	public void onDeathLife() 
	{			
	}
	
	public static LifeBehavior build(Number n)
	{
		return new LifeBehavior(n.intValue());
	}
}
