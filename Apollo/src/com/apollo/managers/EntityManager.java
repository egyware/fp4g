package com.apollo.managers;

import com.apollo.Behavior;
import com.apollo.Entity;
import com.apollo.annotate.ComponentInjector;
import com.apollo.managers.entity.EntitySpawn;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

public class EntityManager extends Manager 
{
	private Bag<Entity> entities;
	private EntitySpawn spawner; 
		
	public EntityManager()
	{
		entities = new Bag<Entity>();		
	}
	
	public EntityManager(EntitySpawn spawner)
	{
		this();
		this.spawner = spawner;		
	}
	
	@Override
	public void initialize()
	{
		//agregamos todas las entidades		
		if(spawner != null)
		{
			for(int i=0; i < spawner.lenght; i++)
			{
				Entity entity = world.createEntity(spawner.entities[i], spawner.params[i]);
				if(entity != null)
				{
					world.addEntity(entity);
				}
			}
		}
	}
	
	public ImmutableBag<Entity> getEntities() 
	{
		return entities;
	}

	@Override
	public void added(Entity entity) {
		entities.add(entity);		
	}

	public void applyComponentAnnotations(Entity entity) {
		for (Behavior component : entity.getBehaviors()) 
		{
			ComponentInjector.applyAnnotations(component);
		}
	}

	@Override
	public void removed(Entity e) {
		entities.remove(e);		
	}

	@Override
	public void update(float delta) {		
		for (int i = 0, s = entities.size(); s > i; i++) {
			Entity entity = entities.get(i);
			entity.update(delta);
		}
	}
	
}
