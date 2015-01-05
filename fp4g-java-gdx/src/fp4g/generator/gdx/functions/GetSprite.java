package fp4g.generator.gdx.functions;

import fp4g.core.Expresion;
import fp4g.data.Container;
import fp4g.data.ExprList;
import fp4g.data.IDefine;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.gdx.GdxFunction;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

public class GetSprite extends GdxFunction
{
	public GetSprite() 
	{
		super("getSprite");
	}

	@Override
	public Expresion generate(JavaGenerator generator, JavaMetaSourceModel model, FunctionCall call, IDefine current, Container container, ExprList list)
	throws CannotEvalException 
	{
		String resourceName = generator.expresion(model,container,list.get(0));
		model.addRequireSource("com.apollo.managers.graphics.Sprite");
		DirectCode expr = new DirectCode(String.format("(Sprite)container.gameManager.assets.get(%s)",resourceName));						
		return expr;
	}
			
}
	