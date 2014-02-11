package com.apollo.messages;

import com.apollo.MessageHandler;

public interface MoveMessageHandler extends MessageHandler
{
	public void onAngularSpeedMove(float w);
	public void onSpeedMove(float x, float y);
	
	public void onTranslateMove(float x,float y);
	public void onRotateMove(float grad);
	public void onForwardMove(float units);
}
