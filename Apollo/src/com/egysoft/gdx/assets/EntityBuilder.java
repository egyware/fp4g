package com.egysoft.gdx.assets;

import com.apollo.Behavior;
import com.apollo.BehaviorTemplate;
import com.apollo.Engine;
import com.apollo.Entity;
import com.apollo.IEntityBuilder;


public class EntityBuilder implements IEntityBuilder
{
	public String name;
	public BehaviorTemplate behaviors[];
	
	
	public Entity buildEntity(final Engine engine, final Object ...args)
	{
		Entity entity = new Entity(engine, behaviors.length);
		for(BehaviorTemplate template:behaviors)
		{
			Behavior behavior = template.createBehavior(engine);
			entity.setBehavior(behavior);
		}		
		
		return entity;
	}
	
	public String getEntityBuilderName()
	{
		return name;
	}

}