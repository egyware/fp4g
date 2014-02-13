package fp4g.generator.gdx.models.On;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.statements.Filter;
import fp4g.data.statements.Source;
import fp4g.generator.Model;
import fp4g.generator.gdx.models.StatementModel;

public class SourceModel implements Model
{
	//El codigo
	private final List<StatementModel> statements;
	//Una lista de filtros (disyunción)
	private final List<FiltersD> filters;
	
	public SourceModel(Source source)
	{
		filters = new LinkedList<FiltersD>();
		if(source.statements != null && source.statements.size() > 0)
		{
			statements = new LinkedList<StatementModel>();
		}
		else
		{
			statements = null;
		}
		//TODO falta traducir los statements...
	}
	
//	public SourceModel(On on,Source source, JavaGenerator generator,JavaCodeModel model)
//	{			
//		filters = new LinkedList<FiltersD>();
//		if(source.statements != null && source.statements.size() > 0)
//		{
//			statements = new LinkedList<StatementModel>();
//			for(ILine stmnt:source.statements)
//			{					
//				if(stmnt instanceof Destroy)
//				{
//					Destroy destroy = (Destroy)stmnt;
//					DestroyStatementModel  destroyModel = new DestroyStatementModel(destroy);
//					statements.add(destroyModel);
//					
//				}else
//				if(stmnt instanceof Send)
//				{
//					//MessageSender.instance().send(receiver, message);
//					Send send = (Send)stmnt;
//					
//					//construir acá la instrucción sendModel
//					Message msg = send.method.getMessage();
//					
//					final String message;						
//					final String to;
//					final boolean direct;
//					
//					switch(send.toReceiverType)
//					{
//					case Game:
//						message = String.format("%1$sMessage.on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
//						direct = false;
//						if(on.message.isFactory())
//						{
//							to = "container.gameManager";
//						}
//						else
//						{
//							to = "world.gameManager";
//						}
//						break;
//					case Other:
//						to = "other";
//						message = String.format("%1$sMessage.on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
//						direct = false;
//						break;
//					case Behavior:
//						if(on.message.isFactory())
//						{
//							to = "entity.".concat(Utils.decapitalize(send.toReceiverName));
//						}
//						else
//						{
//							to = "this.".concat(Utils.decapitalize(send.toReceiverName));
//						}
//						message = String.format("on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
//						direct = true;
//						break;
//					case System:
//						to = "world.getManager(".concat(send.toReceiverName).concat(".class)");
//						message = String.format("on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
//						direct = true;
//						
//						try 
//						{
//							Depend resolve = generator.resolveDependency(send.toReceiverSystem);
//							resolve.perform(send.toReceiverSystem, model);
//						}
//						catch (DependResolverNotFoundException e1) 
//						{
//							Log.Exception(e1, send.getLine());
//							model.addImport("com.apollo.managers.".concat(send.toReceiverName));
//						}
//						break;
//					case Self:
//					default:
//						to = "this";
//						message = String.format("%1$sMessage.on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
//						direct = false;
//						break;
//					}	
//					
//					SendStatementModel sendModel = new SendStatementModel(message,to, direct);
//					try
//					{
//						if(send.args != null && send.args.size() > 0)
//						{
//							List<String> params = sendModel.getParams();
//							for(Expresion expr:send.args)
//							{
//								params.add(generator.expresion(model, expr));
//							}						
//						}
//					}
//					catch(CannotEvalException gex)
//					{
//						//TODO error mal escrito, deberia haber cada uno de sus hijos de la excepcion y por cada uno un mensaje personalizado 
//						Log.Show(Warn.CannotEvalExpr,gex.getMessage());
//					}
//					statements.add(sendModel);									
//					try {
//						Depend depend = generator.resolveDependency(msg);
//						depend.perform(msg, model);
//					} catch (DependResolverNotFoundException e) {
//						Log.Show(Warn.DependResolverNotFound,msg);
//						e.printStackTrace();
//					}				
//				}
//				
//								
//										
//			}
//		}
//		else
//		{
//			statements = null;
//		}
//	}
	
	
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
		
	