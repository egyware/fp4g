package com.apollo;

import com.apollo.managers.entity.EntitySpawn;
import com.apollo.managers.entity.EntitySpawnLoader;
import com.apollo.managers.graphics.Sprite;
import com.apollo.managers.graphics.SpriteLoader;
import com.apollo.managers.physics.Terrain;
import com.apollo.managers.physics.TerrainLoader;
import com.apollo.messages.LevelMessageHandler;
import com.apollo.utils.ImmutableBag;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;

public abstract class GameManager implements ApplicationListener, MessageReceiver, LevelMessageHandler
{
	private GameState next;
	private GameState current;
	private final Array<GameState> states;
	
	public abstract int getWidth();
	public abstract int getHeight();
	
	public final AssetManager assets; 
	
	public GameManager()
	{
		states = new Array<GameState>();
		
		final InternalFileHandleResolver fileResolver = new InternalFileHandleResolver();
		assets = new AssetManager();		
		assets.setLoader(Sprite.class,new SpriteLoader(fileResolver));
		assets.setLoader(TiledMap.class,new TmxMapLoader(fileResolver));
		assets.setLoader(Terrain.class,new TerrainLoader(fileResolver));
		assets.setLoader(EntitySpawn.class,new EntitySpawnLoader(fileResolver));
	}
	
	public void start(GameState next)
	{
		this.next = null;
		Gdx.app.log("GameCycleLife", String.format("start: %s",next.getClass().getSimpleName()));
		current = states.size > 0?states.peek():null;
		if(current != null)
		{
			current.exit();
			if(current.isLoad())
			{
				current.unloadState();
			}
			states.pop();
		}	
		current = next;
		if(!current.isLoad())
		{
			boolean result = current.load();
			if(result)
			{
				current.setLoad(true);
			}
			else
			{
				//TODO [egyware] error, de que? no se que...
			}
		}
		current.enter();
		states.add(current);
	}
	
	public void nextState(GameState _next)
	{
		Gdx.app.log("GameCycleLife", String.format("next: %s",_next.getClass().getSimpleName()));
		next = _next;
	}
	
	/**
	 * Pausa el actual contexto y le da prioridad a este
	 * @param next
	 */
	public void pauseState(GameState next)
	{
		Gdx.app.log("GameCycleLife", String.format("pause: %s",next.getClass().getSimpleName()));
		//se asume que existe un contexto actual y guardado en  states...
		if(current != null)
		{
			current.pause();
		}
		current = next;
		if(!current.isLoad())
		{
			boolean result = current.load();
			if(result)
			{
				current.setLoad(true);
			}
			else
			{
				//TODO error
			}
		}
		current.enter();
		states.add(current);	
	}
	
	public void resumeState()
	{
		Gdx.app.log("GameCycleLife", String.format("resume"));
		//se asume que existe un contexto actual y guardado en  states...
		if(current != null)
		{
			current.exit();
			current.unloadState();
			states.pop(); //retiro
		}		
		current = states.size > 0?states.peek():null;
		if(current != null)
		{
			current.resume();
		}		
	}

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_INFO);
		Gdx.app.log("AppCycleLife", "create");
	}

	@Override
	public void dispose() {	
		Gdx.app.log("AppCycleLife", "dispose");	
		if(current != null)
		{
			current.exit();
			current.unloadState();
		}
		//TODO [egyware] revisar si existen más estados cargados

	}

	@Override
	public void pause() {	
		Gdx.app.log("AppCycleLife", "pause");	
		if(current != null)
		{
			current.pause();			
		}
	}

	@Override
	public void render() {		
		if(current != null)
		{			
			current.update(Gdx.graphics.getDeltaTime());			
		}
		if(next != null)
		{
			start(next);			
		}

	}

	@Override
	public void resize(int x,int y) 
	{
		Gdx.app.log("AppCycleLife", "resize");
	}

	@Override
	public void resume() 
	{
		Gdx.app.log("AppCycleLife", "resume");
		if(current != null)
		{
			current.resume();			
		}
	}

	
	@Override
	public ImmutableBag<MessageHandler> getMessageHandler(Message<?> message) 
	{		
		return null;
	}

	@Override
	public void onMessage(Message<? extends MessageHandler> message,Object... args) 
	{
		//TODO por ahora solo aceptaré mensajes tipo LevelMessageHandler
		if(message.getClassHandler() == LevelMessageHandler.class)
		{
			message.dispatch(this, args);
		}
		else
		{
			Gdx.app.error("OnMessage", "No se puede recibir este mensaje");
		}
	}
}
