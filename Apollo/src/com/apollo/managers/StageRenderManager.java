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
	private final com.badlogic.gdx.scenes.scene2d.Group backgroundLayer;
	private final com.badlogic.gdx.scenes.scene2d.Group actorLayer;
	private final com.badlogic.gdx.scenes.scene2d.Group frontLayer;
	private OrthographicCamera camera;	
	private Map map;
	private MapRenderer mapRenderer;
	private final int back_layers[] = {0,1};
    private final int front_layers[] = {2,3};
	private StageRenderManager(Stage stage)
	{
		this.stage = stage;
		backgroundLayer = new com.badlogic.gdx.scenes.scene2d.Group();
		actorLayer  = new com.badlogic.gdx.scenes.scene2d.Group();
		frontLayer  = new com.badlogic.gdx.scenes.scene2d.Group();
		stage.addActor(backgroundLayer);
		stage.addActor(actorLayer);
		stage.addActor(frontLayer);
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
		this.mapRenderer = new OrthogonalTiledMapRenderer(map,batch); //asumiré que es Tiled (y lo será por mucho tiempo)		
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
			actorLayer.addActor(ab);
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
		if(map == null) //solo uso un jump y pero a costo de agregar unas cuentas lineas de codigo :P
		{		
			stage.act(delta);
			stage.draw();
		}
		else
		{
			
			stage.act(delta);
			camera.update();
			mapRenderer.setView(camera);			
			mapRenderer.render(back_layers);
			stage.draw();			
			mapRenderer.render(front_layers);
		}
	}	
	
	public Camera getCamera()
	{
		return camera;
	}	
}
