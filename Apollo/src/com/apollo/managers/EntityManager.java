package com.apollo.managers;

import java.util.HashMap;

import com.apollo.Entity;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

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
	}
	
	@Override
	public void removed(Entity entity)
	{
		long id = entity.getId();
		entitiesById.remove(id);				
		entities.remove(entity);		
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
}
