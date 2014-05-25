package com.apollo.messages;

import com.apollo.MessageHandler;

public interface PlatformMessageHandler extends MessageHandler 
{	

	public void onMovePlatform(float vel);	
	public void onJumpPlatform(float vel);
	public void onBeginContactPlatform(int value);
	public void onEndContactPlatform(int intValue);

}
