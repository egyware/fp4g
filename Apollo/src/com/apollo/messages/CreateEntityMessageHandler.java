package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.IMessageReceiver;

/**
 * Pide crear una entidad nueva, la nueva entididad qudará guardada en entity
 * @author egyware
 *
 */
public interface CreateEntityMessageHandler extends IMessageReceiver
{	
	public Entity onCreateEntity(String name,Object[] args);
}
