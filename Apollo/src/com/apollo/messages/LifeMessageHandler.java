package com.apollo.messages;

import com.apollo.MessageHandler;

public interface LifeMessageHandler extends MessageHandler 
{
	public void onDamageLife(int damage);
	public void onHealLife(int heal);
	public void onDeathLife();
}
