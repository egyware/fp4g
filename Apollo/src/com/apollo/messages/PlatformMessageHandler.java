package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface PlatformMessageHandler extends IMessageReceiver 
{	
	public void onBeginContactPlatform(int value);
	public void onEndContactPlatform(int intValue);
}
