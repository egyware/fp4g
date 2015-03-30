package com.apollo.managers;

import java.util.HashMap;

import com.apollo.Entity;
import com.apollo.messages.EntityAddedMessage;
import com.apollo.messages.EntityRemovedMessage;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;
import com.egysoft.gdx.assets.Spawn;
import com.egysoft.gdx.assets.Spawner;

public class EntityManager extends Manager
{
	private final HashMap<Long, Entity> entitiesById;
	private final Bag<Entity> entities;
	private long freeId;
		
	public EntityManager()
	{
		entities = new Bag<Entity>();
		entitiesById = new HashMap<Long, Entity>();
	}

	
	public ImmutableBag<Entity> getEntities() 
	{
		return entities;
	}

	@Override
	public void added(Entity entity)
	{
		long next = ++freeId;
		entity.setId(next);
		entitiesById.put(next, entity);
		entities.add(entity);
		
		//TODO pooled message
		EntityAddedMessage message = new EntityAddedMessage();
		message.entity = entity;
		engine.onMessage(this, message);
	}
	
	@Override
	public void removed(Entity entity)
	{
		long id = entity.getId();
		entitiesById.remove(id);
		entities.remove(entity);
		//TODO pooled message
		EntityRemovedMessage message = new EntityRemovedMessage();
		message.entity = entity;
		engine.onMessage(this, message);
	}

	@Override
	public void update(float delta)
	{		
		for (int i = 0, s = entities.size(); s > i; i++) 
		{
			Entity entity = entities.get(i);
			entity.update(delta);
		}
	}

	public Entity getEntityById(long id) 
	{
		return entitiesById.get(id);
	}


	public void setEntities(Spawner spawner)
	{
		//agregamos todas las entidades		
		for(Spawn spawn:spawner.entities)
		{
			Entity entity = engine.createEntity(spawn.entity, spawn.x, spawn.y, spawn.w, spawn.h, spawn.map);
			if(entity != null)
			{
				engine.addEntity(entity);
			}
		}		
	}
}
