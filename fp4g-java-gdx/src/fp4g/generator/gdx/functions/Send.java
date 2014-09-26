package fp4g.generator.gdx.functions;

import java.util.Iterator;

import fp4g.data.Container;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.define.Message;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.MessageExpr;
import fp4g.data.expresion.ToExpr;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.generator.Depend;
import fp4g.generator.gdx.GdxFunction;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.log.Log;

public class Send extends GdxFunction
{

	public Send() 
	{
		super("SEND");	
	}

	@Override
	public Expresion generate(JavaGenerator generator, JavaMetaSourceModel model, FunctionCall call, IDefine current, Container container, ExprList list)
	throws CannotEvalException 
	{
		//primero que todo debo sacar las expresiones
		final int size = list.size();
		if(size < 1 && size > 2) //debe tener por lo menos un parametro
		{
			throw new CannotEvalException(CannotEvalException.Types.CannotEvalExpresion, (Expresion)call, "Se esperan más argumentos(1 o 2)");
		}
		Expresion _0 = list.get(0);
		final MessageExpr mensajeExpr;
		final ToExpr destinoExpr;
		if(_0 instanceof MessageExpr)
		{
			mensajeExpr = (MessageExpr) _0;
		}
		else
		{
			throw new CannotEvalException(CannotEvalException.Types.IncomplatibleTypes, _0, "No es del tipo MessageExpr");
		}
		if(size == 2)
		{
			Expresion _1 = list.get(1);
			if(_1 instanceof ToExpr)
			{
				destinoExpr = (ToExpr) _1;
			}
			else
			{
				throw new CannotEvalException(CannotEvalException.Types.IncomplatibleTypes, _1, "No es del tipo ToExpr");
			}			
		}
		else
		{
			destinoExpr = ToExpr.SELF;
		}
		//tenemos listo el mensaje y el destino, que sigue ahora?
		
		//traducir el destino
		String to = generator.expresion(model, null, destinoExpr.eval(current));		
		
		//traducir el mensaje
		String message = generator.expresion(model, null, mensajeExpr.eval(current));
		//traducir los parametros
		StringBuilder builder = new StringBuilder();
		for(Iterator<Expresion> it = mensajeExpr.exprList.iterator();it.hasNext();)
		{
			Expresion expresion = it.next();
			builder.append(generator.expresion(model, container, expresion.eval(container)));
			if(it.hasNext())
			{
				builder.append(", ");
			}
		}
		
		Message msg = mensajeExpr.method.getMessage();
		try 
		{			
			Depend depend = generator.resolveDependency(msg);
			depend.perform(msg, model);
		} 
		catch (DependResolverNotFoundException e)
		{
			Log.Exception(e, msg.getLine());					
		}
		
		if(to.length() > 0)
		{			
			return new DirectCode(String.format("%s.onMessage(%s,%s)", to,message,builder.toString()));
		}
		else
		{
			return new DirectCode(String.format("onMessage(%s,%s)",message,builder.toString()));
		}
		
		

//			// MessageSender.instance().send(receiver, message);
//			Send send = (Send) stmnt;
//
//			// construir acá la instrucción sendModel
//			Message msg = send.method.getMessage();
//
//			final String message;
//			final String to;
//			final boolean direct;
//
//			final On on = (On)container;
//			switch (send.toReceiverType) 
//			{
//			case Game:
//				message = String.format("%1$sMessage.on%2$s%1$s", msg.name,	Utils.capitalize(send.method.name));
//				direct = false;
//				to = "container.gameManager";					
//				break;
//			case Other:
//				to = "other";
//				message = String.format("%1$sMessage.on%2$s%1$s", msg.name,	Utils.capitalize(send.method.name));
//				direct = false;
//				break;
//			case Behavior:
//				if (on.message.isFactory()) 
//				{
//					to = "entity.".concat(Utils.decapitalize(send.toReceiverName));
//				} else {
//					to = "this.".concat(Utils.decapitalize(send.toReceiverName));
//				}
//				message = String.format("on%2$s%1$s", msg.name,	Utils.capitalize(send.method.name));
//				direct = true;
//				break;
//			case System:
//				to = "container.getManager(".concat(send.toReceiverName).concat(".class)");
//				message = String.format("%1sMessage.on%2$s%1$s", msg.name,	Utils.capitalize(send.method.name));
//				direct = false;
//
//				try 
//				{
//					Depend resolve = generator.resolveDependency(send.toReceiverSystem);
//					resolve.perform(send.toReceiverSystem, model);
//				} 
//				catch (DependResolverNotFoundException e1) 
//				{
//					Log.Exception(e1, send.getLine());
//					model.addRequireSource("com.apollo.managers."
//							.concat(send.toReceiverName));
//				}
//				break;
//			case Self:
//			default:					
//				to = String.format("%s.this", model.getName());
//				message = String.format("%1$sMessage.on%2$s%1$s", msg.name,
//						Utils.capitalize(send.method.name));
//				direct = false;
//				break;
//			}
//
//			SendStatementModel sendModel = new SendStatementModel(message, to, direct);
//			
//			if (send.args != null && send.args.size() > 0)
//			{
//				List<String> params = sendModel.getParams();						
//				for (Expresion expr : send.args) 
//				{
//					params.add(generator.expresion(model, expr));
//				}
//			}				
//			statements.add(sendModel);

//		}
//			break;		
	}

}
