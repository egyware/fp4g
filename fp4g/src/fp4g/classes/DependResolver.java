package fp4g.classes;

import java.util.HashMap;
import java.util.Map;

import fp4g.data.Define;
import fp4g.data.expresion.ArrayList;
import fp4g.data.expresion.List;
import fp4g.data.expresion.Literal;
import fp4g.generator.Depend;
import fp4g.generator.gdx.models.JavaCodeModel;

/**
 * Clase que resuelve las dependencias de el KeyMessage
 * @author Edgardo
 *
 */
public class DependResolver implements fp4g.data.expresion.Map, Depend
{
	private final static String GENERAL   = "General";	
	private final Map<String,ArrayList> importsRequired;
	
	public DependResolver()
	{
		importsRequired = new HashMap<String,ArrayList>();
	}
	
	public void addImports(final String s,JavaCodeModel model)
	{
		List imports = importsRequired.get(s);		
		if(imports != null)
		{
			for(Literal<?> i:imports)
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
		addImports(data.name,model);		
		//imports generales, si existen...
		addImports(GENERAL,model);
	}
	
	@Override
	public void set(String key, Literal<?> value) 
	{
		importsRequired.put(key, (ArrayList)value);
	}

	@Override
	public Literal<?> get(String key) 
	{		
		return importsRequired.get(key);
	}
}
