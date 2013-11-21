package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.MessageHandler;

/**
 * Pide crear una entidad nueva, la nueva entididad qudar� guardada en entity
 * @author egyware
 *
 */
public interface CreateEntityMessageHandler extends MessageHandler
{	
	public Entity onCreateEntity(String name,Object[] args);
}
