package com.egysoft.gdx;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.reflect.ClassReflection;

public abstract class Game implements ApplicationListener
{
	private static final String TAG = "Game";
	private static final String COMMON_GROUP = "common";
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
	private final GameLoader loader;
	private InputMultiplexer multiplexer;
		
	public abstract int getWidth();
	public abstract int getHeight();
	
	public Preferences preferences;
	public final Assets assets;
	
	public Game(GameLoader loader, FileHandleResolver fileResolver)
	{
		assets = new Assets(fileResolver);			
		multiplexer = new InputMultiplexer();
		this.loader = loader;
	}
	public Game(GameLoader loader)
	{
		this(loader, new InternalFileHandleResolver());
	}
	public Game()
	{
		this(new GameLoader(), new InternalFileHandleResolver());
	}
	public Game(FileHandleResolver fileResolver)
	{
		this(new GameLoader(), fileResolver);
	}
	
	public void start(GameState state)
	{
		Gdx.app.log(TAG, String.format("start %s",ClassReflection.getSimpleName(state.getClass())));
		current = state;
		if(current.groupName == null) throw new GdxRuntimeException("El nombre de los grupos no puede ser null");
		assets.loadGroup(current.groupName);
		assets.finishLoading();
		current.create();
	}
	
	protected void switchGameState(GameState next)
	{
		current = next;
	}
	
	public void nextState(GameState next)
	{
		Gdx.app.log(TAG, String.format("next: %s",ClassReflection.getSimpleName(next.getClass())));
		this.next = next;
	}

	@Override
	public void create() 
	{
		Game.init(this);
		assets.loadGroups("assets.json");		
		if(assets.containsGroup(COMMON_GROUP)) assets.loadGroup(COMMON_GROUP);
		loader.create();
		preferences = Gdx.app.getPreferences("Game");		
		Gdx.input.setInputProcessor(multiplexer);
		Gdx.app.setLogLevel(Application.LOG_INFO);
		Gdx.app.log(TAG, "create");		
	}

	@Override
	public void dispose() {	
		Gdx.app.log(TAG, "dispose");	
		if(current != null)
		{
			current.dispose();			
		}
		loader.dispose();
	}
	
	
	public void resumeState()
	{
		Gdx.app.log(TAG, "resume");
		if(current != null)
		{
			current.resume();
		}		
	}

	@Override
	public void pause()
	{	
		Gdx.app.log(TAG, "pause");	
		if(current != null)
		{
			current.pause();			
		}
	}

	@Override
	public void render() 
	{		
		float deltaTime = Gdx.graphics.getDeltaTime();		
		
		if (current != null) 
		{
			current.render(deltaTime);
		}
		//hay un siguiente nivel a cargar
		if(next != null)
		{
			assets.unloadGroup(current.groupName);
			current.dispose();
			current = loader;
			loader.load(next);
			next = null;
		}
	}

	@Override
	public void resize(int w,int h) 
	{
		Gdx.app.log(TAG, "resize");
		if(current != null)
		{
			current.resize(w,h);
		}
	}

	@Override
	public void resume() 
	{
		Gdx.app.log(TAG, "resume");
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
