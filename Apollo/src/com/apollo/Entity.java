package com.apollo;

import java.util.HashMap;
import java.util.Map;

import com.apollo.messages.MessageReceiver;
import com.apollo.utils.Bag;

public abstract class Entity {
	protected final World world;
	private Map<Class<? extends Message>,Bag<MessageReceiver>> handlersByEventType;
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
	public Map<Class<? extends Message>, Bag<MessageReceiver>> getAllEventHandlers() {
		return handlersByEventType;
	}
	
	/**
	 * 
	 * @param eventType Class of Message Type
	 * @param listener
	 */	
	public <T extends Message> void addEventHandler(Class<T> eventType, MessageReceiver listener) {
		if(handlersByEventType == null)
			handlersByEventType = new HashMap<Class<? extends Message>,Bag<MessageReceiver>>();
		
		Bag<MessageReceiver> listeners = handlersByEventType.get(eventType);
		if(listeners == null) {
			listeners = new Bag<MessageReceiver>();
			handlersByEventType.put(eventType,listeners);
		}
		listeners.add(listener);
	}
	
	/**
	 * 
	 */	
	public <T extends Message> void removeEventHandler(Class<T> eventType, MessageReceiver listener) {
		if(handlersByEventType == null)
		{
			return;
		}		
		Bag<MessageReceiver> listeners = handlersByEventType.get(eventType);
		if(listeners == null) {
			return;
		}
		listeners.remove(listener);
	}

	/**
	 * Fire a some event...
	 * 
	 * @param eventType
	 */
	public <T extends Message> void fireEvent(T eventType) {
		if(handlersByEventType != null) {
			Bag<MessageReceiver> handlers = handlersByEventType.get(eventType.getClass());
			if(handlers != null) {
				for(int i = 0; handlers.size() > i; i++) {					
					MessageReceiver handler = handlers.get(i);
					handler.onMessage(eventType);										
				}
			}
		}
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