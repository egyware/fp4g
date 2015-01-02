package com.apollo.managers;

import com.apollo.Entity;
import com.apollo.components.ActorBehavior;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;


public class StageRenderManager extends Manager 
{
	private final Stage stage;
	private final com.badlogic.gdx.scenes.scene2d.Group layer;	
	private OrthographicCamera camera;	
	private Map map;
	private MapRenderer mapRenderer;	
	private StageRenderManager(Stage stage)
	{
		this.stage = stage;		
		layer  = new com.badlogic.gdx.scenes.scene2d.Group();
		stage.addActor(layer);		
		camera = (OrthographicCamera) stage.getCamera();
	}
	public StageRenderManager()
	{
		this(new Stage());
	}
	public StageRenderManager(Viewport viewport, SpriteBatch batch)
	{
		this(new Stage(viewport, batch));		
	}
	public StageRenderManager(Viewport viewport, SpriteBatch batch, TiledMap map)
	{
		this(new Stage(viewport, batch));
		this.map = map;
		this.mapRenderer = new OrthogonalTiledMapRenderer(map,batch);
	}
	
	public void setStageMap(TiledMap map)
	{
		this.map = map;
		this.mapRenderer = new OrthogonalTiledMapRenderer(map, stage.getBatch());
	}
	
	public void added(Entity e) 
	{
		ActorBehavior ab = e.getBehavior(ActorBehavior.class);
		if(ab != null)
		{
			layer.addActor(ab);
		}
	}
	
	public void removed(Entity e)
	{
		ActorBehavior ab = e.getBehavior(ActorBehavior.class);
		if(ab != null)
		{
			ab.remove();
		}
	}
	
	public void update(float delta)
	{		
		stage.act(delta);
		camera.update();
		if(mapRenderer != null)
		{
			mapRenderer.setView(camera);			
			mapRenderer.render();
		}
		stage.draw();			
				
	}	
	
	public Map getMap()
	{
		return map;
	}
	
	public Camera getCamera()
	{
		return camera;
	}	
}
