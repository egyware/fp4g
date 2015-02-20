package com.apollo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.apollo.annotate.ComponentInjector;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

public final class Entity implements IMessageSender
{
	protected final Engine engine;
	private Map<IMessage<?>,Bag<IMessageReceiver>> handlersByEventType;
	//private Map<IMessageFilter<?>, Queue<IMessageFilterReceiver>> filtersByEventType;
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
	public Map<IMessage<?>, Bag<IMessageReceiver>> getAllEventHandlers() {
		return handlersByEventType;
	}
	
	/**
	 * 
	 * @param messageType Class of Message Type
	 * @param listener
	 */	
	public <T extends IMessage<?>> void addMessageHandler(IMessage<?> messageType, IMessageReceiver listener) 
	{
		if(handlersByEventType == null)
			handlersByEventType = new HashMap<IMessage<?>,Bag<IMessageReceiver>>();
		
		Bag<IMessageReceiver> listeners = handlersByEventType.get(messageType);
		if(listeners == null) {
			listeners = new Bag<IMessageReceiver>();
			handlersByEventType.put(messageType,listeners);
		}
		listeners.add(listener);
	}
	
	/**
	  * Caso general de envio de mensajes.
	  * @param message Mensaje a enviar.
	  * @param args Argumentos del mensaje.
	  */
	@Override
	public void onMessage(IMessage<? extends IMessageReceiver> message, Object... args) 
	{		
		ImmutableBag<IMessageReceiver> listeners = getMessageHandler(message);
		if(listeners != null)
		{
			final int size = listeners.size();
			for(int i=0; i<size; i++)
			{
				IMessageReceiver handler = listeners.get(i);
				handler.onMessage(message, args);						
			}
		}
	}
	
	/**
	 * 
	 */	
	public <T extends IMessage<?>> void removeMessageHandler(IMessage<?> messagetType, IMessageReceiver listener) {
		if(handlersByEventType == null)
		{
			return;
		}		
		Bag<IMessageReceiver> listeners = handlersByEventType.get(messagetType);
		if(listeners == null) {
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

	public <T extends Behavior> T getBehavior(Class<T> type) 
	{
		return type.cast(componentsByType.get(type));
	}
	

	public <T extends Behavior> boolean hasBehavior(Class<T> type) 
	{
		return componentsByType.containsKey(type);
	}
	
	public Bag<Behavior> getBehaviors() 
	{
		return behaviors;
	}
	
	private ImmutableBag<IMessageReceiver> getMessageHandler(IMessage<?> messageType)
	{
		if(handlersByEventType == null)
			return null;		
		return handlersByEventType.get(messageType);		 
	}

}