package com.egysoft.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class TextureRegionLoader extends SynchronousAssetLoader<TextureRegion, TextureRegionLoader.TextureRegionParameter>
{
	public TextureRegionLoader(FileHandleResolver resolver) 
	{
		super(resolver);
	}

	public class TextureRegionParameter  extends AssetLoaderParameters<TextureRegion> 
	{
		public int index;
	}

	@Override
	public TextureRegion load(AssetManager assetManager, String fileName, FileHandle file, TextureRegionParameter parameter) 
	{
		final String assetName  = fileName.substring(0, fileName.indexOf(':')-1);
		final String regionName = fileName.substring(fileName.indexOf(':'));
		TextureAtlas atlas = assetManager.get(assetName) ;
		if(parameter != null)
			return atlas.findRegion(regionName, parameter.index);
		else
			return atlas.findRegion(regionName);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, TextureRegionParameter parameter) 
	{
		final String assetName = fileName.substring(0, fileName.indexOf(':')-1);
		Array<AssetDescriptor> dependencies = new Array<AssetDescriptor>();
		dependencies.add(new AssetDescriptor<TextureAtlas>(assetName, TextureAtlas.class));
		return dependencies;
	}
}
