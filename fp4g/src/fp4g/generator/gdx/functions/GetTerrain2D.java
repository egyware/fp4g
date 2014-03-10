package fp4g.generator.gdx.functions;

import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.expresion.DirectCode;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.gdx.GdxFunction;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.JavaCodeModel;

public class GetTerrain2D extends GdxFunction
{
	@Override
	public Expresion generate(JavaGenerator generator, JavaCodeModel model, ExprList list) throws CannotEvalException	
	{
		String resourceName = generator.expresion(model,list.get(0));
		model.addImport("com.apollo.Assets");
		DirectCode expr = new DirectCode(String.format("Assets.getTerrain2D(%s)",resourceName));						
		return expr;
	}		
}
	