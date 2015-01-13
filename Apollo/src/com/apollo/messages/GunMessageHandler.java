package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface GunMessageHandler extends IMessageReceiver 
{
	void onReloadGun(int ammo);
	void onShotGun(float rot, float dist, float vel);
	void onChangeBulletGun(String entityName);	
}
