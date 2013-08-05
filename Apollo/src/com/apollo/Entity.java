package com.apollo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.apollo.messages.MessageReceiver;
import com.apollo.utils.Bag;

/**
 * An Abstract Entity
 * 
 *
 */
public final class Entity {
	protected World world;
	private Bag<Behavior> components;
	private Map<Class<? extends Behavior>, Behavior> componentsByType;
	private Map<Class<? extends Message>,Bag<MessageReceiver>> handlersByEventType;
	private Map<String,Var<?>> variables;
	private boolean deleted;

	public Entity(World world) {
		this.world = world;
		components = new Bag<Behavior>();
		componentsByType = new LinkedHashMap<Class<? extends Behavior>, Behavior>();
		variables = new LinkedHashMap<String,Var<?>>();
	}

	public void setBehavior(Behavior component) {		
		component.setOwner(this);
		components.add(component);
		componentsByType.put(component.getType(), component);		
	}
	
	public void removeBehavior(Class<? extends Behavior> clazz) {
		Behavior component = getBehavior(clazz);
		if(component!=null) {
			removeBehavior(component);
		}
	}
	
	/**
	 * Remove a Component
	 * @param component to remove
	 */
	public void removeBehavior(Behavior component) {
		components.remove(component);
		componentsByType.remove(component);	
	}
	
	/** 
	 * Initialize all the component
	 */
	protected void initialize() {
		for (int i = 0, s = components.size(); s > i; i++) {
			components.get(i).initialize();
		}
	}
	
	protected void uninitialize() {
		for (int i = 0, s = components.size(); s > i; i++) {
			components.get(i).uninitialize();
		}
	}

	public void update(float delta) {
		for (int i = 0, s = components.size(); s > i; i++) {
			components.get(i).update(delta);
		}
	}

	public <T extends Behavior> T getBehavior(Class<T> type) {
		return type.cast(componentsByType.get(type));
	}
	
	public Bag<Behavior> getBehaviors() {
		return components;
	}

	public World getWorld() {
		return world;
	}

	/**
	 * Is it marked for delete?
	 * @return
	 */
	public boolean isDeleted() {
		return deleted;
	}
	
	/**
	 * Mark this entity how deleted
	 * @param deleted
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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
	
	public Map<Class<? extends Message>, Bag<MessageReceiver>> getAllEventHandlers() {
		return handlersByEventType;
	}
	
	/**
	 *  Add this entity to the World
	 *  
	 */
	public void addToWorld() {
		world.addEntity(this);
	}
	
	public Var<?> getVariable(String name)
	{
		return variables.get(name);
	}
	public void setVariable(String name,Var<?> var)
	{
		variables.put(name,var);		
	}
}
