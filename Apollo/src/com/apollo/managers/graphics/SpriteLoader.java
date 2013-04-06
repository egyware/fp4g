/**
 * 
 */
package com.apollo.managers.graphics;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

/**
 * @author egyware
 *
 */
public class SpriteLoader extends SynchronousAssetLoader<Sprite, SpriteLoader.AnimationParameter>{

	public SpriteLoader(FileHandleResolver resolver) {
		super(resolver);		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Array<AssetDescriptor> getDependencies (String fileName,AnimationParameter parameter) 
	{		
		Array<AssetDescriptor> deps = new Array<AssetDescriptor>();
		if (parameter == null)
		{
			deps.add(new AssetDescriptor(resolve(fileName).pathWithoutExtension() + ".atlas", TextureAtlas.class));
		}
		else
		{
			deps.add(new AssetDescriptor(parameter.textureAtlasPath, TextureAtlas.class));
		}
		return deps;
	}
	
	@Override
	public Sprite load(AssetManager assetManager, String fileName,AnimationParameter parameter) 
	{
		String textureAtlasPath;
		if (parameter == null)
		{
			textureAtlasPath = resolve(fileName).pathWithoutExtension() + ".atlas";
		}
		else
		{
			textureAtlasPath = parameter.textureAtlasPath;
		}
		TextureAtlas atlas = assetManager.get(textureAtlasPath, TextureAtlas.class);		
		return Sprite.build(resolve(fileName),atlas);
	}

	static public class AnimationParameter extends AssetLoaderParameters<Sprite>{

		public String textureAtlasPath;
		
		public AnimationParameter(String _textureAtlasPath)
		{
			textureAtlasPath = _textureAtlasPath;
		}
	}

	

}
