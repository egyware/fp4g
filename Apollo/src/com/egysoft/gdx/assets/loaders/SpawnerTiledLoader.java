/**
 * 
 */
package com.egysoft.gdx.assets.loaders;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.egysoft.gdx.assets.Spawn;
import com.egysoft.gdx.assets.Spawner;

/**
 * @author egyware
 * 
 */
public class SpawnerTiledLoader extends SynchronousAssetLoader<Spawner, SpawnerTiledLoader.SpawnerTiledParameter> 
{
	public SpawnerTiledLoader(FileHandleResolver resolver) 
	{
		super(resolver);	
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, SpawnerTiledParameter parameter) 
	{
		Array<AssetDescriptor> deps = new Array<AssetDescriptor>();
		if (parameter == null) 
		{
			deps.add(new AssetDescriptor(file.pathWithoutExtension() + ".tmx", TiledMap.class));
		}
		else
		{
			deps.add(new AssetDescriptor(parameter.tiledMapPath, TiledMap.class));
		}
		return deps;
	}

	private static Pattern isBool = Pattern.compile("^([Tt]rue)|([Ff]alse)$");	
	@Override
	public Spawner load(AssetManager assetManager, String fileName, FileHandle file,	SpawnerTiledParameter parameter) 
	{
		String tiledMapPath;
		if (parameter == null)
		{
			tiledMapPath = file.pathWithoutExtension().concat(".tmx");					
		} else {
			tiledMapPath = parameter.tiledMapPath;
		}
		
		TiledMap tiled = assetManager.get(tiledMapPath,	TiledMap.class);			
		
		LinkedList<RectangleMapObject> list = new LinkedList<RectangleMapObject>();
		
		for(MapLayer layer:tiled.getLayers())
		{
			for(MapObject mo:layer.getObjects())
			{
				if(mo instanceof RectangleMapObject)
				{
					RectangleMapObject rmo = (RectangleMapObject)mo;
					list.add(rmo);										
				}
			}
		}		
		Spawner entitySpawn = new Spawner(list.size());
		
		int index = 0;
		for(RectangleMapObject rmo: list)
		{
			Rectangle r = rmo.getRectangle();
			String type = rmo.getProperties().get("type",rmo.getName(), String.class);
			if(type.equalsIgnoreCase("entity"))
			{
				type = rmo.getName();
			}
			final ObjectMap<String, Object> map = new ObjectMap<String, Object>();
			MapProperties mp = rmo.getProperties();			
			for(Iterator<String> it = mp.getKeys(); it.hasNext();)
			{
				final String key = it.next();
				if(!key.equalsIgnoreCase("type")) //no es necesario tener esta propiedad
				{
					final Object value = mp.get(key);
					if(value instanceof String)
					{
						final String s = (String)value;
						if(isBool.matcher(s).find())
						{
							map.put(key,Boolean.parseBoolean(s));
						}
						else
						{
							map.put(key, value);					
						}
					}
					else
					{
						map.put(key, value);					
					}
				}
			}
			entitySpawn.entities[index++] = new Spawn(type, (int)r.x, (int)r.y, (int)r.width, (int)r.height, map);
		}
		

		return entitySpawn;
	}

	public static class SpawnerTiledParameter extends AssetLoaderParameters<Spawner> 
	{
		public String tiledMapPath;		
	}
}
