package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface LifeMessageHandler extends IMessageReceiver 
{
	public void onDamage(int damage);
	public void onHeal(int heal);	
}
