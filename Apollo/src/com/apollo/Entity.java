package com.apollo;

import java.util.HashMap;
import java.util.Map;

import com.apollo.annotate.ComponentInjector;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

public abstract class Entity implements MessageSender
{
	protected final Engine engine;
	private Map<Message<?>,Bag<MessageReciever>> handlersByEventType;	
	private boolean deleted;

	public Entity(Engine engine) {
		this.engine = engine;
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
	public Map<Message<?>, Bag<MessageReciever>> getAllEventHandlers() {
		return handlersByEventType;
	}
	
	/**
	 * 
	 * @param messageType Class of Message Type
	 * @param listener
	 */	
	public <T extends Message<?>> void addEventHandler(Message<?> messageType, MessageReciever listener) {
		if(handlersByEventType == null)
			handlersByEventType = new HashMap<Message<?>,Bag<MessageReciever>>();
		
		Bag<MessageReciever> listeners = handlersByEventType.get(messageType);
		if(listeners == null) {
			listeners = new Bag<MessageReciever>();
			handlersByEventType.put(messageType,listeners);
		}
		listeners.add(listener);
	}
	
	public ImmutableBag<MessageReciever> getMessageHandler(Message<?> messageType)
	{
		if(handlersByEventType == null)
			return null;		
		return handlersByEventType.get(messageType);		 
	}
	
	/**
	  * Caso general de envio de mensajes.
	  * @param message Mensaje a enviar.
	  * @param args Argumentos del mensaje.
	  */
	@Override
	public void onMessage(Message<? extends MessageReciever> message, Object... args) 
	{		
		ImmutableBag<MessageReciever> listeners = getMessageHandler(message);
		if(listeners != null)
		{
			final int size = listeners.size();
			for(int i=0; i<size; i++)
			{
				MessageReciever handler = listeners.get(i);
				handler.onMessage(message, args);						
			}
		}
	}
	
	/**
	 * 
	 */	
	public <T extends Message<?>> void removeEventHandler(Message<?> messagetType, MessageReciever listener) {
		if(handlersByEventType == null)
		{
			return;
		}		
		Bag<MessageReciever> listeners = handlersByEventType.get(messagetType);
		if(listeners == null) {
			return;
		}
		listeners.remove(listener);
	}

	public abstract 
	ImmutableBag<Behavior> getBehaviors();

	public abstract <T extends Behavior>  
	T getBehavior(Class<T> type);

	public abstract 
	void update(float delta);

	protected void uninitialize()
	{
		handlersByEventType.clear();
	}

	protected abstract
	void initialize();


	public void applyComponentAnnotations() 
	{
		for (Behavior component : getBehaviors()) 
		{
			ComponentInjector.applyAnnotations(component);
		}		
	}
}