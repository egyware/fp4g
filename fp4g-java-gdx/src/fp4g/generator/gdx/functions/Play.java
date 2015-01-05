package fp4g.generator.gdx.functions;

import fp4g.core.Expresion;
import fp4g.data.Container;
import fp4g.data.ExprList;
import fp4g.data.IDefine;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.literals.StringLiteral;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.gdx.GdxFunction;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

public class Play extends GdxFunction
{

	public Play() 
	{
		super("PLAY");	
	}

	@Override
	public Expresion generate(JavaGenerator generator, JavaMetaSourceModel model, FunctionCall call, IDefine current, Container container, ExprList list)
	throws CannotEvalException 
	{
		//primero que todo debo sacar las expresiones
		final int size = list.size();
		if(size != 1) //debe tener por lo menos un parametro
		{
			throw new CannotEvalException(CannotEvalException.Types.CannotEvalExpresion, (Expresion)call, "Se esperan más argumentos(1)");
		}
		Expresion _0 = list.get(0);
		final StringLiteral assetName;		
		if(_0 instanceof StringLiteral)
		{
			assetName = (StringLiteral) _0;
		}
		else
		{
			throw new CannotEvalException(CannotEvalException.Types.IncomplatibleTypes, _0, "No es del tipo StringLiteral");
		}		
		model.addRequireSource("com.badlogic.gdx.audio.Sound");
		
		return new DirectCode(String.format("((Sound)container.gameManager.assets.get(%s)).play()",generator.expresion(model, null, (Expresion)assetName)));
	}

}
