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
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

/**
 * @author egyware
 * 
 */
public class GroundTiledLoader extends SynchronousAssetLoader<Ground, GroundTiledLoader.GroundTiledParameter> 
{
	public GroundTiledLoader(FileHandleResolver resolver) 
	{
		super(resolver);		
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, GroundTiledParameter parameter) 
	{
		Array<AssetDescriptor> deps = new Array<AssetDescriptor>();
		if (parameter == null) 
		{
			deps.add(new AssetDescriptor(file.pathWithoutExtension() + ".tmx", TiledMap.class));
		}
		else 
		{
			deps.add(new AssetDescriptor(parameter.tiledMapPath,	TiledMap.class));
		}
		return deps;
	}
	
	@Override
	public Ground load(AssetManager assetManager, String fileName, FileHandle file, GroundTiledParameter parameter) 
	{
		Json json = new Json();
		json.addClassTag("Box", Box.class);		
		
		Ground terrain = json.fromJson(Ground.class, file);		

		return terrain;
	}

	public static class GroundTiledParameter extends AssetLoaderParameters<Ground> 
	{
		public String tiledMapPath;
	}
}
