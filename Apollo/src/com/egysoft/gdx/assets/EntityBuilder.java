package com.egysoft.gdx.assets;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

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
	public Prototype prototype;
	
	public Entity buildEntity(final Engine engine, final int x, final int y, final int w, final int h,final ObjectMap<String, Object> map)
	{
		Entity entity = new Entity(engine, behaviors.length);
		for(BehaviorTemplate template:behaviors)
		{
			Behavior behavior = template.createBehavior(engine,x,y,w,h,map);
			entity.setBehavior(behavior);
		}
		//instalar el script
		if(prototype != null)
		{
			Globals _G = engine.getGlobals();
			LuaValue entityScript = _G.get(name);
			if(entityScript == LuaValue.NIL)
			{
				LuaClosure closure = new LuaClosure(prototype, engine.getGlobals());
				closure.call(); //instala el script
				entityScript = _G.get(name); //ahora debe existir
			}
			entityScript.get("OnCreate").invoke(new LuaValue[]{entityScript, CoerceJavaToLua.coerce(entity), LuaValue.valueOf(x), LuaValue.valueOf(y)});
		}		
		
		return entity;
	}
	
	public String getEntityBuilderName()
	{
		return name;
	}

}