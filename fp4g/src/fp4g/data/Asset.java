package fp4g.data;

public class Asset extends Code{
	public final AssetType type;
	public final String assetName; //puede ser null
	public final String asset; //recurso
	
	public Asset(AssetType type,String assetName,String asset)
	{
		this.type = type;
		this.assetName = assetName;
		this.asset = asset;
	}
}
