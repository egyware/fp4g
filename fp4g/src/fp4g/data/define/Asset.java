package fp4g.data.define;

import java.util.Map.Entry;
import java.util.Set;

import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.IValue;
import fp4g.exceptions.NotAllowedOperatorException;

public class Asset extends Define
{
	public static enum Type {
		Texture,
		Atlas,
		Sprite,
		TileMap,
		Sound,
		Music,
		Terrain2D,
		EntitySpawn,
	}
	
	final public Type assetType;
	public Asset(Type assetType) 
	{
		this(assetType,null);		
	}
	public Asset(Type assetType, ILib parent) 
	{
		super(DefineType.ASSET, assetType.name(), parent);
		this.assetType = assetType;
	}	
}
