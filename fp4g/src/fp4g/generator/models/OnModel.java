package fp4g.generator.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.antlr.v4.misc.Utils;

import fp4g.classes.MessageMethod;
import fp4g.data.Code;
import fp4g.data.Expresion;
import fp4g.data.On;
import fp4g.data.On.Filter;
import fp4g.data.On.Source;
import fp4g.data.Send;
import fp4g.data.expresion.ClassMap;
import fp4g.data.expresion.Literal;
import fp4g.generator.gdxgenerator.JavaGenerator;

public class OnModel implements Model
{
	//Que necesito ac�:
	//Nombre categoria mensaje	
	private final String name;
	//Necesitar� una lista de los MethodHandlers!
	private final List<MethodHandlerModel> methodHandlers;	
	
	//TODO claramente ac� el generator es una soluci�n parche
	//TODO Lo que paso ac�. Que este modelo empezo a generar codigo. por eso este desasastre...
	public OnModel(On on, JavaGenerator generator)
	{
		name = on.name;		
		methodHandlers = new LinkedList<MethodHandlerModel>();
		HashMap<String,MethodHandlerModel> methods = new HashMap<String, MethodHandlerModel>();
		//agregar los metodos, aunque est�n vacios y asumiento que todos son MessageMethod		
		for(Entry<String,Literal<?>> entry:on.message.entrySet())
		{
			ClassMap map = (ClassMap)entry.getValue();
			methods.put(entry.getKey(), new MethodHandlerModel((MessageMethod)map.getBean()));
		}
		//tengo que recorrer los sources en busca de los methodHandlers y subirlos ac�
		for(Source source:on.sources)
		{			
			SourceModel.findAndInsert(source,methods,generator);
		}
		methodHandlers.addAll(methods.values());		
	}
	
	public static class SourceModel implements Model
	{
		//El codigo
		private final String code;
		//Una lista de filtros (disyunci�n)
		private final List<FilterD> filters;
				
		public SourceModel(Source source, JavaGenerator generator)
		{
			//TODO por ahora traducir� el codigo as�
			if(source.statements != null && source.statements.size() > 0)
			{
				StringBuilder builder = new StringBuilder();
				for(Code stmnt:source.statements)
				{
					//MessageSender.instance().send(receiver, message);
					//TODO por ahora TODOS son Send
					Send send = (Send)stmnt;
					String message = String.format("%1$sMessage.on%2$s%1$s",send.method.getMessage().name,Utils.capitalize(send.method.getName()));
					builder.append("MessageSender.instance().send(this,"); //TODO por ahora solo yo recibo mensajes
					builder.append(message);
					if(send.args != null)
					{
						builder.append(", ");					
						for(Iterator<Expresion> iterator = send.args.iterator();iterator.hasNext();)
						{
							Expresion e = iterator.next();
							builder.append(generator.exprGen.generate(null, e));
							if(iterator.hasNext())
							{
								builder.append(", ");
							}
						}
					}
					builder.append(");\n");
				}				
				code = builder.toString();
			}
			else
			{
			
				code = "//TODO falta el codigo...";
			}			
			
			
			filters = new LinkedList<FilterD>();
		}
		
		public static void findAndInsert(final Source source,final HashMap<String,MethodHandlerModel> methods, JavaGenerator generator)
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
						//encontr� un metodo, que hago con el
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
							sm = new SourceModel(source,generator);
							sourcesMap.put(m, sm);						
						}					
						//ya tengo el metodo manejador, que hago con el?
						//facil, ahora debes agregar este filtro
						//pero como diferencio si es conjuncion o disyunci�n?
						//todos los que est�n en este for, son una conjunci�n
						if(value != null) //me aseguro que sea distinto de nulo, asi no agrega nada adicional
						{
							FilterD filterD = sm.getCurrentFilterD(f);
							filterD.add(method,value); //agrego el filtro actual
						}
					}				
					//ahora como agrego otra disyunci�n?
					//lo har� en currentFilter, guardar� la ultima iteraci�n. Si esta cambia, entonces agregar� otro filtro.
				}
			}
			else //cuando hay 0 filtros
			{
				for(Entry<String,MethodHandlerModel> entry:methods.entrySet())
				{
					//cuando hay 0 filtros, el source se agrega a cada uno de los metodos
					entry.getValue().addSource(new SourceModel(source,generator));					
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
	
		public final String getCode() {
			return code;
		}
		public final List<FilterD> getFiltersD() {
			return filters;
		}
	}
		
	public static class MethodHandlerModel implements Model
	{
		//que necesito ac�, por cada MethodHander necesito:
		//Nombre del metodo
		private final String name;		
		//Una lista de Source Codes
		private final List<SourceModel> sources;
		//Parametros
		private final String params;
				
		public MethodHandlerModel(MessageMethod method)
		{
			name = method.getName();
			params = method.getParams();
			sources = new LinkedList<SourceModel>();			
		}
					
		public void addSource(SourceModel value) {
			sources.add(value);			
		}

		public final String getName() 
		{
			return name;
		}
		public final List<SourceModel> getSources()
		{
			return sources;
		}
		public final String getParams()
		{
			return params;
		}
	}
	public static class FilterD implements Model
	{
		//que necesito ac�. Por cada FilterS necesito:
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
