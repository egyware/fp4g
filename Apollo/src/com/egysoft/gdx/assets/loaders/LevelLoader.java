package com.egysoft.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.egysoft.gdx.assets.CollisionMap;
import com.egysoft.gdx.assets.Level;
import com.egysoft.gdx.assets.Spawner;

public class LevelLoader extends SynchronousAssetLoader<Level, LevelLoader.LevelParameter> 
{
	private Json json = new Json();
	private Level level;
	public LevelLoader(FileHandleResolver resolver) 
	{
		super(resolver);
	}

	public class LevelParameter  extends AssetLoaderParameters<Level> 
	{
	}
	
	@Override
	public Level load(AssetManager assetManager, String fileName, FileHandle file, LevelParameter parameter) 
	{
		return level;
	}

	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, LevelParameter parameter) 
	{
		level = json.fromJson(Level.class, file);
		Array<AssetDescriptor> deps = new Array<AssetDescriptor>();
		deps.add(new AssetDescriptor(level.map,TiledMap.class));
		deps.add(new AssetDescriptor(level.collision,CollisionMap.class));
		deps.add(new AssetDescriptor(level.spawner,Spawner.class));
		deps.add(new AssetDescriptor(level.background, Texture.class));
		
		return deps;
	}


	

}
