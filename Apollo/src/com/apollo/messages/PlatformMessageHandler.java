package com.apollo.messages;

import com.apollo.MessageHandler;

public interface PlatformMessageHandler extends MessageHandler 
{	
	public void onBeginContactPlatform(int value);
	public void onEndContactPlatform(int intValue);
}
