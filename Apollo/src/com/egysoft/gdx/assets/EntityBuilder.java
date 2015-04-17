package com.egysoft.gdx.assets;

import com.apollo.Behavior;
import com.apollo.BehaviorTemplate;
import com.apollo.Engine;
import com.apollo.Entity;
import com.apollo.IEntityBuilder;
import com.badlogic.gdx.utils.ObjectMap;

/**
 * Clase encargada de crear entidades.
 * 
 * Esta clase se encarga de guardar los datos provinientes de un archivo json.
 * @author Edgardo
 *
 */
public class EntityBuilder implements IEntityBuilder
{
	public static class DefaultValue 
	{
		public int x;
		public int y;
		public int w;
		public int h;
		public ObjectMap<String, Object> parameters;
	}

	public String name;
	public BehaviorTemplate behaviors[];
	public DefaultValue defaultValue;
	
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

}