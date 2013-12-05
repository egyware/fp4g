package fp4g.generator.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import fp4g.data.Asset;
import fp4g.data.AssetType;
import fp4g.data.Assets;

public class AssetModel implements Comparable<AssetModel>
{
	private static class AssetModelExtra
	{
		public final String importClass;
		public final List<String> importParameterClasses;
		public final String parameterClass;
		public AssetModelExtra(String parameterClass,String importClass,List<String> importParameterClasses)
		{
			this.importClass = importClass;
			this.importParameterClasses = importParameterClasses;
			this.parameterClass = parameterClass;
		}
	}
	private static final HashMap<AssetType,AssetModelExtra> assetModelExtra = new HashMap<AssetType, AssetModelExtra>();	
	private static int nullName = 0;
	static 
	{
		assetModelExtra.put(AssetType.Texture, new AssetModelExtra(null,"com.badlogic.gdx.graphics.Texture",null));
		assetModelExtra.put(AssetType.Sprite, new AssetModelExtra("AnimationParameter","com.apollo.managers.graphics.Sprite",Arrays.asList("com.apollo.managers.graphics.SpriteLoader.AnimationParameter")));

	}
	private static synchronized String getNameForNull()
	{
		return String.format("assetGroup_%d",nullName++);
	}
	
	 
	public final AssetType type;
	public final String name;
	public final String asset;
	public final String parameterClass;
	public final String parameterClassOption;
	
	private AssetModel(Asset asset)
	{
		this(asset,null,null);
	}
	
	private AssetModel(Asset asset,String pc,String pco)
	{
		this.type = asset.type;
		this.name = (asset.assetName == null)?getNameForNull():asset.assetName;
		this.asset = asset.asset;
		this.parameterClass = pc;
		this.parameterClassOption = pco;
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
	public final String getParameterClass()
	{
		return parameterClass;
	}
	public final String getParameterClassOption()
	{
		return parameterClassOption;
	}
	
	@Override
	public int compareTo(AssetModel o) {
		return name.compareTo(o.name);
	}
	
	public static void newAsset(TreeSet<AssetModel> assets,TreeSet<String> imports,Asset asset)
	{
		newAsset(assets,imports,asset,null);
	}
	public static void newAsset(TreeSet<AssetModel> assets,TreeSet<String> imports,Asset asset,Assets parent)
	{		
		if(!(asset instanceof Assets))
		{
			AssetModel assetModel;
			if(parent != null)
			{
				AssetModelExtra ame = assetModelExtra.get(asset.type);
				assetModel = new AssetModel(asset,ame.parameterClass,parent.asset);
			}
			else
			{
				assetModel = new AssetModel(asset);
			}
			assets.add(assetModel);
			addImportClass(imports,asset.type);			
		}		
		else
		{
			Assets container = (Assets)asset;
			for(Asset a:container)
			{
				List<String> parameterClasses = assetModelExtra.get(a.type).importParameterClasses;				
				if(parameterClasses != null) imports.addAll(parameterClasses);
				newAsset(assets,imports,a,container);
			}			
		}
	}
	private static void addImportClass(TreeSet<String> imports,AssetType type) {
		String importClass = assetModelExtra.get(type).importClass;
		if(importClass != null)
		{
			imports.add(importClass);
		}
	}	
}
