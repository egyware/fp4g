package com.apollo.behaviors;

import com.apollo.BaseBehavior;
import com.apollo.filters.LifeMessageFilter;
import com.apollo.filters.LifeMessageFilterHandler;

public class LifeBehavior extends BaseBehavior 
implements LifeMessageFilterHandler
{	
	public int hp;
	public LifeBehavior(int hp)
	{		
		this.hp = hp;
	}
	
	public void initialize()
	{
		owner.addMessageFilter(LifeMessageFilter.onDamageLife, this);
		owner.addMessageFilter(LifeMessageFilter.onHealLife, this);
	}
	
	public void uninitialize()
	{
		owner.removeMessageFilter(LifeMessageFilter.onDamageLife, this);
		owner.removeMessageFilter(LifeMessageFilter.onHealLife, this);
	}

	@Override
	public boolean onDamageLife(int damage) 
	{
		hp -= damage;
		if(hp <= 0)
		{
			owner.onMessage(LifeMessageFilter.onDeathLife);
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
