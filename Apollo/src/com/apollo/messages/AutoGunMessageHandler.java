package com.apollo.messages;

import com.apollo.MessageHandler;

public interface AutoGunMessageHandler extends MessageHandler 
{
	void onSetDelayShotAutoGun(int intValue);
	void onSetShotAutoGun(float rot, float dist, float vel);
}
