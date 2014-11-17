package com.apollo.messages;

import com.apollo.MessageReciever;

public interface GunMessageHandler extends MessageReciever 
{
	void onReloadGun(int ammo);
	void onShotGun(float rot, float dist, float vel);
	void onChangeBulletGun(String entityName);	
}
