package fp4g.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fp4g.data.Define;
import fp4g.data.IValue;
import fp4g.data.expresion.ArrayList;
import fp4g.data.expresion.IList;
import fp4g.generator.Depend;
import fp4g.generator.MetaSourceModel;

/**
 * Clase que resuelve las dependencias de el KeyMessage
 * @author Edgardo
 *
 */
public class DependResolver implements fp4g.data.expresion.IMap, Depend
{
	private final static String GENERAL   = "General";	
	private final Map<String,ArrayList> importsRequired;
	
	public DependResolver()
	{
		importsRequired = new HashMap<String,ArrayList>();
	}
	
	public void addImports(final String s,MetaSourceModel model)
	{
		IList imports = importsRequired.get(s);		
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
	public void perform(Define data, MetaSourceModel model)
	{		
		addImports(data.name,model);		
		//imports generales, si existen...
		addImports(GENERAL,model);
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

	@Override
	@SuppressWarnings("unchecked")
	public Set<Entry<String, ArrayList>> entrySet() 
	{
		return importsRequired.entrySet();
	}
}
