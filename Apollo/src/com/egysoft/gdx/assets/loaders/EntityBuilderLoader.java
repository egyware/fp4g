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
import com.egysoft.gdx.assets.EntityBuilder;

/**
 * @author egyware
 * 
 */
public class EntityBuilderLoader extends SynchronousAssetLoader<EntityBuilder, EntityBuilderLoader.EntityBuilderParameter> 
{
	public static Json json = new Json();	
	static
	{
		//json.setElementType(EntityBuilder.class, "behaviors", BehaviorTemplate.class);
	}
	public EntityBuilderLoader(FileHandleResolver resolver) 
	{
		super(resolver);		
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, EntityBuilderParameter parameter) 
	{
		return null;
	}
	
	@Override
	public EntityBuilder load(AssetManager assetManager, String fileName, FileHandle file, EntityBuilderParameter parameter) 
	{
		return json.fromJson(EntityBuilder.class, file);
	}

	public static class EntityBuilderParameter extends AssetLoaderParameters<EntityBuilder> 
	{
		//TODO nada todavía por diseñar :D
	}

	
}
