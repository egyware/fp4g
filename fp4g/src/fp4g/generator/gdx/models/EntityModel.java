package fp4g.generator.gdx.models;

import java.util.HashMap;
import java.util.List;

public final class EntityModel extends JavaSourceModel
{
	private boolean hasAttachments;
	private List<HashMap<String, Object>> behaviors;
	private List<OnModel> onList;
	private List<VarCodeModel> flags;
	private List<WhenModel> whenList;

	public EntityModel(String pckg, String name) 
	{
		super(new JavaMetaSourceModel(pckg,name));		
	}

	public void setHasAttachments(boolean b) 
	{
		hasAttachments = b;		
	}
	public boolean isHasAttachments()
	{
		return hasAttachments;
	}

	public void setBehaviors(List<HashMap<String, Object>> behaviors) 
	{
		this.behaviors = behaviors;		
	}
	
	public List<HashMap<String, Object>> getBehaviors()
	{
		return behaviors;
	}

	public void setMessages(List<OnModel> onList) 
	{
		this.onList = onList;		
	}
	
	public List<OnModel> getMessages()
	{
		return onList;
	}

	public void setFlags(List<VarCodeModel> flags) 
	{
		this.flags = flags;		
	}
	public List<VarCodeModel> getFlags()
	{
		return flags;
	}

	public void setWhenList(List<WhenModel> whenList) 
	{
		this.whenList = whenList;		
	}
	
	public List<WhenModel> getWhenList() 
	{
		return this.whenList;		
	}
	
	
	
}
