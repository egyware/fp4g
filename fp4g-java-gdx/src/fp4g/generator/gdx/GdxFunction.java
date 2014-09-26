package fp4g.generator.gdx;

import fp4g.data.Container;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.expresion.FunctionCall;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

public abstract class GdxFunction
{
	private final String functionName;
	
	public GdxFunction(String name)
	{
		functionName = name;
	}
	
	public final String getFunctionName()
	{
		return functionName;
	}
	public abstract Expresion generate(JavaGenerator generator, JavaMetaSourceModel model, FunctionCall call, IDefine current, Container container, ExprList list) throws CannotEvalException;
}