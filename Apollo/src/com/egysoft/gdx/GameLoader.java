package com.egysoft.gdx;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.egysoft.gdx.Assets;
import com.egysoft.gdx.Game;
import com.egysoft.gdx.GameState;

public class GameLoader extends GameState
{
	public GameLoader() 
	{
		super(null);
	}

	private Stage stage;
	private Assets assets;
	private GameState toLoad;
	
	public void load(GameState state)
	{
		toLoad = state;
	}	

	@Override
	protected void create() 
	{
		final Game instance = Game.instance;
		final int w = instance.getWidth(), h = instance.getHeight();
		stage = new Stage(new FitViewport(w,h));
		assets = instance.assets;			
	}

	@Override
	protected void dispose() 
	{
		stage.dispose();
		stage = null;
		assets = null;
	}

	@Override
	protected void pause() 
	{
	
	}

	@Override
	protected void resume()
	{		
	}

	@Override
	protected void resize(int w, int h) 
	{
		stage.getViewport().update(w, h);
	}

	@Override
	public void render(float delta) 
	{
		if(assets.update())
		{
			Game.instance.switchGameState(toLoad);
		}
		stage.act(delta);
		stage.draw();
	}

}
