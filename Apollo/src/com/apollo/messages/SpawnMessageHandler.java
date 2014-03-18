package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.MessageHandler;

/**
 * TODO recategorizar este mensaje
 * @author Edgardo
 *
 */
public interface SpawnMessageHandler extends MessageHandler 
{
	void onAddedSpawn(Entity entity);
	void onRemovedSpawn(Entity entity);
}
