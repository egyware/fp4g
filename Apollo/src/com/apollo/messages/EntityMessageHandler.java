package com.apollo.messages;

import com.apollo.MessageHandler;

/**
 * TODO recategorizar este mensaje
 * @author Edgardo
 *
 */
public interface EntityMessageHandler extends MessageHandler 
{
	void onInitEntity();
	void onDeinitEntity();	
}
