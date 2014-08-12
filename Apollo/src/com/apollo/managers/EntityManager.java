package com.apollo.managers;

import java.util.HashMap;
import java.util.Map;

import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.MessageHandler;
import com.apollo.MessageReceiver;
import com.apollo.managers.entity.EntitySpawn;
import com.apollo.messages.SpawnMessage;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

public class EntityManager extends Manager implements MessageReceiver
{
	private Bag<Entity> entities;	 
	private Map<Message<?>,Bag<MessageHandler>> handlersByEventType;
		
	public EntityManager()
	{
		entities = new Bag<Entity>();		
	}
	
	public void setEntities(EntitySpawn spawner)
	{
		//agregamos todas las entidades		
		for(int i=0; i < spawner.lenght; i++)
		{
			Entity entity = world.createEntity(spawner.entities[i], spawner.params[i]);
			if(entity != null)
			{
				world.addEntity(entity);
			}
		}		
	}
	
	public ImmutableBag<Entity> getEntities() 
	{
		return entities;
	}

	@Override
	public void added(Entity entity) 
	{
		onMessage(SpawnMessage.onAddedSpawn, entity);
		entities.add(entity);		
	}
	
	@Override
	public void removed(Entity entity) 
	{
		onMessage(SpawnMessage.onRemoveSpawn, entity);
		entities.remove(entity);		
		
	}

	@Override
	public void update(float delta) {		
		for (int i = 0, s = entities.size(); s > i; i++) {
			Entity entity = entities.get(i);
			entity.update(delta);
		}
	}

	@Override
	public ImmutableBag<MessageHandler> getMessageHandler(Message<?> messageType) 
	{
		if(handlersByEventType == null)
			return null;		
		return handlersByEventType.get(messageType); 
	}
	
	public <T extends Message<?>> void removeEventHandler(Message<?> messagetType, MessageHandler listener) 
	{
		if(handlersByEventType == null)
		{
			return;
		}		
		Bag<MessageHandler> listeners = handlersByEventType.get(messagetType);
		if(listeners == null) {
			return;
		}
		listeners.remove(listener);
	}
	/**
	 * 
	 * @param messageType Class of Message Type
	 * @param listener
	 */	
	public <T extends Message<?>> void addEventHandler(Message<?> messageType, MessageHandler listener) {
		if(handlersByEventType == null)
			handlersByEventType = new HashMap<Message<?>,Bag<MessageHandler>>();
		
		Bag<MessageHandler> listeners = handlersByEventType.get(messageType);
		if(listeners == null) {
			listeners = new Bag<MessageHandler>();
			handlersByEventType.put(messageType,listeners);
		}
		listeners.add(listener);
	}

	@Override
	public void onMessage(Message<? extends MessageHandler> message, Object... args) 
	{
		ImmutableBag<MessageHandler> listeners = getMessageHandler(message);
		if(listeners != null)
		{
			final int size = listeners.size();
			for(int i=0; i<size; i++)
			{
				MessageHandler handler = listeners.get(i);
				handler.onMessage(message, args);			
			}
		}		
	}
	
}
