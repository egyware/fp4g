package com.apollo.scripting;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.LibFunction;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.EntityInstance;

import com.apollo.Engine;

public class EngineLib extends LibFunction 
{
	private final Engine engine;
	
	static
	{
		
		EntityInstance.install();
	}
	
	public EngineLib(final Engine e)
	{
		engine = e;
	}
	
	public LuaValue call(LuaValue modname, LuaValue env) 
	{				
		LuaValue library = tableOf();		
		library.set("getEntity", new OneArgFunction() 
		{
			@Override
			public LuaValue call(LuaValue value) 
			{
				if(!value.isnumber())
				{
					argerror(1, "Se esperaba un numero");					
				}
				long id = value.tolong();
				return CoerceJavaToLua.coerce(engine.getEntityById(id));
			}
		});	
		env.set( "Engine", library );
		return library;
	}
}
