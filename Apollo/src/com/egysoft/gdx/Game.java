package com.egysoft.gdx;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.egysoft.gdx.assets.Ground;
import com.egysoft.gdx.assets.GroundTiledLoader;
import com.egysoft.gdx.assets.Spawner;
import com.egysoft.gdx.assets.SpawnerTiledLoader;
import com.egysoft.gdx.assets.Sprite;
import com.egysoft.gdx.assets.SpriteLoader;
import com.egysoft.utils.StringUtils;

public abstract class Game implements ApplicationListener
{
	public static Game instance;	
	public static int Width;
	public static int Height;
	
	public static void init(Game game)
	{
		Game.instance = game;		
		Width  = game.getWidth();
		Height = game.getHeight();
	}
	
	private GameState next;
	private GameState current;
	private InputMultiplexer multiplexer;
		
	public abstract int getWidth();
	public abstract int getHeight();
	
	public final AssetManager assets; 
	
	public Game()
	{
		final InternalFileHandleResolver fileResolver = new InternalFileHandleResolver();
		assets = new AssetManager();		
		assets.setLoader(Sprite.class,new SpriteLoader(fileResolver));
		assets.setLoader(TiledMap.class,new TmxMapLoader(fileResolver));
		assets.setLoader(Ground.class,new GroundTiledLoader(fileResolver));
		assets.setLoader(Spawner.class,new SpawnerTiledLoader(fileResolver));
		multiplexer = new InputMultiplexer();
	}
	
	public void start(GameState state)
	{
		next = state;
		performScreenChange();
	}
	
	public void performScreenChange()
	{
		Gdx.app.log("GameCycleLife", StringUtils.format("start {0}",next.getClass().getSimpleName()));		
		if(current != null)
		{
			current.dispose();			
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
				Gdx.app.log("GameCycleLife", StringUtils.format("No se pudo cargar {0}",current.getClass().getSimpleName()));
			}
		}
		this.next = null;
	}
	
	public void nextState(GameState _next)
	{
		Gdx.app.log("GameCycleLife", StringUtils.format("next: {0}",_next.getClass().getSimpleName()));
		next = _next;
	}
	
	public void resumeState()
	{
		Gdx.app.log("GameCycleLife", "resume");
		//se asume que existe un contexto actual y guardado en  states...
		if(current != null)
		{
			current.resume();
		}		
	}

	@Override
	public void create() 
	{
		Game.init(this);		
		Gdx.input.setInputProcessor(multiplexer);
		Gdx.app.setLogLevel(Application.LOG_INFO);
		Gdx.app.log("AppCycleLife", "create");
	}

	@Override
	public void dispose() {	
		Gdx.app.log("AppCycleLife", "dispose");	
		if(current != null)
		{
			current.dispose();			
		}
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
	public void render() 
	{		
		float deltaTime = Gdx.graphics.getDeltaTime();		
		
		if (current != null) {
			current.render(deltaTime);
		}
		
		if(next != null)
		{
			performScreenChange();			
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
	public InputMultiplexer getMultiplexer()
	{
		return  multiplexer;
	}
	
	public void addInputProcessor(InputProcessor input) 
	{
		multiplexer.addProcessor(input);
	}
	
	public void removeInputProcessor(InputProcessor input) 
	{
		multiplexer.removeProcessor(input);
	}
}
