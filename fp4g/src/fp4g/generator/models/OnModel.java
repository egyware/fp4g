package fp4g.generator.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import fp4g.classes.MessageMethod;
import fp4g.data.On;
import fp4g.data.On.Filter;
import fp4g.data.On.Source;
import fp4g.data.expresion.ClassMap;

public class OnModel implements Model
{
	//Que necesito ac�:
	//Nombre categoria mensaje	
	private final String name;
	//Necesitar� una lista de los MethodHandlers!
	private final List<MethodHandlerModel> methodHandlers;	
	
	
	public OnModel(On on)
	{
		name = on.name;		
		methodHandlers = new LinkedList<>();
		HashMap<String,MethodHandlerModel> methods = new HashMap<>();
		//agregar los metodos, aunque est�n vacios y asumiento que todos son MessageMethod		
		for(Entry<String,Object> entry:on.message.entrySet())
		{
			ClassMap map = (ClassMap)entry.getValue();
			methods.put(entry.getKey(), new MethodHandlerModel((MessageMethod)map.getBean()));
		}
		//tengo que recorrer los sources en busca de los methodHandlers y subirlos ac�
		for(Source source:on.sources)
		{			
			SourceModel.findAndInsert(source,methods);
		}
		methodHandlers.addAll(methods.values());		
	}
	
	public static class SourceModel implements Model
	{
		//El codigo
		private final String code;
		//Una lista de filtros (disyunci�n)
		private final List<FilterD> filters;
				
		public SourceModel(Source source)
		{
			//code = on.getCode();
			code = "//TODO falta el codigo.."; //TODO falta el codigo
			filters = new LinkedList<>();
		}
		
		public static void findAndInsert(final Source source,final HashMap<String,MethodHandlerModel> methods)
		{			
			final HashMap<MethodHandlerModel,SourceModel> sourcesMap = new HashMap<>();
			
			for(Filter f:source.filters)
			{
				final int l = f.lenght();				
				for(int i=0;i<l;i++)
				{
					final MessageMethod method = f.methods[i];
					final String value = f.values[i];
					//encontr� un metodo, que hago con el
					MethodHandlerModel m = methods.get(method.getMethodName());
					
					if(m == null)
					{
						m = new MethodHandlerModel(method);
						methods.put(method.getMethodName(), m);
					}

					//obtengo el source model correspondiente 
					SourceModel sm = sourcesMap.get(m);
					if(sm == null)
					{
						sm = new SourceModel(source);
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
			name = method.getMethodName();
			params = method.getParams();
			sources = new LinkedList<>();			
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
			conjunciones = new LinkedList<>();
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
