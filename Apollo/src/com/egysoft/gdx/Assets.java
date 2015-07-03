package com.egysoft.gdx;

import java.util.Comparator;

import org.luaj.vm2.Prototype;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.egysoft.gdx.assets.CollisionMap;
import com.egysoft.gdx.assets.EntityBuilder;
import com.egysoft.gdx.assets.Stage;
import com.egysoft.gdx.assets.Spawner;
import com.egysoft.gdx.assets.Sprite;
import com.egysoft.gdx.assets.loaders.CollisionTiledLoader;
import com.egysoft.gdx.assets.loaders.EntityBuilderLoader;
import com.egysoft.gdx.assets.loaders.StageLoader;
import com.egysoft.gdx.assets.loaders.PrototypeLoader;
import com.egysoft.gdx.assets.loaders.SpawnerTiledLoader;
import com.egysoft.gdx.assets.loaders.SpriteLoader;

public class Assets implements Disposable, AssetErrorListener, Comparator<AssetDescriptor<?>>
{
	private static final String TAG = "Assets";	
	
	private final Logger logger;
	private final AssetManager manager;	
	private final FileHandleResolver fileResolver;
	public final ObjectMap<Class<?>, Integer> values;
	private final ObjectMap<String, Array<AssetDescriptor<?>>> groups;

	public Assets(FileHandleResolver resolver)
	{
		fileResolver = resolver;
		logger = new Logger(TAG, Logger.INFO);		
		manager = new AssetManager(fileResolver);
		manager.setLoader(Sprite.class,        new SpriteLoader(fileResolver));		
		manager.setLoader(CollisionMap.class,  new CollisionTiledLoader(fileResolver));
		manager.setLoader(Spawner.class,       new SpawnerTiledLoader(fileResolver));
		manager.setLoader(TiledMap.class,      new TmxMapLoader(fileResolver));
		manager.setLoader(EntityBuilder.class, new EntityBuilderLoader(fileResolver));
		manager.setLoader(Stage.class,		  new StageLoader(fileResolver));
		manager.setLoader(Prototype.class,     new PrototypeLoader(fileResolver));
		//manager.setErrorListener(this);
		groups = new ObjectMap<String, Array<AssetDescriptor<?>>>();
		values = new ObjectMap<Class<?>, Integer>();
		values.put(EntityBuilder.class, 2);
		values.put(Stage.class, 3);
	}

	public void loadGroup(String groupName) 
	{
		logger.info("loading group " + groupName);

		Array<AssetDescriptor<?>> assets = groups.get(groupName, null);
		if (assets != null) 
		{
			for (AssetDescriptor<?> asset : assets) 
			{
				manager.load(asset);				
			}
		}
		else 
		{
			logger.error("error loading group " + groupName + ", not found");
		}		
	}

	public void unloadGroup(String groupName) 
	{
		logger.info("unloading group " + groupName);

		Array<AssetDescriptor<?>> assets = groups.get(groupName, null);

		if (assets != null) 
		{
			for (AssetDescriptor<?> asset : assets) 
			{
				if (manager.isLoaded(asset.fileName))
				{
					manager.unload(asset.fileName);
				}
			}
		}
		else 
		{
			logger.error("error unloading group " + groupName + ", not found");
		}
	}

	public synchronized <T> T get(String fileName) 
	{
		return manager.get(fileName);
	}

	public synchronized <T> T get(String fileName, Class<T> type) 
	{
		return manager.get(fileName, type);
	}
	
	public synchronized <T> Array<T> getAll(Class<T> type)
	{
		final Array<T> array = new Array<T>();
		return manager.getAll(type, array);
	}

	public boolean update() 
	{
		return manager.update();
	}

	public void finishLoading() 
	{
		manager.finishLoading();
	}

	public float getProgress() 
	{
		return manager.getProgress();
	}

	@Override
	public void dispose() 
	{
		logger.info("shutting down");
		manager.dispose();
	}

	@Override
	@SuppressWarnings("rawtypes")	
	public void error(AssetDescriptor asset, Throwable throwable) 
	{
		logger.error("error loading " + asset.fileName);
	}
	
	public boolean containsGroup(String nameGroup)
	{
		return groups.containsKey(nameGroup);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void loadGroups(String assetFile)
	{
		logger.info("loading file " + assetFile);
		try 
		{			
			Json json = new Json();
			JsonValue root = new JsonReader().parse(resolve(assetFile));
			JsonValue groupsValue = root.get("groups");
			for(JsonValue groupValue: groupsValue)
			{
				final String groupName = groupValue.getString("name");
				final Array<Asset> assets = json.readValue("assets", Array.class, Asset.class, groupValue);
				final Array<AssetDescriptor<?>> assetDescriptors = new Array<AssetDescriptor<?>>();
				for(Asset asset: assets)
				{
					assetDescriptors.add(new AssetDescriptor(asset.fileName, asset.type));
				}
				assetDescriptors.sort(this);
				groups.put(groupName, assetDescriptors);
			}
		}
		catch (Exception e) 
		{
			logger.error(String.format("error loading file %s %s", assetFile, e.getMessage()));
		}
	}	
	
	private FileHandle resolve(String fileName) 
	{
		return fileResolver.resolve(fileName);
	}
		
	private static class Asset implements Serializable
	{
		public String fileName;
		public Class<?> type;
		
		@Override
		public void write(Json json) 
		{
			// TODO Auto-generated method stub			
		}
		
		@Override
		public void read(Json json, JsonValue jsonData) 
		{
			String type = jsonData.getString("type");
			fileName = jsonData.getString("fileName");			
			try 
			{								
				this.type = ClassReflection.forName(type);
			}
			catch (ReflectionException e) 
			{
				throw new GdxRuntimeException(e);
			}
			
		}
	}

	public Array<String> getGroups()
	{
		return groups.keys().toArray();
	}

	@Override
	public int compare(AssetDescriptor<?> a, AssetDescriptor<?> b) 
	{
		return values.get(a.type, 1)-values.get(b.type, 1);
	}	
}