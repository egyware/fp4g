package com.teamnayn.ceditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.GroundActor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.egysoft.gdx.Assets;
import com.egysoft.gdx.Game;
import com.egysoft.gdx.GameState;

public class Editor extends GameState
implements InputProcessor
{
	private Stage hud;
	private Stage scene;
	public Editor(String groupName) 
	{
		super(groupName);	
	}
	
	@Override
	protected void create() 
	{
		final Assets assets = Game.instance.assets;
		final int w = Game.Width, h = Game.Height;
		assets.loadGroup(groupName);
		
		assets.finishLoading();
		
		hud = new Stage(new FitViewport(w,h));
		scene = new Stage(new FitViewport(w,h));
		
		TextureAtlas groundAtlas = assets.get("assets/ground.atlas");
		Array<TextureAtlas.AtlasRegion> r = groundAtlas.findRegions("gray");
		Array<TextureRegion> regions = new Array<TextureRegion>(r.size);
		
		for(TextureAtlas.AtlasRegion region:r)
		{
			regions.add(region);
		}
		GroundActor ground = new GroundActor(regions,10,10,10,10);
		ground.setPosition(100, 500);
		
		scene.addActor(ground);	
		
		
		Game.instance.addInputProcessor(hud,scene,this);
	}

	@Override
	protected void dispose() 
	{
		final Assets assets = Game.instance.assets;
		assets.unloadGroup(groupName);
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
	}

	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
		
		scene.act(delta);
		scene.draw();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) 
	{
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}	
}
