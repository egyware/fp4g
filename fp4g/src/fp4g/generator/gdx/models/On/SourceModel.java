package fp4g.generator.gdx.models.On;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.misc.Utils;

import fp4g.data.Expresion;
import fp4g.data.ILine;
import fp4g.data.On;
import fp4g.data.define.Message;
import fp4g.data.statements.Destroy;
import fp4g.data.statements.Filter;
import fp4g.data.statements.Send;
import fp4g.data.statements.Source;
import fp4g.data.statements.Subscribe;
import fp4g.data.statements.Unsubscribe;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.generator.Depend;
import fp4g.generator.Model;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.DestroyStatementModel;
import fp4g.generator.gdx.models.JavaCodeModel;
import fp4g.generator.gdx.models.SendStatementModel;
import fp4g.generator.gdx.models.StatementModel;
import fp4g.generator.gdx.models.SubscribeStatementModel;
import fp4g.log.Log;
import fp4g.log.info.Warn;

public class SourceModel implements Model
{
	//El codigo
	private final List<StatementModel> statements;
	//Una lista de filtros (disyunción)
	private final List<FiltersD> filters;
	
	public SourceModel(final Source source,final On on,final JavaCodeModel model, final JavaGenerator generator)
	{		
		filters = new LinkedList<FiltersD>();
		if(source.statements != null && source.statements.size() > 0)
		{
			statements = new LinkedList<StatementModel>();
			
			//TODO vamos por parte, hoy no arreglaré toda la embarrada con el codigo ON
			for(ILine stmnt:source.statements)
			{			
					if(stmnt instanceof Subscribe)
					{
						Subscribe subscribe = (Subscribe)stmnt;
						SubscribeStatementModel subscribeModel = new SubscribeStatementModel(subscribe,on.message.isFactory());
						statements.add(subscribeModel);
						
						try 
						{
							Depend resolve = generator.resolveDependency(subscribe.instance);
							resolve.perform(subscribe.instance, model);
						}
						catch (DependResolverNotFoundException e1) 
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
							model.addImport("com.apollo.message.".concat(subscribe.message.name).concat("Message"));
						}
					}
					else
					if(stmnt instanceof Unsubscribe)
					{
						Unsubscribe unsubscribe = (Unsubscribe)stmnt;
						SubscribeStatementModel subscribeModel = new SubscribeStatementModel(unsubscribe,on.message.isFactory());
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
							model.addImport("com.apollo.message.".concat(unsubscribe.message.name).concat("Message"));
						}
					}
					if(stmnt instanceof Destroy)
					{
						Destroy destroy = (Destroy)stmnt;
						DestroyStatementModel  destroyModel = new DestroyStatementModel(destroy);
						statements.add(destroyModel);
						
					}else
					if(stmnt instanceof Send)
					{
						//MessageSender.instance().send(receiver, message);
						Send send = (Send)stmnt;
						
						//construir acá la instrucción sendModel
						Message msg = send.method.getMessage();
						
						final String message;						
						final String to;
						final boolean direct;
						
						switch(send.toReceiverType)
						{
						case Game:
							message = String.format("%1$sMessage.on%2$s%1$s",msg.name,Utils.capitalize(send.method.name));
							direct = false;
							if(on.message.isFactory())
							{
								to = "container.gameManager";
							}
							else
							{
								to = "world.gameManager";
							}
							break;
						case Other:
							to = "other";
							message = String.format("%1$sMessage.on%2$s%1$s",msg.name,Utils.capitalize(send.method.name));
							direct = false;
							break;
						case Behavior:
							if(on.message.isFactory())
							{
								to = "entity.".concat(Utils.decapitalize(send.toReceiverName));
							}
							else
							{
								to = "this.".concat(Utils.decapitalize(send.toReceiverName));
							}
							message = String.format("on%2$s%1$s",msg.name,Utils.capitalize(send.method.name));
							direct = true;
							break;
						case System:
							to = "world.getManager(".concat(send.toReceiverName).concat(".class)");
							message = String.format("on%2$s%1$s",msg.name,Utils.capitalize(send.method.name));
							direct = true;
							
							try 
							{
								Depend resolve = generator.resolveDependency(send.toReceiverSystem);
								resolve.perform(send.toReceiverSystem, model);
							}
							catch (DependResolverNotFoundException e1) 
							{
								Log.Exception(e1, send.getLine());
								model.addImport("com.apollo.managers.".concat(send.toReceiverName));
							}
							break;
						case Self:
						default:
							to = "this";
							message = String.format("%1$sMessage.on%2$s%1$s",msg.name,Utils.capitalize(send.method.name));
							direct = false;
							break;
						}	
						
						SendStatementModel sendModel = new SendStatementModel(message,to, direct);
						try
						{
							if(send.args != null && send.args.size() > 0)
							{
								List<String> params = sendModel.getParams();
								for(Expresion expr:send.args)
								{
									params.add(generator.expresion(model, expr));
								}						
							}
						}
						catch(CannotEvalException gex)
						{
							//TODO error mal escrito, deberia haber cada uno de sus hijos de la excepcion y por cada uno un mensaje personalizado 
							Log.Show(Warn.CannotEvalExpr,gex.getMessage());
						}
						statements.add(sendModel);									
						try {
							Depend depend = generator.resolveDependency(msg);
							depend.perform(msg, model);
						} catch (DependResolverNotFoundException e) {
							Log.Show(Warn.DependResolverNotFound,msg);
							e.printStackTrace();
						}				
					}
					
									
											
				}
		}
		else
		{
			statements = null;
		}		
	}
	
	//este no va para el Freemarker
	private FiltersD current;
	private Filter lastFilterIter;
	//devuelve el filtro actual.
	public FiltersD getCurrentFilterD(Filter lf) {
		if(current == null)
		{
			createNewFilterD();
			lastFilterIter = lf;
			return current;
		}
		if(lastFilterIter != lf)
		{
			lastFilterIter = lf;
			createNewFilterD();
		}
		return current;
	}
	
	//guarda y crea otro filtro D
	private void createNewFilterD()
	{			
		current = new FiltersD();	
		filters.add(current);
	}

	public final List<StatementModel> getStatements() {
		return statements;
	}
	
	public final List<FiltersD> getFilters() {
		return filters;
	}
}
		
	