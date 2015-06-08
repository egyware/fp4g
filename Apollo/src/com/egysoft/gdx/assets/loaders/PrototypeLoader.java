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
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

/**
 * @author egyware
 * 
 */
public class PrototypeLoader extends AsynchronousAssetLoader<Prototype, PrototypeLoader.PrototypeParameter> 
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
	@SuppressWarnings("rawtypes")
	public Array<AssetDescriptor> getDependencies(String fileName,	FileHandle file, PrototypeParameter parameter) 
	{
		return null;
	}

	private Prototype p;
	@Override
	public void loadAsync(AssetManager manager, String fileName, FileHandle file, PrototypeParameter parameter) 
	{
		try
		{
			InputStream stream = file.read();		
			p = LuaC.instance.compile(stream, file.nameWithoutExtension());
			stream.close();			
		} 
		catch (IOException e) 
		{			
			throw new GdxRuntimeException(e.getMessage(), e); 
		}
	}


	@Override
	public Prototype loadSync(AssetManager manager, String fileName, FileHandle file, PrototypeParameter parameter) 
	{
		return p;
	}

	
}
