package fp4g.generator.models;

import java.util.HashMap;
import java.util.TreeSet;

import fp4g.data.Asset;
import fp4g.data.AssetType;
import fp4g.data.Assets;

public class AssetModel implements Comparable<AssetModel>{
	private static final HashMap<AssetType,String> importClasses = new HashMap<>();
	private static int nullName = 0;
	static 
	{
		importClasses.put(AssetType.Texture, "com.badlogic.gdx.graphics.Texture");
		importClasses.put(AssetType.Sprite, "com.apollo.managers.graphics.Sprite");
	}	
	private static synchronized String getNameForNull()
	{
		return String.format("assetGroup_%d",nullName++);
	}
	
	 
	public final AssetType type;
	public final String name;
	public final String asset;
	
	private AssetModel(Asset asset) {
		this.type = asset.type;
		this.name = (asset.assetName == null)?getNameForNull():asset.assetName;
		this.asset = asset.asset;
	}

	public final String getType()
	{
		return type.name();
	}
	public final String getName()
	{
		return name;
	}
	public final String getResource()
	{
		return asset;
	}
	
	@Override
	public int compareTo(AssetModel o) {
		return name.compareTo(o.name);
	}

	public static void newAsset(TreeSet<AssetModel> assets,TreeSet<String> imports,Asset asset)
	{		
		if(!(asset instanceof Assets))
		{
			AssetModel assetModel = new AssetModel(asset);
			assets.add(assetModel);
			addImportClass(imports,asset.type);			
		}		
		else
		{
			Assets container = (Assets)asset;
			for(Asset a:container)
			{
				newAsset(assets,imports,a);
			}
			System.out.println("****"+asset.type);
		}
	}
	private static void addImportClass(TreeSet<String> imports,AssetType type) {
		String importClass = importClasses.get(type);
		if(importClass != null)
		{
			imports.add(importClass);
		}
	}	
}
