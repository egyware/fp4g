package fp4g.data.define;

import fp4g.data.Define;
import fp4g.data.DefineTypes;
import fp4g.data.ILib;
import fp4g.data.IValue;
import fp4g.exceptions.CannotEvalException;

public class Asset extends Define
{
	private String className;
	private String classParameter; 
	private String groupName;
	
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
		super(DefineTypes.ASSET, assetType.name(), parent);
		this.assetType = assetType;
	}
	public final String getClassName() {
		return className;
	}
	public final String getClassParameter() {
		return classParameter;
	}
	public final String getGroupName() {
		return groupName;
	}
	public final void setClassName(String className) {
		this.className = className;
	}
	public final void setClassParameter(String classParameter) {
		this.classParameter = classParameter;
	}
	public final void setGroupName(String groupName) {
		this.groupName = groupName;
	}	
}
