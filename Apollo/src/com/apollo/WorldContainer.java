package com.apollo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.apollo.managers.EntityManager;
import com.apollo.managers.GameManager;
import com.apollo.managers.Manager;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

public class WorldContainer 
{
	public static boolean DEBUG;
	
	private EntityManager entityManager;
	private final GameManager gameManager;

	private Bag<Entity> added;
	private Bag<Manager> addedManagers;
	private Bag<Entity> deleted;

	private Map<Class<? extends Manager>, Manager> managers;
	private Bag<Manager> managersBag;
	
	private Map<String,EntityBuilder> entityBuildersByType;
	
	private final ApolloInputProcessor inputProcessor;

	public WorldContainer(GameManager game) {
		entityManager = new EntityManager();
		gameManager = game;
		
		addedManagers = new Bag<Manager>();
		added   = new Bag<Entity>();		
		deleted = new Bag<Entity>();
		
		managers = new LinkedHashMap<Class<? extends Manager>, Manager>();
		managersBag = new Bag<Manager>();
		setManager(entityManager);
		
		entityBuildersByType = new HashMap<String, EntityBuilder>();
		
		inputProcessor = new ApolloInputProcessor();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public GameManager getGameManager()
	{
		return gameManager;
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
		if(entityManager == null)
		{
			return;
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
	
	public <T extends Manager> T getManager(Class<T> managerType) {
		return managerType.cast(managers.get(managerType));
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
			entityManager.applyComponentAnnotations(e);
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
	
	public ApolloInputProcessor getInputProcessor()
	{
		return inputProcessor;
	}
	
	
}