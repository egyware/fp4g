package fp4g.classes;

import java.util.HashMap;
import java.util.Map;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IValue;
import fp4g.data.define.Behavior;
import fp4g.data.define.Entity;
import fp4g.data.expresion.ArrayList;
import fp4g.data.expresion.List;
import fp4g.generator.Depend;
import fp4g.generator.gdx.models.JavaCodeModel;

/**
 * Clase que resuelve las dependencias de el KeyMessage
 * @author Edgardo
 *
 */
public class EntityDependResolver implements fp4g.data.expresion.Map, Depend
{
	private final static String GENERAL    = "General";
	private final static String BUILDER   = "Builder";
	private final static String ENTITY    = "Entity";
	private final static String BEHAVIORS = "Behaviors"; 
	private final static String MESSAGE   = "Message";
	private final Map<String,ArrayList> importsRequired;
	
	public EntityDependResolver()
	{
		importsRequired = new HashMap<String,ArrayList>();
	}
	
	private void addBehaviorsImports(Entity entity, JavaCodeModel model) 
	{
		List imports = importsRequired.get(BEHAVIORS);
		for(IValue<?> i:imports)
		{
			for(Add bhvr: entity.getAdd(DefineType.BEHAVIOR))
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
				
				model.imports.add(String.format((String) i.getValue(), packageName));
			}
		}
		
	}
	
	public void addImports(final String s,JavaCodeModel model)
	{
		List imports = importsRequired.get(s);		
		if(imports != null)
		{
			for(IValue<?> i:imports)
			{
				model.imports.add((String) i.getValue());
			}
		}
	}	
	
	/* (non-Javadoc)
	 * @see fp4g.classes.IDependResolver#perform(fp4g.data.Define, fp4g.generator.models.JavaCodeModel)
	 */
	@Override
	public void perform(Define data, JavaCodeModel model)
	{		
		Entity entity = (Entity)data;
		if(model.name.endsWith("Builder")) //TODO por ahora no se me ocurre una manera limpia de diferenciarlos.
		{
			addImports(BUILDER,model);
			addBehaviorsImports(entity, model);			
		}
		else
		{			
			addImports(ENTITY,model);
			if(!data.getOnMessages().isEmpty())
			{
				addImports(MESSAGE,model);
			}
			addBehaviorsImports(entity, model);			
		}
		addImports(GENERAL, model);
	}
	
	

	@Override
	public void set(String key, IValue<?> value) 
	{
		importsRequired.put(key, (ArrayList)value);
	}

	@Override
	public IValue<?> get(String key) 
	{		
		return importsRequired.get(key);
	}
}
