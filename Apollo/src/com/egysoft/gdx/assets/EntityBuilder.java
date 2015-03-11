package com.egysoft.gdx.assets;

import com.apollo.Behavior;
import com.apollo.BehaviorTemplate;
import com.apollo.Engine;
import com.apollo.Entity;
import com.apollo.IEntityBuilder;
import com.badlogic.gdx.utils.ObjectMap;


public class EntityBuilder implements IEntityBuilder
{
	public String name;
	public BehaviorTemplate behaviors[];
	
	
	public Entity buildEntity(final Engine engine, final int x, final int y, final int w, final int h,final ObjectMap<String, Object> map)
	{
		Entity entity = new Entity(engine, behaviors.length);
		for(BehaviorTemplate template:behaviors)
		{
			Behavior behavior = template.createBehavior(engine,x,y,w,h,map);
			entity.setBehavior(behavior);
		}		
		
		return entity;
	}
	
	public String getEntityBuilderName()
	{
		return name;
	}

	@Override
	@SuppressWarnings("unchecked")	
	public Entity buildEntity(Engine engine, Object... args) 
	{
		return buildEntity(engine, (Integer)args[0], (Integer)args[1], (Integer)args[2], (Integer)args[3], (ObjectMap<String, Object>)args[4]);
	}

}