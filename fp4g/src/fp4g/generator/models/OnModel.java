package fp4g.generator.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import fp4g.classes.MessageMethod;
import fp4g.data.On;
import fp4g.data.On.Filter;
import fp4g.data.On.Source;

public class OnModel implements Model
{
	public OnModel(On on)
	{
		name = on.name;
		//code = on.getCode();
		code = "//TODO falta el codigo.."; //TODO falta el codigo
		methodHandlers = new LinkedList<>();
		
		//que hago ahora, necesito filtrar los metodos dejandolos separados
		HashMap<String,MethodHandlerModel> methods = new HashMap<>();

		//por cada source, debo sacar los metodos que son iguales
		for(Source source: on.sources)
		{
			for(Filter f:source.filters)
			{
				final int l = f.lenght();				
				for(int i=0;i<l;i++)
				{
					final MessageMethod method = f.methods[i];
					//encontré un metodo, que hago con el
					MethodHandlerModel m = methods.get(method.getMethodName());
					if(m == null)
					{
						m = new MethodHandlerModel(method);
						methods.put(method.getMethodName(), m);
					}
					//ya tengo el metodo manejador, que hago con el?
					//facil, ahora debes agregar este filtro
					//pero como diferencio si es conjuncion o disyunción?
					//todos los que están en este for, son una conjunción
					FilterD filterD = m.getCurrentFilterD(i);
					filterD.add(method,f.values[i]); //agrego el filtro actual
				}				
				//ahora como agrego otra disyunción?
				//lo haré en currentFilter, guardará la ultima iteración. Si esta cambia, entonces agregará otro filtro.
			}
		}
		//al finalizar
		methodHandlers.addAll(methods.values());
	}
	//que necesito acá
	//Nombre categoria mensaje	
	private final String name;
	//El codigo
	private final String code;
	//Necesitaré una lista de los MethodHandlers!
	private final List<MethodHandlerModel> methodHandlers;
	
	public static class MethodHandlerModel implements Model
	{
		//que necesito acá, por cada MethodHander necesito:
		//Nombre del metodo
		private final String name;
		//Una lista de filtros (disyunción)
		private final List<FilterD> filters;
		
		//este no va para el Freemarker
		private FilterD current;
		private int lastIter;
		public MethodHandlerModel(MessageMethod method)
		{
			name = method.getMethodName();
			filters = new LinkedList<>();
		}
		//devuelve el filtro actual.
		public FilterD getCurrentFilterD(int li) {
			if(current == null)
			{
				createNewFilterD();
				lastIter = li;
				return current;
			}
			if(lastIter != li)
			{
				lastIter = li;
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
		
		public final String getName() {
			return name;
		}
		public final List<FilterD> getFiltersD() {
			return filters;
		}
	}
	public static class FilterD implements Model
	{
		//que necesito acá. Por cada FilterD necesito:
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
	public final String getCode() {
		return code;
	}
	public final List<MethodHandlerModel> getMethodHandlers() {
		return methodHandlers;
	}	
}
