package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.MessageReciever;

/**
 * @author Edgardo
 *
 */
public interface EntityMessageHandler extends MessageReciever 
{
	void onAddedEntity(Entity e);
	void onRemovedEntity(Entity e);	
}
