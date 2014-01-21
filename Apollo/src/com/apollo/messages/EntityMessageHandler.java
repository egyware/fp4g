package com.apollo.messages;

import com.apollo.MessageHandler;

public interface EntityMessageHandler extends MessageHandler 
{
	void onInitEntity();
	void onDeinitEntity();
}
