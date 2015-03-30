package org.luaj.vm2.lib.jse;

import java.util.HashMap;

import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaUserdata;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion;

import com.apollo.Behavior;
import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.MessageReceiver;
import com.apollo.utils.Bag;

/**
 * LuaValue that represents a Java instance.
 * <p>
 * Will respond to get() and set() by returning field values or methods. 
 * <p>
 * This class is not used directly.  
 * It is returned by calls to {@link CoerceJavaToLua#coerce(Object)} 
 * when a subclass of Object is supplied.
 * @see CoerceJavaToLua
 * @see CoerceLuaToJava
 */
@SuppressWarnings("unchecked")
public class EntityInstance extends LuaUserdata 
{
	public static void install()
	{
		CoerceJavaToLua.COERCIONS.put(Entity.class, new Coercion() {
			public LuaValue coerce( final Object javaValue ) 
			{				
				return new EntityInstance((Entity) javaValue);
			} 
		});
	}
	
	private static HashMap<LuaValue, LuaFunction> methods;
	private HashMap<LuaValue, Behavior> behaviors;	
	
	EntityInstance(Entity instance) 
	{
		super(instance);
		
	}

	public LuaValue get(LuaValue key) 
	{
		Behavior behavior = getBehavior(key);
		if(behavior != null)
		{
			return CoerceJavaToLua.coerce(behavior);
		}
		LuaFunction method = getMethod(key);
		if(method != null)
		{
			return method;
		}
		return super.get(key);

	}

	private Behavior getBehavior(LuaValue key) 
	{
		if(behaviors == null)
		{
			final Entity entity = (Entity) m_instance;
			behaviors = new HashMap<LuaValue, Behavior>();		
			for(Behavior bhvr:entity.getBehaviors())
			{
				behaviors.put(LuaValue.valueOf(bhvr.getType().getSimpleName()), bhvr);
			}
		}
		return behaviors.get(key);
	}
	
	private static LuaFunction getMethod(LuaValue key)
	{
		if(methods == null)
		{
			methods = new HashMap<LuaValue, LuaFunction>();
			methods.put(LuaValue.valueOf("addMessageHandler"), new ThreeArgFunction(){

				@Override
				public LuaValue call(LuaValue arg1, LuaValue arg2, LuaValue arg3) 
				{
					Entity entity                 = (Entity)arg1.checkuserdata(Entity.class);
					Class<? extends Message> type = (Class<? extends Message>)arg2.checkuserdata(Message.class);
					LuaFunction function          = arg3.checkfunction();
					
					//como chucha creo una instancia de la clase handler del mensaje
					//1.- No tengo referencia de la clase handler del mensaje
					//2.- Si la tuviese, no puedo crear herencias de esa clase al vuelo.
					//3.- Podria acceder a utilizar un adaptador, por cada clase. Uff que flojera.
					//4.- [29-03-2015] Se cambio el sistema de mensajes asi que ahora puede ser implementado sin problemas
					
					entity.addMessageHandler(type, new MessageReceiverLuaAdapter(function));
					
					return LuaValue.NONE; //void
				}
				
			});
			methods.put(LuaValue.valueOf("removeMessageHandler"), new ThreeArgFunction(){

				@Override
				public LuaValue call(LuaValue arg1, LuaValue arg2, LuaValue arg3) 
				{
					Entity entity                 = (Entity)arg1.checkuserdata(Entity.class);
					Class<? extends Message> type = (Class<? extends Message>)arg2.checkuserdata(Message.class);
					LuaFunction function          = arg3.checkfunction();
					
					//como borro un handler?
					//simple, una busqueda simple
					MessageReceiver finded = null;
					Bag<MessageReceiver> bag = entity.getAllEventHandlers().get(type);
					if(bag != null)
					{
						for(MessageReceiver r:bag)
						{
							if(r instanceof MessageReceiverLuaAdapter)
							{
								if(((MessageReceiverLuaAdapter) r).function == function)
								{
									finded = r;
									break;
								}
							}
						}
						if(finded != null)
							bag.remove(finded); //tengo los datos directos, asi que puedo borrarlo directamente de su propia bolsa
					}
					return LuaValue.NONE; //void
				}				
			});			
			
		}
		return null;
	}

	public void set(LuaValue key, LuaValue value) 
	{
		Behavior behavior = getBehavior(key);
		if(behavior != null)
		{
			error(String.format("No puede establecer el valor %s a %s",value.toString(), key.toString()));
		}		
		super.set(key, value);
	} 	
	
}
