package fp4g.generator.gdx.models;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.On;
import fp4g.generator.Model;
import fp4g.generator.gdx.models.On.MethodHandlerModel;


/**
 * La funcion de OnModel es almacenar el nombre del mensaje y metodos.
 * 
 * Esta  clase almacena el nombre de los mensajes y una lista de modelos de metodos quien contienen el codigo y los filtros asociados.
 * 
 * @author Edgardo
 *
 */
public class OnModel implements Model
{
	//Nombre categoria mensaje	
	private final String name;
	//Necesitaré una lista de los MethodHandlers!
	private final List<MethodHandlerModel> methodHandlers;	
	
	public OnModel(On on) 
	{
		name = on.name;
		methodHandlers = new LinkedList<MethodHandlerModel>();
	}
		
//	public static void findAndInsert(final On on,final Source source,final HashMap<String,MethodHandlerModel> methods, JavaGenerator generator,JavaCodeModel model) throws CannotEvalException
//	{			
//		final HashMap<MethodHandlerModel,SourceModel> sourcesMap = new HashMap<MethodHandlerModel, SourceModel>();
//		
//		if(source.filters.size() > 0)
//		{
//			for(AndFilters f:source.filters)
//			{
//				final int l = f.size();				
//				for(Filter filter: f.filters)
//				{
//					final MessageMethod method = filter.method;
//					final String value = (filter.exprList != null && filter.exprList.size()>0)?generator.expresion(null, filter.exprList.get(0)):null; //de hecho deberia capturar aqui los errores
//					
//					//encontrï¿½ un metodo, que hago con el
//					MethodHandlerModel m = methods.get(method.getName());
//					
////						if(m == null) //siempre son != null
////						{
////							m = new MethodHandlerModel(method);
////							methods.put(method.getMethodName(), m);
////						}
//
//					//obtengo el source model correspondiente 
//					SourceModel sm = sourcesMap.get(m);
//					if(sm == null)
//					{
//						sm = new SourceModel(on,source,generator,model);
//						sourcesMap.put(m, sm);						
//					}					
//					//ya tengo el metodo manejador, que hago con el?
//					//facil, ahora debes agregar este filtro
//					//pero como diferencio si es conjuncion o disyunción?
//					//todos los que están en este for, son una conjunción
//					if(value != null) //me aseguro que sea distinto de nulo, asi no agrega nada adicional
//					{
//						FiltersD filterD = sm.getCurrentFilterD(filter);
//						filterD.add(method,value); //agrego el filtro actual
//					}
//				}				
//				//ahora como agrego otra disyunciï¿½n?
//				//lo harï¿½ en currentFilter, guardarï¿½ la ultima iteraciï¿½n. Si esta cambia, entonces agregarï¿½ otro filtro.
//			}
//		}
//		else //cuando hay 0 filtros
//		{
//			for(Entry<String,MethodHandlerModel> entry:methods.entrySet())
//			{
//				//cuando hay 0 filtros, el source se agrega a cada uno de los metodos
//				entry.getValue().addSource(new SourceModel(on,source,generator,model));					
//			}
//		}
//		//al finalizar
//		for(Entry<MethodHandlerModel, SourceModel> entry:sourcesMap.entrySet())
//		{
//			entry.getKey().addSource(entry.getValue());
//		}
//	}
	
	public final String getName() {
		return name;
	}
	public final List<MethodHandlerModel> getMethodHandlers() {
		return methodHandlers;
	}	
}
