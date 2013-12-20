package com.apollo.messages;

import com.apollo.MessageHandler;

public interface GunMessageHandler extends MessageHandler 
{
	void onReloadGun(int ammo);
	void onShotGun(float rot, float dist, float vel);
	void onChangeBulletGun(String entityName);
}
