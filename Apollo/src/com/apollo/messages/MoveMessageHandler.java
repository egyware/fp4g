package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface MoveMessageHandler extends IMessageReceiver
{
	public void onAngularSpeedMove(float w);
	public void onSpeedMove(float x, float y);
	public void onForwardMove(float units);
}
