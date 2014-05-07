package fp4g.generator.gdx;

import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

public abstract class GdxFunction
{
	public abstract Expresion generate(JavaGenerator generator, JavaMetaSourceModel model, ExprList list) throws CannotEvalException;
}