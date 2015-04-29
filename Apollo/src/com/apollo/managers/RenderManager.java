package com.apollo.managers;

import java.util.regex.Pattern;

import com.apollo.Entity;
import com.apollo.behaviors.ActorBehavior;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;


public class RenderManager extends Manager 
{
	private static final String _TAG = "RENDER";
	private final Stage gameStage;
	private final com.badlogic.gdx.scenes.scene2d.Group layer;	
	private MapRenderer tiledMapRenderer;	
	private TiledMap tiledMap;
	protected OrthographicCamera camera;
	private CameraController cameraController;	
	private MapLayers bottomMapLayers;
	private MapLayers topMapLayers;
	
	static boolean debug;
	
	
	public RenderManager(Stage stage)
	{
		this.gameStage = stage;
		layer  = new com.badlogic.gdx.scenes.scene2d.Group();
		gameStage.addActor(layer);		
		camera = (OrthographicCamera) stage.getCamera();
	}
	
	private static final Pattern regex = Pattern.compile(" ");
	public void setStageMap(TiledMap map)
	{	
		tiledMap = map;
		tiledMapRenderer = new CustomTiledRenderer(tiledMap, gameStage.getBatch());
		bottomMapLayers = map.getLayers(); //valor inicial
		
		String cameraLayer = "camaras";
		//establecer propiedades
		final MapProperties properties = map.getProperties();
		//topLayer
		{
			final String value = (String)properties.get("top");
			if(value != null) setTopLayers(regex.split(value));
		}
		{
			final String value = (String)properties.get("bottom");
			if(value != null) setBottomLayers(regex.split(value));
		}		
		{
			final String value = (String)properties.get("camera-controller");
			if(value != null)
			{
				try 
				{
					Class<?> cameraControllerClass = ClassReflection.forName(value);
					setCameraController((CameraController) cameraControllerClass.newInstance());
				}
				catch (ReflectionException e) 
				{
					Gdx.app.log(_TAG, "Controllador de Camara no encontrado");
				}
				catch (InstantiationException e) 
				{
					Gdx.app.log(_TAG, "Controllador de Camara no se pudo inicializar");
				}
				catch (IllegalAccessException e) 
				{
					Gdx.app.log(_TAG, "Controllador de Camara no es accesible");
				}
			}
		}
		{
			final String value = (String)properties.get("camera-layer");
			if(value != null)
			{
				cameraLayer = value;
			}			
		}
		if(cameraController != null)
		{
			MapLayer layer = tiledMap.getLayers().get(cameraLayer);
			if(layer != null)
			{
				final MapObjects objects = layer.getObjects();
				for(MapObject a:objects)
				{
					if(a instanceof RectangleMapObject)
					{
						cameraController.addControlZone(((RectangleMapObject) a).getRectangle());						
					}
				}
				final String value = (String)properties.get("camera-first");
				if(value != null)
				{
					MapObject first = layer.getObjects().get(value);
					if(first != null && first instanceof RectangleMapObject)
					{
						cameraController.setCamera(((RectangleMapObject) first).getRectangle());
					}
					else
					{
						Gdx.app.log(_TAG, "Primera camara no encontrada o no compatible");
					}
				}
			}
			else
			{
				Gdx.app.log(_TAG, String.format("La capa de camaras \"%s\" especificada no existe", cameraLayer));
			}
		}
	}
	
	public void setCameraController(CameraController newInstance) 
	{
		cameraController = newInstance;
		cameraController.setRenderManager(this);		
	}

	public void setTopLayers(String ...values)
	{
		final MapLayers mapLayers = tiledMap.getLayers();
		topMapLayers = new MapLayers();			
		for(final String l:values)
		{
			MapLayer layer = mapLayers.get(l);
			if(layer != null)
			{
				topMapLayers.add(layer);
			}
		}
	}
	public void setBottomLayers(String ...values)
	{
		final MapLayers mapLayers = tiledMap.getLayers();
		bottomMapLayers = new MapLayers();			
		for(final String l:values)
		{
			MapLayer layer = mapLayers.get(l);
			if(layer != null)
			{
				topMapLayers.add(layer);
			}
		}
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
		gameStage.act(delta);
		if(cameraController != null) cameraController.update(delta);		
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
			for (MapLayer layer : bottomMapLayers) 
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
				}
			}
			endRender();
			gameStage.draw();
			if(topMapLayers != null)
			{
				beginRender();
				for (MapLayer layer : topMapLayers) 
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
					}
				}
				endRender();
			}
		}
		
		
	}
	
}