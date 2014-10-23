package fp4g.generator.gdx.functions;

import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.expresion.DirectCode;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.gdx.GdxFunction;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

public class CreateCircle extends GdxFunction
{
	@Override
	public Expresion generate(JavaGenerator generator, JavaMetaSourceModel model, ExprList list) throws CannotEvalException
	{
		model.addRequireSource("com.apollo.Assets");
		Expresion ratio = list.get(0);			
		DirectCode expr = new DirectCode(String.format("Assets.createCircle(%s)",generator.expresion(model,ratio)));			
		return expr;
	}		
}