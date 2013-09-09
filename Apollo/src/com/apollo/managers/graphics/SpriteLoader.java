/**
 * 
 */
package com.apollo.managers.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializer;
import com.badlogic.gdx.utils.OrderedMap;

/**
 * @author egyware
 * 
 */
public class SpriteLoader extends
		SynchronousAssetLoader<Sprite, SpriteLoader.AnimationParameter> {
	public static final int DEFAULT_DURATION = 200; //100 ms
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
	public Array<AssetDescriptor> getDependencies(String fileName,	AnimationParameter parameter) {
		Array<AssetDescriptor> deps = new Array<AssetDescriptor>();
		if (parameter == null) {
			deps.add(new AssetDescriptor(resolve(fileName)
					.pathWithoutExtension() + ".atlas", TextureAtlas.class));
		} else {
			deps.add(new AssetDescriptor(parameter.textureAtlasPath,
					TextureAtlas.class));
		}
		return deps;
	}

	@Override
	public Sprite load(AssetManager assetManager, String fileName,
			AnimationParameter parameter) {
		String textureAtlasPath;
		if (parameter == null) {
			textureAtlasPath = resolve(fileName).pathWithoutExtension()
					+ ".atlas";
		} else {
			textureAtlasPath = parameter.textureAtlasPath;
		}
		//con esto no puede ser asincronico
		serializer.setAtlas(assetManager.get(textureAtlasPath,
				TextureAtlas.class));			
		
		Sprite sprite = json.fromJson(Sprite.class,
				Gdx.files.internal(fileName));

		return sprite;// Sprite.build(resolve(fileName),atlas);
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

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public Sprite read(Json json, Object jsonData, Class type) {
			OrderedMap<String, Object> data = (OrderedMap<String, Object>) jsonData;
			Sprite sprite = new Sprite();
			// talvez no sea la mejor manera de leer estos datos, pero por
			// lo menos es simple
			json.readField(sprite, "width", jsonData);
			json.readField(sprite, "height", jsonData);
			json.readField(sprite, "origin", jsonData);
			json.readField(sprite, "first", jsonData);
			Array<?> animations = (Array<?>) data.get("animations");

			for (Object animation : animations) {
				OrderedMap<String,Object> aniData = (OrderedMap<String,Object>)animation;					
				OrderedMap<String,Object> sequence = (OrderedMap<String,Object>)aniData.get("sequence");
				String name = (String)aniData.get("name");
				String region = (aniData.containsKey("region"))?(String)aniData.get("region"):name;
				AtlasRegion array[] = null;					
				int duration = DEFAULT_DURATION;
				if(sequence.containsKey("delay"))
				{
					duration = ((Float)sequence.get("delay")).intValue();
				}
				Array<AtlasRegion> regions = atlas.findRegions(region);
				if(sequence.containsKey("data"))
				{
					Array<Float> framesArray = (Array<Float>)sequence.get("data");
					array = new AtlasRegion[framesArray.size];
					for (int i = 0; i < framesArray.size; i++) {
						array[i] = regions.get(framesArray.get(i).intValue()); 
					}
				}
				if (array == null) {
					array = new AtlasRegion[regions.size];
					for (int i = 0; i < regions.size; i++) {
						array[i] = regions.get(i);
					}
				}				
				// ya ahora están listos los datos :D
				sprite.addAnimation(name, new Animation(duration * 0.001f, array));
			}
			return sprite;
		}
	}

	static public class AnimationParameter extends
			AssetLoaderParameters<Sprite> {

		public String textureAtlasPath;

		public AnimationParameter(String _textureAtlasPath) {
			textureAtlasPath = _textureAtlasPath;
		}
	}

}
