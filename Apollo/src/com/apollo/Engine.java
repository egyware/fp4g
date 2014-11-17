package com.apollo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.apollo.managers.EntityManager;
import com.apollo.managers.Manager;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;
import com.egysoft.utils.StringUtils;

public class Engine implements MessageSender
{
	private Map<Message<?>,Bag<MessageReciever>> handlersByEventType;
	private EntityManager entityManager;
	
	private Bag<Entity> added;
	private Bag<Manager> addedManagers;
	private Bag<Entity> deleted;

	private Map<Class<? extends Manager>, Manager> managers;
	private Bag<Manager> managersBag;
	
	private Map<String,EntityBuilder> entityBuildersByType;
	
	public Engine() 
	{			
		addedManagers = new Bag<Manager>();
		added   = new Bag<Entity>();		
		deleted = new Bag<Entity>();
		
		managers = new LinkedHashMap<Class<? extends Manager>, Manager>();
		managersBag = new Bag<Manager>();	
		
		entityBuildersByType = new HashMap<String, EntityBuilder>();		
	}

	public EntityManager getEntityManager() 
	{
		return entityManager;
	}
		
	public void addEntity(Entity e) {
		added.add(e);
	}
	
	public void deleteEntity(Entity e) {
		if(!deleted.contains(e)) {
			deleted.add(e);
		}
	}

	public void setEntityManager(EntityManager manager)
	{
		if(manager == null)
		{
			throw new RuntimeException("EntityManager no puede ser null");
		}
		entityManager = manager;
		setManager(entityManager);		
	}
	public void setManager(Manager manager) {		
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
			throw new RuntimeException(StringUtils.format("{0} no puede ser null",managerType.getSimpleName()));
		}
		return (T) manager;
	}
	
	public void setEntityBuilder(String builderType, EntityBuilder entityBuilder) {
		entityBuildersByType.put(builderType, entityBuilder);
	}
	public void setEntityBuilder(EntityBuilder entityBuilder) {
		entityBuildersByType.put(entityBuilder.getEntityBuilderName(), entityBuilder);
	}

	
	public EntityBuilder getEntityBuilder(String builderType) {
		return entityBuildersByType.get(builderType);
	}
	
	public Entity createEntity(String builderType,Object ...args) {
		EntityBuilder entityBuilder = getEntityBuilder(builderType);
		if(entityBuilder != null) {
			return entityBuilder.buildEntity(this,args);
		}
		return null;
	}
	
	private void addEntities() {
		for(int i = 0; added.size() > i; i++) {
			Entity e = added.get(i);

			for(Manager mgr : managers.values()) {
				mgr.added(e);
			}
		}
		for(int i = 0; added.size() > i; i++) {
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
		for(int i = 0; deleted.size() > i; i++) {
			Entity e = deleted.get(i);
			
			for(Manager mgr : managersBag){
				mgr.removed(e);
			}
			
			e.uninitialize();
			
			e.setDeleted(true);
		}
		deleted.clear();
	}
	
	public void deleteAllEntities() {
		ImmutableBag<Entity> entities = entityManager.getEntities();
		deleted.addAll(entities);
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
	
	private Bag<MessageReciever> getMessageHandler(Message<?> messageType) 
	{
		if(handlersByEventType == null)	return null;		
		return handlersByEventType.get(messageType); 
	}
	
	public <T extends Message<?>> void removeEventHandler(Message<?> messagetType, MessageReciever listener) 
	{
		if(handlersByEventType != null)
		{				
			Bag<MessageReciever> listeners = getMessageHandler(messagetType);
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
}
