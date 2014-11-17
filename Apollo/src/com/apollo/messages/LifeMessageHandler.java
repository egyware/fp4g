package com.apollo.messages;

import com.apollo.MessageReciever;

public interface LifeMessageHandler extends MessageReciever 
{
	public void onDamageLife(int damage);
	public void onHealLife(int heal);
	public void onDeathLife();
}
