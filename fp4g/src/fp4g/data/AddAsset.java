/**
 * 
 */
package fp4g.data;

import fp4g.data.define.Asset;
import fp4g.data.expresion.IMap;

/**
 * Add especializado que permite añadir recursos.
 * 
 * @author egyware
 *
 */
public class AddAsset extends Add
{		
	public final Asset asset;
	public final String resourceName;
	public final String resource;
	private AddAsset assetParent;
	
	public AddAsset(Asset asset, String resourceName, String resource, IMap values) 
	{	
		super(resourceName, AddType.AddAsset, values);
		this.asset = asset;
		this.resourceName = resourceName;
		this.resource = resource;				
	}
	
	public void setParent(AddAsset assetParent) 
	{
		this.assetParent = assetParent;
	}
	public AddAsset getParent()
	{
		return assetParent;
	}
}
