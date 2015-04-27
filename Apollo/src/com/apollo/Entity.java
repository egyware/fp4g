package com.apollo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.apollo.annotate.ComponentInjector;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

public final class Entity implements MessageSender
{
	protected final Engine engine;
	private Family family;
	private long id;
	private Map<Class<? extends Message>, Bag<MessageReceiver>> handlersByEventType;
	private final Bag<Behavior> behaviors;
	private final Map<Class<? extends Behavior>, Behavior> componentsByType;	
	private boolean deleted;

	public Entity(Engine engine)
	{
		this.engine = engine;		
		behaviors = new Bag<Behavior>();
		componentsByType = new LinkedHashMap<Class<? extends Behavior>, Behavior>();
	}
	
	public Entity(Engine engine, int n) 
	{
		this.engine = engine;		
		behaviors = new Bag<Behavior>(n);
		componentsByType = new LinkedHashMap<Class<? extends Behavior>, Behavior>(n,1);
	}
	
	public final Family getFamily()
	{
		return family;
	}
	public final void setFamily(Family f)
	{
		family = f;
	}

	public final Engine getEngine() {
		return engine;
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
		engine.addEntity(this);
	}
	
	/**
	 * 
	 * @return
	 */
	public Map<Class<? extends Message>, Bag<MessageReceiver>> getAllEventHandlers() 
	{
		return handlersByEventType;
	}
	
	/**
	 * 
	 * @param messageType Class of Message Type
	 * @param listener
	 */	
	public void addMessageHandler(Class<? extends Message> type, MessageReceiver listener) 
	{
		if(handlersByEventType == null)
			handlersByEventType = new HashMap<Class<? extends Message>, Bag<MessageReceiver>>();
		
		Bag<MessageReceiver> listeners = handlersByEventType.get(type);
		if(listeners == null) {
			listeners = new Bag<MessageReceiver>();
			handlersByEventType.put(type,listeners);
		}
		listeners.add(listener);
	}
	
	/**
	  * Caso general de envio de mensajes.
	  * @param message Mensaje a enviar.
	  * @param args Argumentos del mensaje.
	  */
	@Override
	public void onMessage(Object sender, Message message) 
	{		
		ImmutableBag<MessageReceiver> listeners = getMessageHandler(message.getType());
		if(listeners != null)
		{
			final int size = listeners.size();
			for(int i=0; i<size; i++)
			{
				MessageReceiver handler = listeners.get(i);
				handler.onMessage(sender, message);						
			}
		}
	}
	
	/**
	 * 
	 */	
	public void removeMessageHandler(Class<? extends Message> type, MessageReceiver listener)
	{
		if(handlersByEventType == null)
		{
			return;
		}		
		Bag<MessageReceiver> listeners = handlersByEventType.get(type);
		if(listeners == null) 
		{
			return;
		}
		listeners.remove(listener);
	}

	public void setBehavior(Behavior component)
	{		
		component.setOwner(this);
		behaviors.add(component);
		componentsByType.put(component.getType(), component);		
	}
	
	public void removeBehavior(Class<? extends Behavior> clazz)
	{
		Behavior component = getBehavior(clazz);
		if(component!=null) {
			removeBehavior(component);
		}
	}
	
	/**
	 * Remove a Component
	 * @param component to remove
	 */
	public void removeBehavior(Behavior component)
	{
		behaviors.remove(component);
		componentsByType.remove(component);	
	}

	public void applyComponentAnnotations() 
	{
		for (Behavior component : getBehaviors()) 
		{
			ComponentInjector.applyAnnotations(component);
		}		
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Entity:\n");
		builder.append("{");
		for (int i = 0, s = behaviors.size(); s > i; i++) 
		{
			builder.append("\t");
			builder.append(behaviors.get(i).toString());
			builder.append(",\n");
		}
		builder.append("}");
		
		return builder.toString();
	}
	

	/** 
	 * Initialize all the component
	 */	
	protected void initialize()
	{
		for (int i = 0, s = behaviors.size(); s > i; i++) {
			behaviors.get(i).initialize();
		}
	}
	
	protected void uninitialize() 
	{
		handlersByEventType.clear();
		for (int i = 0, s = behaviors.size(); s > i; i++) {
			behaviors.get(i).uninitialize();
		}
	}

	public void update(float delta)
	{
		for (int i = 0, s = behaviors.size(); s > i; i++) {
			behaviors.get(i).update(delta);
		}
	}

	public final <T extends Behavior> T getBehavior(Class<T> type) 
	{
		return type.cast(componentsByType.get(type));
	}
	

	public final <T extends Behavior> boolean hasBehavior(Class<T> type) 
	{
		return componentsByType.containsKey(type);
	}
	
	public final ImmutableBag<Behavior> getBehaviors() 
	{
		return behaviors;
	}
	
	private ImmutableBag<MessageReceiver> getMessageHandler(Class<? extends Message> type)
	{
		if(handlersByEventType == null)
			return null;		
		return handlersByEventType.get(type);		 
	}
	
	public final long getId()
	{
		return id;
	}
	
	public final void setId(long id)
	{
		this.id = id;
	}

}