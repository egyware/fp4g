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
	private Bag<Component> components;
	private Map<Class<? extends Component>, Component> componentsByType;
	private Map<Class<? extends Message>,Bag<MessageReceiver>> handlersByEventType;
	private boolean deleted;

	public Entity(World world) {
		this.world = world;
		components = new Bag<Component>();
		componentsByType = new LinkedHashMap<Class<? extends Component>, Component>();
	}

	public void setComponent(Component component) {		
		component.setOwner(this);
		components.add(component);
		componentsByType.put(component.getType(), component);		
	}
	
	public void removeComponent(Class<? extends Component> clazz) {
		Component component = getComponent(clazz);
		if(component!=null) {
			removeComponent(component);
		}
	}
	
	/**
	 * Remove a Component
	 * @param component to remove
	 */
	public void removeComponent(Component component) {
		components.remove(component);
		componentsByType.remove(component);
		
		world.getEntityManager().removeComponent(component, this);
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

	public <T extends Component> T getComponent(Class<T> type) {
		return type.cast(componentsByType.get(type));
	}
	
	public Bag<Component> getComponents() {
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

}
