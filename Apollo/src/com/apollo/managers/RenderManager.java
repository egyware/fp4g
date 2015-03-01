package com.apollo.managers;

import java.util.Iterator;
import java.util.regex.Pattern;

import com.apollo.Entity;
import com.apollo.behaviors.ActorBehavior;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Method;
import com.badlogic.gdx.utils.reflect.ReflectionException;


public class RenderManager extends Manager 
{
	private final Stage stage;
	private final com.badlogic.gdx.scenes.scene2d.Group layer;	
	private MapRenderer tiledMapRenderer;	
	private TiledMap tiledMap;
	protected OrthographicCamera camera;
		
	private MapLayers tiledMapLayers;
	private MapLayer actorsLayer;
	
	static boolean debug;
	
	
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
	
	private static final Pattern regex = Pattern.compile(" ");
	public void setStageMap(TiledMap map)
	{	
		tiledMap = map;
		tiledMapRenderer = new CustomTiledRenderer(tiledMap, stage.getBatch());
		tiledMapLayers = map.getLayers(); //valor inicial
		
		//establecer propiedades
		final MapProperties properties = map.getProperties();
		for(final Iterator<String> it = properties.getKeys();it.hasNext();)
		{
			final String key = it.next();
			final Object value = properties.get(key);
			try 
			{
				Method method = ClassReflection.getDeclaredMethod(getClass(), String.format("set%c%s",Character.toUpperCase(key.charAt(0)),key.substring(1)), value.getClass());
				method.invoke(this, value);
			}
			catch (ReflectionException e) 
			{
				Gdx.app.log("RenderManager", String.format("Propiedad %s no encontrada", key));
			}		
		}		
	}
	
	public void setActors(String value)
	{
		actorsLayer = tiledMap.getLayers().get(value); 
	}
	
	public void setLayers(String ...values)
	{
		final MapLayers mapLayers = tiledMap.getLayers();
		tiledMapLayers = new MapLayers();			
		for(final String l:values)
		{
			MapLayer layer = mapLayers.get(l);
			if(layer != null)
			{
				tiledMapLayers.add(layer);
			}
		}
	}
	
	public void setLayers(String value)
	{
		final String layers[] = regex.split(value);
		setLayers(layers);
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
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
	}	
	
	public Camera getCamera()
	{
		return camera;
	}
	
	
	public class CustomTiledRenderer extends OrthogonalTiledMapRenderer 
	{

		public CustomTiledRenderer(TiledMap map, Batch batch)
		{
			super(map,batch);		
		}
		
		public void render()
		{
			beginRender();			
			for (MapLayer layer : tiledMapLayers) 
			{			
				if (layer.isVisible()) 
				{					
					if (layer instanceof TiledMapTileLayer) 
					{
						renderTileLayer((TiledMapTileLayer)layer);
					}					
					if (layer instanceof TiledMapImageLayer) 
					{
						renderImageLayer((TiledMapImageLayer)layer);
					}
					else
					if(debug)
					{
						renderObjects(layer);
					}
					if(layer == actorsLayer)
					{
						endRender();
						stage.draw();
						beginRender();
					}
				}
			}			
			endRender();
			if(actorsLayer == null)
			{
				stage.draw();
			}
		}
		
		
	}
	
}