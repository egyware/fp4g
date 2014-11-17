package com.egysoft.gdx;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;
import com.egysoft.gdx.assets.EntitySpawn;
import com.egysoft.gdx.assets.EntitySpawnLoader;
import com.egysoft.gdx.assets.Sprite;
import com.egysoft.gdx.assets.SpriteLoader;
import com.egysoft.gdx.assets.Terrain;
import com.egysoft.gdx.assets.TerrainLoader;
import com.egysoft.utils.StringUtils;

public abstract class Game implements ApplicationListener, InputProcessor
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
	private final Array<GameState> states;
	
	public abstract int getWidth();
	public abstract int getHeight();
	
	public final AssetManager assets; 
	
	public Game()
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
		Gdx.app.log("GameCycleLife", StringUtils.format("start: {0}",next.getClass().getSimpleName()));
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
		Gdx.app.log("GameCycleLife", StringUtils.format("next: {0}",_next.getClass().getSimpleName()));
		next = _next;
	}
	
	/**
	 * Pausa el actual contexto y le da prioridad a este
	 * @param next
	 */
	public void pauseState(GameState next)
	{
		Gdx.app.log("GameCycleLife", StringUtils.format("pause: {0}",next.getClass().getSimpleName()));
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
		Gdx.app.log("GameCycleLife", "resume");
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
	public void create() 
	{
		Game.init(this);
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
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}
}
