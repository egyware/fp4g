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
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

/**
 * @author egyware
 * 
 */
public class GroundTiledLoader extends SynchronousAssetLoader<Ground, GroundTiledLoader.GroundTiledParameter> 
{
	private static final String PHYSICS_LAYER = "fisica";

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
		String tiledMapPath;
		if (parameter == null)
		{
			tiledMapPath = file.pathWithoutExtension().concat(".tmx");					
		} else {
			tiledMapPath = parameter.tiledMapPath;
		}
		TiledMap tiled = assetManager.get(tiledMapPath,	TiledMap.class);
		TiledMapTileLayer layer = (TiledMapTileLayer)tiled.getLayers().get(PHYSICS_LAYER);
		int w = layer.getWidth();
		int h = layer.getHeight();
		
		for(int i=0;i<w;i++)		
		{
			for(int j=0;j<h;j++)
			{
				Cell cell = layer.getCell(i, j);
				if(cell != null)
				{
					int id = cell.getTile().getId();
				}
			}
		}
		
		
		return null;
	}

	public static class GroundTiledParameter extends AssetLoaderParameters<Ground> 
	{
		public String tiledMapPath;
	}
}
