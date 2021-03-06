package fp4g.generator.gdx.functions;

import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.expresion.DirectCode;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.gdx.GdxFunction;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

public class CreateBox extends GdxFunction
{

	@Override
	public Expresion generate(JavaGenerator generator, JavaMetaSourceModel model, ExprList list) throws CannotEvalException
	{
		model.addRequireSource("com.apollo.Assets");
		Expresion width  = list.get(0);			
		Expresion height = list.get(1);
		DirectCode expr = new DirectCode(String.format("Assets.createBox(%s,%s)",generator.expresion(model,width),generator.expresion(model,height)));			
		return expr;
	}			
}