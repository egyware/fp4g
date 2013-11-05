package fp4g.generator.models;

import java.util.TreeSet;

public class Depend {
	public final TreeSet<String> imports;
	public final TreeSet<AssetModel> assets;

	public Depend(TreeSet<String> imports, TreeSet<AssetModel> assets) {
		this.imports = imports;
		this.assets = assets;
	}
	
	public void addImport(String _class)
	{
		imports.add(_class);
	}
	
	public void addAsset(AssetModel.AssetType type, String resourceName)
	{
		assets.add(new AssetModel(type,resourceName));
	}

	

}
