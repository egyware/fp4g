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
public class TerrainLoader extends SynchronousAssetLoader<Terrain, TerrainLoader.Terrain2DParameter> 
{
	public TerrainLoader(FileHandleResolver resolver) 
	{
		super(resolver);		
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, Terrain2DParameter parameter) 
	{
		return null;
	}
	
	@Override
	public Terrain load(AssetManager assetManager, String fileName, FileHandle file, Terrain2DParameter parameter) 
	{
		Json json = new Json();
		json.addClassTag("Box", Box.class);		
		
		Terrain terrain = json.fromJson(Terrain.class, file);		

		return terrain;
	}

	public static class Terrain2DParameter extends AssetLoaderParameters<Terrain> 
	{
		//TODO nada todavía por diseñar :D
	}
}
