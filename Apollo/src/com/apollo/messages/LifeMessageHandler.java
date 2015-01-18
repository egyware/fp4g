package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface LifeMessageHandler extends IMessageReceiver 
{
	public boolean onDamageLife(int damage);
	public boolean onHealLife(int heal);
	public boolean onDeathLife();
}
