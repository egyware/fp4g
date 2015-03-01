/**
 * 
 */
package com.egysoft.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.egysoft.gdx.assets.Box;
import com.egysoft.gdx.assets.CollisionMap;

/**
 * @author egyware
 * 
 */
public class CollisionLoader extends SynchronousAssetLoader<CollisionMap, CollisionLoader.GroundParameter> 
{
	public CollisionLoader(FileHandleResolver resolver) 
	{
		super(resolver);		
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, GroundParameter parameter) 
	{
		return null;
	}
	
	@Override
	public CollisionMap load(AssetManager assetManager, String fileName, FileHandle file, GroundParameter parameter) 
	{
		Json json = new Json();
		json.addClassTag("Box", Box.class);		
		
		CollisionMap terrain = json.fromJson(CollisionMap.class, file);		

		return terrain;
	}

	public static class GroundParameter extends AssetLoaderParameters<CollisionMap> 
	{
		//TODO nada todavía por diseñar :D
	}
}
