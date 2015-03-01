/**
 * 
 */
package com.egysoft.gdx.assets.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializer;
import com.badlogic.gdx.utils.JsonValue;
import com.egysoft.gdx.assets.Sprite;

/**
 * @author egyware
 * 
 */
public class SpriteLoader extends SynchronousAssetLoader<Sprite, SpriteLoader.AnimationParameter> 
{
	public static final int DEFAULT_DELAY = 200; //100 ms
	private Json json;
	private SpriteSerializer serializer;

	public SpriteLoader(FileHandleResolver resolver) {
		super(resolver);
		json = new Json();
		serializer = new SpriteSerializer();
		json.setSerializer(Sprite.class,serializer);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override	
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, AnimationParameter parameter) {
		Array<AssetDescriptor> deps = new Array<AssetDescriptor>();
		if (parameter == null) {
			deps.add(new AssetDescriptor(file
					.pathWithoutExtension() + ".atlas", TextureAtlas.class));
		} else {
			deps.add(new AssetDescriptor(parameter.textureAtlasPath,
					TextureAtlas.class));
		}
		return deps;
	}

	
	@Override
	public Sprite load(AssetManager assetManager, String fileName, FileHandle file,	
			AnimationParameter parameter) {
		String textureAtlasPath;
		if (parameter == null) {
			textureAtlasPath = file.pathWithoutExtension().concat(".atlas");					
		} else {
			textureAtlasPath = parameter.textureAtlasPath;
		}
		//con esto no puede ser asincronico
		serializer.setAtlas(assetManager.get(textureAtlasPath,
				TextureAtlas.class));			
		
		Sprite sprite = json.fromJson(Sprite.class,	Gdx.files.internal(fileName));

		return sprite;
	}

	private final class SpriteSerializer implements Serializer<Sprite> {
		private TextureAtlas atlas;

		private SpriteSerializer() {		
		}

		public void setAtlas(TextureAtlas textureAtlas) {
			atlas = textureAtlas;			
		}

		@SuppressWarnings("rawtypes")
		@Override
		public void write(Json json, Sprite object, Class knownType) {
			// TODO Auto-generated method stub

		}

		@SuppressWarnings({ "rawtypes"})
		@Override		
		public Sprite read(Json json, JsonValue jsonData, Class AssetType) 
		{			
			Sprite sprite = new Sprite();			
			json.readField(sprite, "origin", jsonData);
			json.readField(sprite, "first", jsonData);
			JsonValue animations = jsonData.get("animations");

			for (JsonValue animation : animations)
			{									
				JsonValue sequence = animation.get("sequence");
				AtlasRegion array[] = null;
				String name = animation.getString("name");
				//esto sirve para utilizar una región personalizada, si no existe se utilizará name como nombre de región
				final String region = animation.getString("region", name);
				final int duration;
				final PlayMode loopType;
				//corrigiendo un bug, si no existe sequence
				if(sequence != null)
				{				
					duration = sequence.getInt("delay", DEFAULT_DELAY);
					final String type = animation.getString("type","normal").toLowerCase();					
					if(type.equals("loop"))
					{
						loopType = PlayMode.LOOP;
					}
					//caso normal
					else
					{
						loopType = PlayMode.NORMAL;
					}				
					
					Array<AtlasRegion> regions = atlas.findRegions(region);
					if(sequence.hasChild("data"))
					{
						JsonValue framesArray = sequence.get("data");
						array = new AtlasRegion[framesArray.size];
						for (int i = 0; i < framesArray.size; i++) {
							array[i] = regions.get(framesArray.getInt(i)); 
						}
					}
					if (array == null) {
						array = new AtlasRegion[regions.size];
						for (int i = 0; i < regions.size; i++) {
							array[i] = regions.get(i);
						}
					}
				}
				else
				{
					duration = DEFAULT_DELAY;
					loopType = PlayMode.NORMAL;
					//considero todos los frames
					Array<AtlasRegion> regions = atlas.findRegions(region);
					array = new AtlasRegion[regions.size];
					for (int i = 0; i < regions.size; i++) {
						array[i] = regions.get(i);
					}
				}
				// ya ahora están listos los datos :D
				sprite.addAnimation(name, new Animation(duration * 0.001f, array), loopType);
			}
			return sprite;
		}		
	}

	public static class AnimationParameter extends AssetLoaderParameters<Sprite> 
	{
		public String textureAtlasPath;
		public AnimationParameter()	{ }
		public AnimationParameter(String _textureAtlasPath)
		{ 
			textureAtlasPath = _textureAtlasPath;	
		}
	}
}
