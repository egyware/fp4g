/**
 * 
 */
package com.egysoft.gdx.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

/**
 * @author egyware
 * 
 */
public class GroundLoader extends SynchronousAssetLoader<Ground, GroundLoader.GroundParameter> 
{
	public GroundLoader(FileHandleResolver resolver) 
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
	public Ground load(AssetManager assetManager, String fileName, FileHandle file, GroundParameter parameter) 
	{
		Json json = new Json();
		json.addClassTag("Box", Box.class);		
		
		Ground terrain = json.fromJson(Ground.class, file);		

		return terrain;
	}

	public static class GroundParameter extends AssetLoaderParameters<Ground> 
	{
		//TODO nada todavía por diseñar :D
	}
}
