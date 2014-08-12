/**
 * 
 */
package fp4g.generator.gdx;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.misc.Utils;

import fp4g.data.Expresion;
import fp4g.data.expresion.FunctionCall;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.FunctionGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.log.info.CannotEval;

/**
 * @author Edgardo
 *
 */
public class JavaFunctionGenerator extends FunctionGenerator<JavaMetaSourceModel, JavaGenerator>
{		
	private final Map<String, GdxFunction> functions;
	public JavaFunctionGenerator(JavaGenerator jg)
	{		
		super(jg);
		functions = new HashMap<String, GdxFunction>();
	}
	
	@Override
	@SuppressWarnings("unchecked")	
	public Expresion generate(JavaMetaSourceModel model,FunctionCall fc) throws CannotEvalException
	{
		GdxFunction fg = functions.get(fc.functionName);
		if(fg == null)
		{
			String className = "fp4g.generator.gdx.functions.".concat(Utils.capitalize(fc.functionName));
			try 
			{
				//JavaFunctionGenerator.class.
				Class<? extends GdxFunction> clazz = (Class<? extends GdxFunction>) Class.forName(className);
				fg = clazz.newInstance();
				functions.put(fc.functionName, fg);				
			}
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
			}
			catch (InstantiationException e) 
			{
				// TODO Auto-generated catch block
			}
			catch (IllegalAccessException e) 
			{
				// TODO Auto-generated catch block			
			}
		}
		if(fg != null)
		{
			return fg.generate(generator, model, fc.params);
		}
		throw new CannotEvalException(CannotEval.FunctionNotFound,(Expresion)fc, String.format("La función \"%s\", no se ha encontrado.",fc.functionName));
	}
	
}
