package com.egysoft.gdx.assets.loaders;

import org.luaj.vm2.Prototype;

import com.apollo.BehaviorTemplate;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializer;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.egysoft.gdx.assets.EntityBuilder;

/**
 * @author egyware
 * 
 */
public class EntityBuilderLoader extends AsynchronousAssetLoader<EntityBuilder, EntityBuilderLoader.EntityBuilderParameter> 
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, EntityBuilderParameter parameter) 
	{
		Array<AssetDescriptor> dependencies = new Array<AssetDescriptor>();
		FileHandle script;
		if(parameter != null)
			script = resolve(parameter.scriptName);
		else
			script = resolve(String.format("%s.lua", file.pathWithoutExtension()));
		if(script.exists())
		{
			dependencies.add(new AssetDescriptor(script, Prototype.class));
		}

		return dependencies;
	}
	
	private EntityBuilder builder;
	@Override
	public void loadAsync(AssetManager manager, String fileName, FileHandle file, EntityBuilderParameter parameter) 
	{
		final String scriptName = String.format("%s.lua", file.pathWithoutExtension());
		final Prototype prototype;
		if(manager.isLoaded(scriptName))
		{
			prototype = manager.get(scriptName);	
		}
		else
		{
			prototype = null;			
		}
		builder = json.fromJson(EntityBuilder.class, file);
		builder.prototype = prototype;		
	}

	@Override
	public EntityBuilder loadSync(AssetManager manager, String fileName, FileHandle file, EntityBuilderParameter parameter) 
	{
		return builder;
	}	

	public static class EntityBuilderParameter extends AssetLoaderParameters<EntityBuilder> 
	{
		public String scriptName;
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
