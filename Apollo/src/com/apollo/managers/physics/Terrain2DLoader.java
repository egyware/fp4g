/**
 * 
 */
package com.apollo.managers.physics;

import java.util.regex.Pattern;

import com.apollo.managers.physics.Terrain2D.Box;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

/**
 * @author egyware
 * 
 */
public class Terrain2DLoader extends SynchronousAssetLoader<Terrain2D, Terrain2DLoader.Terrain2DParameter> 
{
	public Terrain2DLoader(FileHandleResolver resolver) 
	{
		super(resolver);		
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, Terrain2DParameter parameter) 
	{
		return null;
	}

	private static Pattern splitLines = Pattern.compile("[\n\r]+");
	private static Pattern splitSpaces = Pattern.compile("\\s+");
	
	@Override
	public Terrain2D load(AssetManager assetManager, String fileName, FileHandle file, Terrain2DParameter parameter) 
	{
		String data = file.readString();
				
		String lines[] = splitLines.split(data);
		
		String header[] = splitSpaces.split(lines[0]);
		
		int tw = Integer.parseInt(header[0]);
    	int th = Integer.parseInt(header[1]);
    	//ancho y alto del mapa
    	int mw = Integer.parseInt(header[2])*tw;
    	int mh = Integer.parseInt(header[3])*th;
		
		
		Terrain2D terrain2D = new Terrain2D(mw, mh,lines.length-1);
		Box[] terrains = terrain2D.terrains;
		
		//se carga todo el terreno
		for(int i = 1; i < lines.length; i++)
		{
			final String r[] = splitSpaces.split(lines[i]);			
			final int _x = Integer.parseInt(r[0])*tw;
			final int _y = Integer.parseInt(r[1])*th;
			final int _w = Integer.parseInt(r[2])*tw;
			final int _h = Integer.parseInt(r[3])*th;
    		
			
			terrains[i-1] = new Box(_x,_y,_w,_h);
		}

		return terrain2D;
	}

	public static class Terrain2DParameter extends AssetLoaderParameters<Terrain2D> 
	{
		//TODO nada todavía por diseñar :D
	}
}
