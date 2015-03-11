package com.apollo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.apollo.managers.EntityManager;
import com.apollo.managers.Manager;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

public class Engine implements IMessageSender
{
	private Map<IMessage<?>,Bag<IMessageReceiver>> handlersByEventType;
	private EntityManager entityManager;
	
	private final Bag<Entity> added;
	private final Bag<Manager> addedManagers;
	private final Bag<Entity> deleted;
	
	private Map<Class<? extends Manager>, Manager> managers;
	private Bag<Manager> managersBag;
	
	private Map<String,IEntityBuilder> entityBuildersByType;
	
	public Engine() 
	{			
		addedManagers = new Bag<Manager>();
		added    = new Bag<Entity>();		
		deleted  = new Bag<Entity>();
				
		managers = new LinkedHashMap<Class<? extends Manager>, Manager>();
		managersBag = new Bag<Manager>();	
		
		entityBuildersByType = new HashMap<String, IEntityBuilder>();		
	}

	public void addEntity(Entity e) 
	{
		added.add(e);
	}
	
	public void deleteEntity(Entity e) 
	{
		if(!deleted.contains(e)) 
		{
			deleted.add(e);
		}
	}
	
	public void setEntityManager(EntityManager manager)
	{
		entityManager = manager;
		setManager(manager);
	}
	
	public void setManager(Manager manager) 
	{		
		managers.put(manager.getClass(), manager);
		managersBag.add(manager);
		addedManagers.add(manager);
		manager.setWorldContainer(this);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Manager> T getManager(Class<T> managerType) 
	{
		final Manager manager = managers.get(managerType);
		if(manager == null)
		{
			throw new RuntimeException(String.format("%s no puede ser null",managerType.getSimpleName()));
		}
		return (T) manager;
	}
	
	public void setEntityBuilder(String builderType, IEntityBuilder entityBuilder) {
		entityBuildersByType.put(builderType, entityBuilder);
	}
	public void setEntityBuilder(IEntityBuilder entityBuilder) {
		entityBuildersByType.put(entityBuilder.getEntityBuilderName(), entityBuilder);
	}

	
	@SuppressWarnings("unchecked")
	public <T extends IEntityBuilder> T  getEntityBuilder(final String builderType)
	{
		return (T)entityBuildersByType.get(builderType);
	}
	
	private void addEntities() {
		final int size = added.size();
		for(int i = 0;  size > i; i++) 
		{
			Entity e = added.get(i);

			for(Manager mgr : managers.values()) 
			{
				mgr.added(e);
			}	
			
		}
		for(int i = 0; size > i; i++) 
		{
			Entity e = added.get(i);
			e.applyComponentAnnotations();
			e.initialize();
		}
		added.clear();		
	}
	
	private void initManagers() {
		for(Manager manager : addedManagers) {
			manager.applyAnnotations();
			manager.initialize();
		}
		addedManagers.clear();
	}

	private void deleteEntities() {
		for(int i = 0; deleted.size() > i; i++) 
		{
			Entity e = deleted.get(i);
			
			for(Manager mgr : managersBag)
			{
				mgr.removed(e);
			}
				
			e.uninitialize();
					
			e.setDeleted(true);			
		}
		deleted.clear();
	}
	
	public void deleteAllEntities()
	{
		deleteEntities();
	}
	
	public void update(float delta) {
		if(!addedManagers.isEmpty()) {
			initManagers();
		}
		
		if(!deleted.isEmpty()) {
			deleteEntities();
		}
		
		if(!added.isEmpty()) {
			addEntities();
		}

	}	
	
	private Bag<IMessageReceiver> getMessageHandler(IMessage<?> messageType) 
	{
		if(handlersByEventType == null)	return null;		
		return handlersByEventType.get(messageType); 
	}
	
	public <T extends IMessage<?>> void removeMessageHandler(IMessage<?> messagetType, IMessageReceiver listener) 
	{
		if(handlersByEventType != null)
		{				
			Bag<IMessageReceiver> listeners = getMessageHandler(messagetType);
			if(listeners != null) 
			{				
				listeners.remove(listener);
			}
		}
	}
	/**
	 * 
	 * @param messageType Class of Message Type
	 * @param listener
	 */	
	public <T extends IMessage<?>> void addMessageHandler(IMessage<?> messageType, IMessageReceiver listener) {
		if(handlersByEventType == null)
			handlersByEventType = new HashMap<IMessage<?>,Bag<IMessageReceiver>>();
		
		Bag<IMessageReceiver> listeners = handlersByEventType.get(messageType);
		if(listeners == null) {
			listeners = new Bag<IMessageReceiver>();
			handlersByEventType.put(messageType,listeners);
		}
		listeners.add(listener);
	}

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
	
	public ImmutableBag<Entity> getEntities()
	{
		return entityManager.getEntities();
	}
}
