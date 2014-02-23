package fp4g.data.define;

import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;

public class Asset extends Define
{
	public static enum Type {
		Texture,
		Atlas,
		Sprite,
		TileMap,
		Sound,
		Music
	}
	
	final public Type assetType;
	public Asset(Type assetType) 
	{
		this(assetType,null);		
	}
	public Asset(Type assetType, IDefine parent) 
	{
		super(DefineType.ASSET, assetType.name(), parent);
		this.assetType = assetType;
	}	
}
