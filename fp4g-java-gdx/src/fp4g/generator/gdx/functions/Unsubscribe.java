package fp4g.generator.gdx.functions;

import org.antlr.v4.misc.Utils;

import fp4g.data.Add;
import fp4g.data.Container;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.IValue;
import fp4g.data.On;
import fp4g.data.define.Manager;
import fp4g.data.define.Message;
import fp4g.data.expresion.AddExpr;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.ManagerExpr;
import fp4g.data.expresion.ToExpr;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.generator.Depend;
import fp4g.generator.gdx.GdxFunction;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.log.Log;

public class Unsubscribe extends GdxFunction
{

	public Unsubscribe() 
	{
		super("UNSUBSCRIBE");	
	}

	@Override
	public Expresion generate(JavaGenerator generator, JavaMetaSourceModel model, FunctionCall call, IDefine current, Container container, ExprList list)
	throws CannotEvalException 
	{
		//primero que todo debo sacar las expresiones
		final int size = (list != null)?list.size():0;
		if(size != 2) //debe tener por lo menos un parametro
		{
			throw new CannotEvalException(CannotEvalException.Types.CannotEvalExpresion, (Expresion)call, "Se esperan más argumentos(2)");
		}
		Expresion _0 = list.get(0);
		Expresion _1 = list.get(1);		
		final AddExpr onExpr;
		final ToExpr toExpr;
		if(_0 instanceof AddExpr)
		{
			onExpr = (AddExpr)_0;		
		}
		else
		{
			throw new CannotEvalException(CannotEvalException.Types.IncomplatibleTypes, _0, "No es del tipo DefineAddExpr");
		}
		if(_1 instanceof ToExpr)
		{
			toExpr = (ToExpr) _1;
		}
		else
		{
			throw new CannotEvalException(CannotEvalException.Types.IncomplatibleTypes, _1, "No es del tipo ToExpr");
		}		
		final On on = (On)container;
		final String instance = (on.message.isFactory())?"entity":"owner";
		final IValue<?> toValue = toExpr.eval(current);
		final String to = generator.expresion(model, container, toValue);
		final Add add = (Add) onExpr.eval(current).getValue();
		
		final String onString = String.format("%1$sMessage.on%2$s%1$s", add.container.getName(),Utils.capitalize(add.name));
		
		final Message msg = (Message)add.container;		
		
		try 
		{			
			Depend depend = generator.resolveDependency(msg);
			depend.perform(msg, model);
		} 
		catch (DependResolverNotFoundException e)
		{
			Log.Exception(e, msg.getLine());					
		}
		
		if(toValue instanceof ManagerExpr)
		{
			Manager mngr = (Manager)toValue.getValue();
			try 
			{			
				Depend depend = generator.resolveDependency(mngr);
				depend.perform(mngr, model);
			} 
			catch (DependResolverNotFoundException e)
			{
				Log.Exception(e, mngr.getLine());					
			}
		}
		
		if(to.length() > 0)
		{
			return new DirectCode(String.format("%s.removeEventHandler(%s,%s)",to,onString,instance));
		}
		else
		{
			return new DirectCode(String.format("removeEventHandler(%s,%s)",onString,instance));
		}		
	}

}
