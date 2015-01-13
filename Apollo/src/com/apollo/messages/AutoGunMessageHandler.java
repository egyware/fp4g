package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface AutoGunMessageHandler extends IMessageReceiver 
{
	void onSetDelayShotAutoGun(int intValue);
	void onSetShotAutoGun(float rot, float dist, float vel);
}
