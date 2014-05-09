package fp4g.classes;

import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IValue;
import fp4g.data.add.AddDefine;
import fp4g.data.define.Behavior;
import fp4g.data.define.Entity;
import fp4g.data.expresion.ArrayList;
import fp4g.data.expresion.IList;
import fp4g.generator.Depend;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

/**
 * Clase que resuelve las dependencias de el KeyMessage
 * @author Edgardo
 *
 */
public class EntityDependResolver implements Depend
{
	private ArrayList generalList;
	private ArrayList builderList;
	private ArrayList entityList;
	private ArrayList behaviorsList;
	private ArrayList messageList;	
	
	public EntityDependResolver()
	{	
	}
	
	private void addBehaviorsImports(Entity entity, JavaMetaSourceModel model) 
	{
		IList imports = behaviorsList;
		for(IValue<?> i:imports)
		{
			for(AddDefine bhvr: entity.getAddDefines(DefineType.BEHAVIOR))
			{
				String packageName;
				Behavior behavior = (Behavior)bhvr.define;
				if(behavior != null && behavior.group != null)
				{					
					packageName = behavior.group.concat(".").concat(bhvr.name);				
				}
				else
				{
					packageName = bhvr.name;
				}
				
				model.addRequireSource(String.format((String) i.getValue(), packageName));
			}
		}
		
	}
	
	public void addImports(final IList imports,JavaMetaSourceModel model)
	{
		if(imports != null)
		{
			for(IValue<?> i:imports)
			{
				model.addRequireSource((String) i.getValue());
			}
		}
	}	
	
	/* (non-Javadoc)
	 * @see fp4g.classes.IDependResolver#perform(fp4g.data.Define, fp4g.generator.models.JavaCodeModel)
	 */
	@Override
	public void perform(Define data, JavaMetaSourceModel model)
	{		
		Entity entity = (Entity)data;
		if(model.getName().endsWith("Builder")) //TODO por ahora no se me ocurre una manera limpia de diferenciarlos.
		{
			addImports(builderList,model);
			addBehaviorsImports(entity, model);			
		}
		else
		{			
			addImports(entityList,model);
			if(!data.getOnMessages().isEmpty())
			{
				addImports(messageList,model);
			}
			addBehaviorsImports(entity, model);			
		}
		addImports(generalList, model);
	}

	public final void setGeneral(ArrayList general) 
	{
		this.generalList = general;
	}
	public final void setBuilder(ArrayList builder) 
	{
		this.builderList = builder;
	}
	public final void setEntity(ArrayList entity) 
	{
		this.entityList = entity;
	}
	public final void setBehaviors(ArrayList behaviors) 
	{
		this.behaviorsList = behaviors;
	}
	public final void setMessage(ArrayList message) 
	{
		this.messageList = message;
	}
}
