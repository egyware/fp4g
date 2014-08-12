package fp4g.generator.gdx.functions;

import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.expresion.DirectCode;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.gdx.GdxFunction;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

public class GetCamera extends GdxFunction
{
	@Override
	public Expresion generate(JavaGenerator generator, JavaMetaSourceModel model, ExprList list) throws CannotEvalException	
	{
		//TODO de hecho para que quede más universal, deberia obtener el define de RenderManager
		model.addRequireSource("com.apollo.managers.StageRenderManager");
		DirectCode expr = new DirectCode("container.getManager(StageRenderManager.class).getCamera()");						
		return expr;
	}		
}
	