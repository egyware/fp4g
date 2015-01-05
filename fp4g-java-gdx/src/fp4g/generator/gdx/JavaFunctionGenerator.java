/**
 * 
 */
package fp4g.generator.gdx;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import fp4g.core.Expresion;
import fp4g.data.Container;
import fp4g.data.expresion.FunctionCall;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.FunctionGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

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
		ServiceLoader<GdxFunction> _functions = ServiceLoader.load(GdxFunction.class);
		for(GdxFunction fun: _functions)
		{
			functions.put(fun.getFunctionName(), fun);
		}
	}
	
	@Override	
	public Expresion generate(JavaMetaSourceModel model,FunctionCall fc, Container container) throws CannotEvalException
	{
		GdxFunction fg = functions.get(fc.functionName);		
		if(fg != null)
		{
			return fg.generate(generator, model, fc, fc.current, container, fc.params);
		}
		throw new CannotEvalException(CannotEvalException.Types.FunctionNotFound,(Expresion)fc, String.format("La función \"%s\", no se ha encontrado.",fc.functionName));
	}
	
}
