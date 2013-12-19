package fp4g.classes;

import java.util.HashMap;
import java.util.Map;

import fp4g.data.Define;
import fp4g.data.expresion.ArrayList;
import fp4g.data.expresion.List;
import fp4g.data.expresion.Literal;
import fp4g.generator.Depend;
import fp4g.generator.models.JavaCodeModel;

/**
 * Clase que resuelve las dependencias de el KeyMessage
 * @author Edgardo
 *
 */
public class DependResolver implements fp4g.data.expresion.Map, Depend
{
	private final Map<String,ArrayList> importsRequired;
	
	public DependResolver()
	{
		importsRequired = new HashMap<String,ArrayList>();
	}
	
	/* (non-Javadoc)
	 * @see fp4g.classes.IDependResolver#perform(fp4g.data.Define, fp4g.generator.models.JavaCodeModel)
	 */
	@Override
	public void perform(Define data, JavaCodeModel model)
	{
		List imports = importsRequired.get(data.name);
		
		for(Literal<?> i:imports)
		{
			model.imports.add((String) i.getValue());
		}			
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
