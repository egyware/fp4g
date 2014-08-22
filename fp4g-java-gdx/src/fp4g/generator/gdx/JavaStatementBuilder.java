package fp4g.generator.gdx;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.misc.Utils;

import fp4g.data.Expresion;
import fp4g.data.ILine;
import fp4g.data.On;
import fp4g.data.Statement;
import fp4g.data.Statements;
import fp4g.data.define.Message;
import fp4g.data.statements.Assignment;
import fp4g.data.statements.Destroy;
import fp4g.data.statements.Send;
import fp4g.data.statements.Subscribe;
import fp4g.data.statements.Unsubscribe;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.exceptions.FP4GException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.generator.Depend;
import fp4g.generator.StatementModel;
import fp4g.generator.gdx.models.AssignmentModel;
import fp4g.generator.gdx.models.DestroyStatementModel;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.generator.gdx.models.SendStatementModel;
import fp4g.generator.gdx.models.SubscribeStatementModel;
import fp4g.log.FP4GError;
import fp4g.log.Log;

public class JavaStatementBuilder {
	private JavaGenerator generator;

	public JavaStatementBuilder(JavaGenerator generator) {
		this.generator = generator;
	}

	public List<StatementModel> generateStatements(JavaMetaSourceModel model,ILine container, Statements stmnts) throws FP4GException 
	{
		LinkedList<StatementModel> statements = new LinkedList<StatementModel>();
		for (Statement stmnt : stmnts) 
		{
			switch(stmnt.statementType)
			{
			case Assignment:
			{
				Assignment assignment = (Assignment)stmnt;				
				AssignmentModel assignmentModel = new AssignmentModel(assignment.varName,generator.expresion(model, assignment.expresion));
				statements.add(assignmentModel);
			}
				break;
			case Destroy:
			{
				Destroy destroy = (Destroy) stmnt;
				DestroyStatementModel destroyModel = new DestroyStatementModel(destroy);
				statements.add(destroyModel);
			}
				break;
			case Send:
			{
				// MessageSender.instance().send(receiver, message);
				Send send = (Send) stmnt;

				// construir acá la instrucción sendModel
				Message msg = send.method.getMessage();

				final String message;
				final String to;
				final boolean direct;

				final On on = (On)container;
				switch (send.toReceiverType) 
				{
				case Game:
					message = String.format("%1$sMessage.on%2$s%1$s", msg.name,	Utils.capitalize(send.method.name));
					direct = false;
					if (on.message.isFactory())
					{
						to = "container.gameManager";
					} else {
						to = "world.gameManager";
					}
					break;
				case Other:
					to = "other";
					message = String.format("%1$sMessage.on%2$s%1$s", msg.name,	Utils.capitalize(send.method.name));
					direct = false;
					break;
				case Behavior:
					if (on.message.isFactory()) 
					{
						to = "entity.".concat(Utils.decapitalize(send.toReceiverName));
					} else {
						to = "this.".concat(Utils.decapitalize(send.toReceiverName));
					}
					message = String.format("on%2$s%1$s", msg.name,	Utils.capitalize(send.method.name));
					direct = true;
					break;
				case System:
					to = "world.getManager(".concat(send.toReceiverName).concat(".class)");
					message = String.format("%1sMessage.on%2$s%1$s", msg.name,	Utils.capitalize(send.method.name));
					direct = false;

					try 
					{
						Depend resolve = generator.resolveDependency(send.toReceiverSystem);
						resolve.perform(send.toReceiverSystem, model);
					} 
					catch (DependResolverNotFoundException e1) 
					{
						Log.Exception(e1, send.getLine());
						model.addRequireSource("com.apollo.managers."
								.concat(send.toReceiverName));
					}
					break;
				case Self:
				default:					
					to = String.format("%s.this", model.getName());
					message = String.format("%1$sMessage.on%2$s%1$s", msg.name,
							Utils.capitalize(send.method.name));
					direct = false;
					break;
				}

				SendStatementModel sendModel = new SendStatementModel(message, to, direct);
				
				if (send.args != null && send.args.size() > 0)
				{
					List<String> params = sendModel.getParams();						
					for (Expresion expr : send.args) 
					{
						params.add(generator.expresion(model, expr));
					}
				}				
				statements.add(sendModel);
				try {
					Depend depend = generator.resolveDependency(msg);
					depend.perform(msg, model);
				} catch (DependResolverNotFoundException e)
				{
					Log.Exception(e, msg.getLine());					
				}
			}
				break;
			case Subscribe:
			{
				final On on = (On)container;
				Subscribe subscribe = (Subscribe) stmnt;
				SubscribeStatementModel subscribeModel = new SubscribeStatementModel(subscribe, on.message.isFactory());
				statements.add(subscribeModel);

				try 
				{
					Depend resolve = generator.resolveDependency(subscribe.instance);
					resolve.perform(subscribe.instance, model);
				} catch (DependResolverNotFoundException e1) 
				{
					Log.Exception(e1, subscribe.getLine());
				}

				try 
				{
					Depend resolve = generator.resolveDependency(subscribe.message);
					resolve.perform(subscribe.message, model);
				} 
				catch (DependResolverNotFoundException e1) 
				{
					Log.Exception(e1, subscribe.getLine());
					model.addRequireSource("com.apollo.message.".concat(
							subscribe.message.name).concat("Message"));
				}
			}
				break;
			case Unsubscribe:
			{
				final On on = (On)container;
				Unsubscribe unsubscribe = (Unsubscribe) stmnt;
				SubscribeStatementModel subscribeModel = new SubscribeStatementModel(unsubscribe, on.message.isFactory());
				statements.add(subscribeModel);

				try 
				{
					Depend resolve = generator.resolveDependency(unsubscribe.instance);
					resolve.perform(unsubscribe.instance, model);
				}
				catch (DependResolverNotFoundException e1) 
				{
					Log.Exception(e1, unsubscribe.getLine());
				}

				try 
				{
					Depend resolve = generator.resolveDependency(unsubscribe.message);
					resolve.perform(unsubscribe.message, model);
				}
				catch (DependResolverNotFoundException e1)
				{
					Log.Exception(e1, unsubscribe.getLine());
					model.addRequireSource("com.apollo.message.".concat(
							unsubscribe.message.name).concat("Message"));
				}
			}
				break;
			default:
				throw new FP4GRuntimeException(FP4GError.IllegalState, "Estado Ilegal, añadio una nueva Statement?");
			}			
		}
		return statements;
	}

}
