package com.apollo.managers;

import com.apollo.Entity;
import com.apollo.behaviors.ActorBehavior;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class RenderManager extends Manager 
{
	private final Stage stage;
	private final com.badlogic.gdx.scenes.scene2d.Group layer;
	private Map map;
	private MapRenderer mapRenderer;	
	protected OrthographicCamera camera;
	
	public RenderManager(Stage stage)
	{
		this.stage = stage;		
		layer  = new com.badlogic.gdx.scenes.scene2d.Group();
		stage.addActor(layer);		
		camera = (OrthographicCamera) stage.getCamera();
	}
	public RenderManager()
	{
		this(new Stage());
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