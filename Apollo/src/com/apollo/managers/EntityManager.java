package com.apollo.managers;

import com.apollo.Entity;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;
import com.egysoft.gdx.assets.EntitySpawn;

public class EntityManager extends Manager 
{
	private final Bag<Entity> entities;	
		
	public EntityManager()
	{
		entities = new Bag<Entity>();		
	}
	
	public void setEntities(EntitySpawn spawner)
	{
		//agregamos todas las entidades		
		for(int i=0; i < spawner.lenght; i++)
		{
			Entity entity = world.createEntity(spawner.entities[i], spawner.params[i]);
			if(entity != null)
			{
				world.addEntity(entity);
			}
		}		
	}
	
	public ImmutableBag<Entity> getEntities() 
	{
		return entities;
	}

	@Override
	public void added(Entity entity) 
	{
		entities.add(entity);
	}
	
	@Override
	public void removed(Entity entity) 
	{
		entities.remove(entity);
	}

	@Override
	public void update(float delta) {		
		for (int i = 0, s = entities.size(); s > i; i++) {
			Entity entity = entities.get(i);
			entity.update(delta);
		}
	}
}
