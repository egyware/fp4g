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
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.log.Log;
import fp4g.log.info.Warn;

/**
 * Clase que resuelve las dependencias de el KeyMessage
 * @author Edgardo
 *
 */
public class MessageDependResolver implements fp4g.data.expresion.IMap, Depend
{
	private final static String GENERAL   = "General";	
	private final Map<String,ArrayList> importsRequired;
	
	public MessageDependResolver()
	{
		importsRequired = new HashMap<String,ArrayList>();
	}
	public void addImports(final String s,JavaMetaSourceModel model)
	{
		addImports(s,model,true);
	}
	
	public void addImports(final String s,JavaMetaSourceModel model,boolean defaults)
	{
		IList imports = importsRequired.get(s);		
		if(imports != null)
		{
			for(IValue<?> i:imports)
			{
				model.addRequireSource((String) i.getValue());
			}
		}
		else if(defaults)
		{
			//si los imports no existen usaremos los por defecto
			Log.Show(Warn.DependResolverNotFound,String.format("Usando imports por defecto para \"%s\"", s));
			model.addRequireSource(String.format("com.apollo.messages.%sMessage",s));
			model.addRequireSource(String.format("com.apollo.messages.%sMessageHandler",s));
		}
	}
	
	/* (non-Javadoc)
	 * @see fp4g.classes.IDependResolver#perform(fp4g.data.Define, fp4g.generator.models.JavaCodeModel)
	 */
	@Override
	public void perform(Define data, JavaMetaSourceModel model)
	{		
		addImports(data.name,model);		
		//imports generales, si existen...
		addImports(GENERAL,model,false);
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
