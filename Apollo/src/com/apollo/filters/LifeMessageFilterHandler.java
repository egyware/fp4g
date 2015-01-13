package com.apollo.filters;

import com.apollo.IMessageFilterReceiver;

public interface LifeMessageFilterHandler extends IMessageFilterReceiver 
{
	public boolean onDamageLife(int damage);
	public boolean onHealLife(int heal);
	public boolean onDeathLife();
}
