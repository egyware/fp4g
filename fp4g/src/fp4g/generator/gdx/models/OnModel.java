package fp4g.generator.gdx.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.antlr.v4.misc.Utils;

import fp4g.classes.MessageMethod;
import fp4g.data.Expresion;
import fp4g.data.ICode;
import fp4g.data.IValue;
import fp4g.data.On;
import fp4g.data.On.Filter;
import fp4g.data.On.Source;
import fp4g.data.define.Message;
import fp4g.data.expresion.ClassMap;
import fp4g.data.statements.Destroy;
import fp4g.data.statements.Send;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.exceptions.CannotEvalException;
import fp4g.generator.Depend;
import fp4g.generator.Model;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.log.Log;
import fp4g.log.info.Warn;

public class OnModel implements Model
{
	//Nombre categoria mensaje	
	private final String name;
	//Necesitaré una lista de los MethodHandlers!
	private final List<MethodHandlerModel> methodHandlers;	
	
	//TODO claramente acá el generator es una solución parche
	//TODO Lo que paso acá. Que este modelo empezo a generar codigo. por eso este desasastre...	
	public OnModel(On on, JavaGenerator generator,JavaCodeModel model)
	{
		name = on.name;
		model.addInterface(String.format("%sMessageHandler",name));
		methodHandlers = new LinkedList<MethodHandlerModel>();
		HashMap<String,MethodHandlerModel> methods = new HashMap<String, MethodHandlerModel>();
		//agregar los metodos, aunque están vacios y asumiento que todos son MessageMethod
		//TODO da un error cuando el mensaje está sin definir		
		for(Entry<String,IValue<?>> entry:on.message.entrySet())
		{	
			IValue<?> value = entry.getValue();
			if(value instanceof ClassMap)
			{
				Object bean = ((ClassMap<?>)value).getValue();				
				if(bean instanceof MessageMethod)
				{
					methods.put(entry.getKey(), new MethodHandlerModel((MessageMethod) bean));
				}
			}
		}
		//tengo que recorrer los sources en busca de los methodHandlers y subirlos acï¿½
		for(Source source:on.sources)
		{			
			SourceModel.findAndInsert(on,source,methods,generator,model);
		}
		methodHandlers.addAll(methods.values());		
	}
	
	public static class SourceModel implements Model
	{
		//El codigo
		private final List<StatementModel> statements;
		//Una lista de filtros (disyunción)
		private final List<FilterD> filters;
				
		public SourceModel(On on,Source source, JavaGenerator generator,JavaCodeModel model)
		{			
			filters = new LinkedList<FilterD>();
			if(source.statements != null && source.statements.size() > 0)
			{
				statements = new LinkedList<StatementModel>();
				for(ICode stmnt:source.statements)
				{	
					
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
						case Other:
							to = "other";
							message = String.format("%1$sMessage.on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
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
							message = String.format("on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
							direct = true;
							break;
						case System:
							to = "world.getManager(".concat(send.toReceiverName).concat(".class)");
							message = String.format("on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
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
							message = String.format("%1$sMessage.on%2$s%1$s",msg.name,Utils.capitalize(send.method.getName()));
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
		
		public static void findAndInsert(final On on,final Source source,final HashMap<String,MethodHandlerModel> methods, JavaGenerator generator,JavaCodeModel model)
		{			
			final HashMap<MethodHandlerModel,SourceModel> sourcesMap = new HashMap<MethodHandlerModel, SourceModel>();
			
			if(source.filters.size() > 0)
			{
				for(Filter f:source.filters)
				{
					final int l = f.lenght();				
					for(int i=0;i<l;i++)
					{
						final MessageMethod method = f.methods[i];
						final String value = f.values[i];
						//encontrï¿½ un metodo, que hago con el
						MethodHandlerModel m = methods.get(method.getName());
						
//						if(m == null) //siempre son != null
//						{
//							m = new MethodHandlerModel(method);
//							methods.put(method.getMethodName(), m);
//						}
	
						//obtengo el source model correspondiente 
						SourceModel sm = sourcesMap.get(m);
						if(sm == null)
						{
							sm = new SourceModel(on,source,generator,model);
							sourcesMap.put(m, sm);						
						}					
						//ya tengo el metodo manejador, que hago con el?
						//facil, ahora debes agregar este filtro
						//pero como diferencio si es conjuncion o disyunciï¿½n?
						//todos los que estï¿½n en este for, son una conjunciï¿½n
						if(value != null) //me aseguro que sea distinto de nulo, asi no agrega nada adicional
						{
							FilterD filterD = sm.getCurrentFilterD(f);
							filterD.add(method,value); //agrego el filtro actual
						}
					}				
					//ahora como agrego otra disyunciï¿½n?
					//lo harï¿½ en currentFilter, guardarï¿½ la ultima iteraciï¿½n. Si esta cambia, entonces agregarï¿½ otro filtro.
				}
			}
			else //cuando hay 0 filtros
			{
				for(Entry<String,MethodHandlerModel> entry:methods.entrySet())
				{
					//cuando hay 0 filtros, el source se agrega a cada uno de los metodos
					entry.getValue().addSource(new SourceModel(on,source,generator,model));					
				}
			}
			//al finalizar
			for(Entry<MethodHandlerModel, SourceModel> entry:sourcesMap.entrySet())
			{
				entry.getKey().addSource(entry.getValue());
			}
		}
		//este no va para el Freemarker
		private FilterD current;
		private Filter lastFilterIter;
		//devuelve el filtro actual.
		public FilterD getCurrentFilterD(Filter lf) {
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
			current = new FilterD();	
			filters.add(current);
		}
	
		public final List<StatementModel> getStatements() {
			return statements;
		}
		public final List<FilterD> getFiltersD() {
			return filters;
		}
	}
		
	public static final class MethodHandlerModel implements Model
	{
		//que necesito acï¿½, por cada MethodHander necesito:
		//Nombre del metodo
		private final String name;		
		//Una lista de Source Codes
		private final List<SourceModel> sources;
		//Parametros
		private final String params;
		//Se requiere attach?
		private final boolean attachMethod;
				
		public MethodHandlerModel(MessageMethod method)
		{
			name = method.getName();
			params = method.getParams();
			sources = new LinkedList<SourceModel>();
			attachMethod = method.isAttachInputProcessor();
		}
					
		public void addSource(SourceModel value) {
			sources.add(value);			
		}

		public String getName() 
		{
			return name;
		}
		public List<SourceModel> getSources()
		{
			return sources;
		}
		public String getParams()
		{
			return params;
		}
		public boolean isAttach()
		{
			return attachMethod;
		}
	}
	public static class FilterD implements Model
	{
		//que necesito acï¿½. Por cada FilterS necesito:
		//Una lista de conjunciones
		private final List<String> conjunciones;
		
		public FilterD()
		{
			conjunciones = new LinkedList<String>();
		}
		public void add(MessageMethod method, String value) {
			conjunciones.add(String.format(method.getValueReplace(),value));			
		}
		
		public List<String> getFiltersC()
		{
			return conjunciones;
		}
	}
	public final String getName() {
		return name;
	}
	public final List<MethodHandlerModel> getMethodHandlers() {
		return methodHandlers;
	}	
}
