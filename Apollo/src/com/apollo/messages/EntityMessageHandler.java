package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.IMessageReceiver;

/**
 * @author Edgardo
 *
 */
public interface EntityMessageHandler extends IMessageReceiver 
{
	void onAddedEntity(Entity e);
	void onRemovedEntity(Entity e);	
}
