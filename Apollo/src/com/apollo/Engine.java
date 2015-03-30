package com.apollo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

import com.apollo.managers.EntityManager;
import com.apollo.managers.Manager;
import com.apollo.messages.BeginContactMessage;
import com.apollo.scripting.EngineLib;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;
import com.badlogic.gdx.utils.ObjectMap;

public class Engine implements MessageSender
{
	private Map<Class<? extends Message>, Bag<MessageReceiver>> handlersByEventType;
	private EntityManager entityManager;
	private Globals globals;
	
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
		
		//TODO por mientras, mas adelante se filtrará el uso de esta api haciendolo mas exclusivo
		globals = JsePlatform.standardGlobals();
		globals.load(new EngineLib(this));	
		globals.set("Contact", CoerceJavaToLua.coerce(BeginContactMessage.class));
		globals.set("entity", CoerceJavaToLua.coerce(new Entity(this)));
	}
	
	public void runScript(String script)
	{
		LuaValue chunk = globals.load(script);
		LuaValue v = chunk.call();
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

	public IEntityBuilder getEntityBuilder(final String builderType)
	{
		return entityBuildersByType.get(builderType);
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
	
	private Bag<MessageReceiver> getMessageHandler(Class<? extends Message> type) 
	{
		if(handlersByEventType == null)	return null;		
		return handlersByEventType.get(type); 
	}
	
	public void removeMessageHandler(Class<? extends Message> type, MessageReceiver listener) 
	{
		if(handlersByEventType != null)
		{				
			Bag<MessageReceiver> listeners = getMessageHandler(type);
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
	public void addMessageHandler(Class<? extends Message> type, MessageReceiver listener) 
	{
		if(handlersByEventType == null)
			handlersByEventType = new HashMap<Class<? extends Message>,Bag<MessageReceiver>>();
		
		Bag<MessageReceiver> listeners = handlersByEventType.get(type);
		if(listeners == null) 
		{
			listeners = new Bag<MessageReceiver>();
			handlersByEventType.put(type, listeners);
		}
		listeners.add(listener);
	}

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
	
	public ImmutableBag<Entity> getEntities()
	{
		return entityManager.getEntities();
	}
	
	public Entity getEntityById(long id) 
	{
		return entityManager.getEntityById(id);
	}
	
	public Entity createEntity(final String entity, final int x, final int y, final int w, final int h) 
	{
		IEntityBuilder builder = getEntityBuilder(entity);
		if(builder != null)
		{
			return builder.buildEntity(this, x, y, w, h, null);
		}
		else
		{
			return null;
		}
	}

	public Entity createEntity(final String entity, final int x, final int y) 
	{
		IEntityBuilder builder = getEntityBuilder(entity);
		if(builder != null)
		{
			return builder.buildEntity(this, x, y, 0, 0, null);
		}
		else
		{
			return null;
		}
	}

	public Entity createEntity(final String entity, final int x, final int y, final int w, final int h,final ObjectMap<String, Object> map) 
	{
		IEntityBuilder builder = getEntityBuilder(entity);
		if(builder != null)
		{
			return builder.buildEntity(this, x, y, w, h, map);
		}
		else
		{
			return null;
		}
	}

}
