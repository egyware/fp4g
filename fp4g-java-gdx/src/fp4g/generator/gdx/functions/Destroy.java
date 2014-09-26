package fp4g.generator.gdx.functions;

import fp4g.data.Container;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.gdx.GdxFunction;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

public class Destroy extends GdxFunction
{

	public Destroy() 
	{
		super("DESTROY");	
	}

	@Override
	public Expresion generate(JavaGenerator generator, JavaMetaSourceModel model, FunctionCall call, IDefine current, Container container, ExprList list)
	throws CannotEvalException 
	{
		//primero que todo debo sacar las expresiones
		final int size = (list!=null)?list.size():0;
		if(size != 0) //debe tener por lo menos un parametro
		{
			throw new CannotEvalException(CannotEvalException.Types.CannotEvalExpresion, (Expresion)call, "Se esperan más argumentos(0)");
		}
		
		return new DirectCode(String.format("getWorld().deleteEntity(%s.this)",current.getName()));
	}

}
