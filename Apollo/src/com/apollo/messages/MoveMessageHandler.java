package com.apollo.messages;

import com.apollo.MessageReciever;

public interface MoveMessageHandler extends MessageReciever
{
	public void onAngularSpeedMove(float w);
	public void onSpeedMove(float x, float y);
	public void onForwardMove(float units);
}
