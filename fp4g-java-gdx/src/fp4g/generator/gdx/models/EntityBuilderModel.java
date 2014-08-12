package fp4g.generator.gdx.models;

import java.util.HashMap;
import java.util.List;

public final class EntityBuilderModel extends JavaSourceModel
{
	private List<VarCodeModel> params;
	private List<HashMap<String, Object>> behaviors;
	private List<OnModel> onList;
	private EntityModel entityModel;

	public EntityBuilderModel(String pckg, String name) 
	{
		super(new JavaMetaSourceModel(pckg,name));		
	}

	public final void setParams(List<VarCodeModel> pair) 
	{
		params = pair;		
	}
	public final List<VarCodeModel> getParams() 
	{
		return params;
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
	
	public void setEntity(EntityModel entityModel)
	{
		this.entityModel = entityModel;
	}
	public JavaMetaSourceModel getEntity()
	{
		return entityModel.getMetaSource();
	}
	
	
	
}
