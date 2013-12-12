package com.apollo.messages;

import com.apollo.MessageHandler;

public interface MoveMessageHandler extends MessageHandler
{
	public void oTranslateMove(float x,float y);
	public void onSpeedMove(float x, float y);	
}
