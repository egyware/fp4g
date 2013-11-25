package com.apollo;

import java.util.HashMap;
import java.util.Map;

import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

public abstract class Entity implements MessageReceiver{
	protected final World world;
	private Map<Message,Bag<MessageHandler>> handlersByEventType;
	private boolean deleted;

	public Entity(World world) {
		this.world = world;
	}

	public final World getWorld() {
		return world;
	}

	/**
	 * Is it marked for delete?
	 * @return
	 */
	public final boolean isDeleted() {
		return deleted;
	}

	/**
	 * Mark this entity how deleted
	 * @param deleted
	 */
	public final void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 *  Add this entity to the World
	 *  
	 */
	public final void addToWorld() {
		world.addEntity(this);
	}
	
	/**
	 * 
	 * @return
	 */
	public Map<Message, Bag<MessageHandler>> getAllEventHandlers() {
		return handlersByEventType;
	}
	
	/**
	 * 
	 * @param messageType Class of Message Type
	 * @param listener
	 */	
	public <T extends Message> void addEventHandler(Message messageType, MessageHandler listener) {
		if(handlersByEventType == null)
			handlersByEventType = new HashMap<Message,Bag<MessageHandler>>();
		
		Bag<MessageHandler> listeners = handlersByEventType.get(messageType);
		if(listeners == null) {
			listeners = new Bag<MessageHandler>();
			handlersByEventType.put(messageType,listeners);
		}
		listeners.add(listener);
	}
	
	public ImmutableBag<MessageHandler> getMessageHandler(Message messageType)
	{
		if(handlersByEventType == null)
			return null;		
		return handlersByEventType.get(messageType);		 
	}
	
	
	/**
	 * 
	 */	
	public <T extends Message> void removeEventHandler(Message messagetType, MessageHandler listener) {
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

	public abstract 
	Bag<Behavior> getBehaviors();

	public abstract <T extends Behavior>  
	T getBehavior(Class<T> type);

	public abstract 
	void update(float delta);

	protected abstract
	void uninitialize();

	protected abstract
	void initialize();


}