package com.egysoft.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.egysoft.gdx.assets.Stage;

public class StageLoader extends AsynchronousAssetLoader<Stage, StageLoader.LevelParameter>
implements Json.Serializer<Stage>
{
	private Json json;
	private Stage level;
	public StageLoader(FileHandleResolver resolver) 
	{
		super(resolver);
		json = new Json();
		json.setSerializer(Stage.class, this);
	}

	public class LevelParameter  extends AssetLoaderParameters<Stage> 
	{
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, LevelParameter parameter) 
	{
		return null;
	}

	@Override
	public void loadAsync(AssetManager manager, String fileName, FileHandle file, LevelParameter parameter) 
	{
		level = json.fromJson(Stage.class, file);
	}

	@Override
	public Stage loadSync(AssetManager manager, String fileName, FileHandle file, LevelParameter parameter) 
	{
		return level;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void write(Json json, Stage object, Class knownType) 
	{
		// TODO Auto-generated method stub		
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Stage read(Json json, JsonValue jsonData, Class type) 
	{
		Stage stage = new Stage();
		JsonValue sceneValue = jsonData.get("Scene");
		if(sceneValue != null)
		{
			for(JsonValue actorValue: sceneValue)
			{
				System.out.println(actorValue);
			}
		}
		
		JsonValue entitiesValue = jsonData.get("Entities");
		if(entitiesValue != null)
		{
			
		}
		return stage;
	}


	

}
