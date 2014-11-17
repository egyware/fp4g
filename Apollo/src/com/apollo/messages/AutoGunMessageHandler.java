package com.apollo.messages;

import com.apollo.MessageReciever;

public interface AutoGunMessageHandler extends MessageReciever 
{
	void onSetDelayShotAutoGun(int intValue);
	void onSetShotAutoGun(float rot, float dist, float vel);
}
