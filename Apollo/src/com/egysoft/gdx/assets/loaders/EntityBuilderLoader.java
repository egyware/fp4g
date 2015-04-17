package com.egysoft.gdx.assets.loaders;

import com.apollo.BehaviorTemplate;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.Json.Serializer;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.badlogic.gdx.utils.JsonValue;
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
		json.setSerializer(EntityBuilder.class, new EntityBuilderSerializer());
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

	
	@SuppressWarnings("rawtypes")
	private static class EntityBuilderSerializer implements Serializer<EntityBuilder>
	{
		@Override
		public void write(Json json, EntityBuilder object,  Class knownType)
		{			
		}

		@Override
		public EntityBuilder read(Json json, JsonValue jsonData, Class type)
		{
			EntityBuilder entityBuilder = new EntityBuilder();
			json.readField(entityBuilder, "defaultValue", jsonData);
			json.readField(entityBuilder, "name", jsonData);
			
			JsonValue behaviorsData = jsonData.get("behaviors");
			BehaviorTemplate behaviors[] = new BehaviorTemplate[behaviorsData.size];
			int index = 0;
			for(JsonValue behavior:behaviorsData)
			{
				try
				{
					String className = String.format("com.apollo.behaviors.%sBehavior$Template", behavior.name);
					Class<?> classType = ClassReflection.forName(className);
					behaviors[index++] = (BehaviorTemplate) json.readValue(classType, behavior);					
				}
				catch (ReflectionException ex) 
				{
					throw new SerializationException(ex);
				}				
			}
			entityBuilder.behaviors = behaviors;
			
			return entityBuilder;
		}		
	}
	
}
