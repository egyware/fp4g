/**
 * 
 */
package com.egysoft.gdx.assets;

import com.apollo.managers.PhysicsManager;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.utils.Array;
import com.egysoft.map.IMap;

/**
 * @author egyware
 * 
 */
public class GroundTiledLoader extends SynchronousAssetLoader<Ground, GroundTiledLoader.GroundTiledParameter> 
{
	private static final byte[] tabla = new byte[]
	{
	 // 0    1    2    3
		0xF, 0xE, 0x7, 0x6,  //0
		0xB, 0xA, 0x3, 0x2,  //4
		0xD, 0xC, 0x5, 0x4,  //8
		0x9, 0x8, 0x1, 0x0   //12
	};
	private static final byte TOP    = 0x1;
	private static final byte BOTTOM = 0x2;
	private static final byte LEFT   = 0x4;
	private static final byte RIGHT  = 0x8;
	private static final String PHYSICS_LAYER = "fisica";

	public GroundTiledLoader(FileHandleResolver resolver) 
	{
		super(resolver);		
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, GroundTiledParameter parameter) 
	{
		Array<AssetDescriptor> deps = new Array<AssetDescriptor>();
		if (parameter == null) 
		{
			deps.add(new AssetDescriptor(file.pathWithoutExtension() + ".tmx", TiledMap.class));
		}
		else 
		{
			deps.add(new AssetDescriptor(parameter.tiledMapPath,	TiledMap.class));
		}
		return deps;
	}
	
	@Override
	public Ground load(AssetManager assetManager, String fileName, FileHandle file, GroundTiledParameter parameter) 
	{
		String tiledMapPath;
		if (parameter == null)
		{
			tiledMapPath = file.pathWithoutExtension().concat(".tmx");					
		} else {
			tiledMapPath = parameter.tiledMapPath;
		}
		Ground ground = new Ground();
		ground.name = file.nameWithoutExtension();
		
		final TiledMap tiled = assetManager.get(tiledMapPath,	TiledMap.class);
		final TiledMapTileLayer layer = (TiledMapTileLayer)tiled.getLayers().get(PHYSICS_LAYER);
		final int w = layer.getWidth();
		final int h = layer.getHeight();
		
		final int th = (int)layer.getTileWidth();
		final int tw = (int)layer.getTileHeight();
		
		IMap map = new IMap()
		{
			@Override
			public int getTile(int i, int j)
			{
				Cell cell = layer.getCell(i, j);
				if(cell != null)
				{
					return cell.getTile().getId();
				}
				else
				{
					return 0;
				}					
			}

			@Override
			public int getWidth() 
			{
				return w;
			}

			@Override
			public int getHeight() 
			{
				return h;
			}

			@Override
			public int getTileWidth()
			{
				return tw;
			}

			@Override
			public int getTileHeight() 
			{
				return th;
			}
			
		};
		
		createEdgeFor(45,map,ground,PhysicsManager.FILTER_SCENARY);
		createEdgeFor(51,map,ground,PhysicsManager.FILTER_SCENARY_ENEMY);
		
		
		return ground;
	}
	
	
	
	private void createEdgeFor(int value, IMap map, Ground ground, Filter filter)
	{
		final int w = map.getWidth();
		final int h = map.getHeight();
		final int tw = map.getTileWidth();
		final int th = map.getTileHeight();
		
		byte top[]    = new byte[w*h];
		byte bottom[] = new byte[w*h];
		byte left[]   = new byte[w*h];
		byte right[]  = new byte[w*h];
		
		for(int i=0;i<w;i++)		
		{
			for(int j=0;j<h;j++)
			{
				int id = map.getTile(i,j);				
				if(id == value)
				{
					int a0  = (j-1>=0)?  (map.getTile(i,  j-1) == value?1:0):0;
					int a1  = (i-1>=0)?  (map.getTile(i-1,  j) == value?1:0):0;
					int a2  = (i+1 <w)?  (map.getTile(i+1,  j) == value?1:0):0;
					int a3  = (j+1 <h)?  (map.getTile(i,  j+1) == value?1:0):0;
					int index = (a0<<3)|(a1<<2)|(a2<<1)|a3;
					byte caso = tabla[index];
					
					top   [j*w + i] = (byte) (((caso & TOP) > 0)? 1 : 0);
					bottom[j*w + i] = (byte) (((caso & BOTTOM) > 0)? 1 : 0);					
					left  [j*w + i] = (byte) (((caso & LEFT) > 0)? 1 : 0);
					right [j*w + i] = (byte) (((caso & RIGHT) > 0)? 1 : 0);				
				}				
			}
		}
		
		createHEdges(ground,-th, w, h, tw, th, top,    filter);
		createHEdges(ground,  0, w, h, tw, th, bottom, filter);
		
		createVEdges(ground,0, w, h, tw, th, left,    filter);
		createVEdges(ground,-tw, w, h, tw, th, right, filter);
		
	}

	private void createVEdges(Ground ground,int offv, int w, int h,int tw,int th, byte[] array, Filter filter) 
	{
		int x0=0,y0=0,x1=0,y1=0;
		boolean active = false;
		for(int i=0;i<w;i++)										
		{
			for(int j=0;j<h;j++)
			{			
				if(active)
				{
					x1 = i;
					y1 = j;
					if(array[j*w + i] == 0)
					{
						active = false;						
					}
					Edge edge = new Edge();
					edge.x0 = x0*tw-offv;
					edge.y0 = y0*th;
					edge.x1 = x1*tw-offv;
					edge.y1 = y1*th;	
					edge.filter = filter;
					ground.terrains.add(edge);
				}
				else
				{
					if(array[j*w + i] > 0)
					{
						active = true;
						x1 = (x0 = i) + 1;
						y1 = (y0 = j) + 1;
					}
				}
				
			}
			if(active)
			{
				active = false;
				x1 = i;
				y1 = h;				
				Edge edge = new Edge();
				edge.x0 = x0*tw-offv;
				edge.y0 = y0*th;
				edge.x1 = x1*tw-offv;
				edge.y1 = y1*th;
				edge.filter = filter;
				ground.terrains.add(edge);
			}
			
		}		
	}
	
	private void createHEdges(Ground ground,int offh, int w, int h,int tw,int th, byte[] array, Filter filter) 
	{
		int x0=0,y0=0,x1=0,y1=0;
		boolean active = false;
		for(int j=0;j<h;j++)
		{
			for(int i=0;i<w;i++)		
			{			
				if(active)
				{
					x1 = i;
					y1 = j;
					if(array[j*w + i] == 0)
					{
						active = false;						
					}
					Edge edge = new Edge();
					edge.x0 = x0*tw;
					edge.y0 = y0*th-offh;
					edge.x1 = x1*tw;
					edge.y1 = y1*th-offh;	
					edge.filter = filter;
					ground.terrains.add(edge);
				}
				else
				{
					if(array[j*w + i] > 0)
					{
						active = true;
						x1 = (x0 = i) + 1;
						y1 = (y0 = j) + 1;
					}
				}
				
			}
			if(active)
			{
				active = false;
				x1 = w;
				y1 = j;				
				Edge edge = new Edge();
				edge.x0 = x0*tw;
				edge.y0 = y0*th-offh;
				edge.x1 = x1*tw;
				edge.y1 = y1*th-offh;
				edge.filter = filter;
				ground.terrains.add(edge);
			}
			
		}		
	}



	public static class GroundTiledParameter extends AssetLoaderParameters<Ground> 
	{
		public String tiledMapPath;
	}
}
