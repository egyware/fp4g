package com.apollo.messages;

import com.apollo.MessageReciever;

public interface PlatformMessageHandler extends MessageReciever 
{	
	public void onBeginContactPlatform(int value);
	public void onEndContactPlatform(int intValue);
}
