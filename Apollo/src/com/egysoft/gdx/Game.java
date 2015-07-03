package com.egysoft.gdx;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.utils.reflect.ClassReflection;

public abstract class Game implements ApplicationListener
{
	private static final String TAG = "Game";	
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
	
	public Preferences preferences;
	public final Assets assets;
	
	public Game(FileHandleResolver fileResolver)
	{
		assets = new Assets(fileResolver);			
		multiplexer = new InputMultiplexer();		
	}
	
	public void start(GameState state)
	{
		Gdx.app.log(TAG, String.format("start %s",ClassReflection.getSimpleName(state.getClass())));
		current = state;				
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
		preferences = Gdx.app.getPreferences("Game");		
		Gdx.input.setInputProcessor(multiplexer);
		Gdx.app.setLogLevel(Application.LOG_INFO);
		Gdx.app.log(TAG, "create");		
	}

	@Override
	public void dispose()
	{	
		Gdx.app.log(TAG, "dispose");	
		if(current != null)
		{
			current.dispose();			
		}		
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
			current.dispose();
			current = next;
			current.create();
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
	
	public void addInputProcessor(InputProcessor ...inputs) 
	{
		for(InputProcessor input:inputs)
		{
			multiplexer.addProcessor(input);
		}
	}
	
	public void removeInputProcessor(InputProcessor ...inputs) 
	{
		for(InputProcessor input:inputs)
		{
			multiplexer.removeProcessor(input);
		}
	}
}
