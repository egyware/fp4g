package fp4g.data;

import java.util.Iterator;
import java.util.LinkedList;


public class Assets extends Asset implements Iterable<Asset>{	
	private final LinkedList<Asset> assets;
	
	public Assets()
	{
		this(AssetType.ParentContainer,null,null);
	}
	
	public Assets(AssetType type, String name,String asset) {
		super(type,name,asset);
		assets = new LinkedList<Asset>();		
	}

	public void add(AssetType type, String name,String asset)
	{
		assets.add(new Asset(type,name,asset));
	}
	
	public void add(Asset asset) {
		assets.add(asset);
	}

	@Override
	public Iterator<Asset> iterator() {
		return assets.iterator();
	}

	
	
}
