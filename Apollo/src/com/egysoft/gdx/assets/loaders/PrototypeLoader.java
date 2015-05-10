/**
 * 
 */
package com.egysoft.gdx.assets.loaders;

import java.io.IOException;
import java.io.InputStream;

import org.luaj.vm2.Prototype;
import org.luaj.vm2.compiler.LuaC;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

/**
 * @author egyware
 * 
 */
public class PrototypeLoader extends SynchronousAssetLoader<Prototype, PrototypeLoader.PrototypeParameter> 
{
	public PrototypeLoader(FileHandleResolver resolver) 
	{
		super(resolver);		
	}
	

	public static class PrototypeParameter extends AssetLoaderParameters<Prototype> 
	{
		//TODO nada todavía por diseñar :D
	}


	@Override
	public Prototype load(AssetManager assetManager, String fileName, FileHandle file, PrototypeParameter parameter) 
	{
		try
		{
			InputStream stream = file.read();		
			Prototype p = LuaC.instance.compile(stream, file.nameWithoutExtension());
			stream.close();
			return p;
		} 
		catch (IOException e) 
		{			
			throw new GdxRuntimeException(e.getMessage(), e); 
		}				
	}


	@Override
	@SuppressWarnings("rawtypes")
	public Array<AssetDescriptor> getDependencies(String fileName,	FileHandle file, PrototypeParameter parameter) 
	{
		return null;
	}

	
}
