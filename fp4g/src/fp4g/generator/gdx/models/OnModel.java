package fp4g.generator.gdx.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import fp4g.classes.MessageMethod;
import fp4g.data.ExprList;
import fp4g.data.IValue;
import fp4g.data.On;
import fp4g.data.expresion.ClassMap;
import fp4g.data.statements.Filter;
import fp4g.data.statements.Source;
import fp4g.exceptions.FP4GException;
import fp4g.generator.Model;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.models.On.FiltersD;
import fp4g.generator.gdx.models.On.MethodHandlerModel;
import fp4g.generator.gdx.models.On.SourceModel;


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
	
	private OnModel(On on) 
	{
		name = on.name;
		methodHandlers = new LinkedList<MethodHandlerModel>();
	}
		
	public final String getName() {
		return name;
	}
	public final List<MethodHandlerModel> getMethodHandlers() {
		return methodHandlers;
	}

	public static OnModel build(On on, JavaGenerator generator,	JavaCodeModel model) throws FP4GException
	{
		OnModel onModel = new OnModel(on);
		//agregar la interface 
		model.addInterface(String.format("%sMessageHandler",on.name));

		//agregar los metodos, aunque están vacios y asumiento que todos son MessageMethod
		HashMap<String,MethodHandlerModel> methods = new HashMap<String, MethodHandlerModel>();
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
		
		//luego tengo que recorrer los sources en busca de los methodHandlers y subirlos acá
		for(Source source:on.sources)
		{			
			//este objeto se trata de relacionar los source model con un MethodHandlermodel
			final HashMap<MethodHandlerModel,SourceModel> sourcesMap = new HashMap<MethodHandlerModel, SourceModel>();
			
			if(source.filters.size() > 0)
			{
				for(Filter filter: source.filters)
				{
					final MessageMethod method = filter.method;
					final ExprList exprList = filter.exprList;
					
					//encontré un metodo, que hago con el
					MethodHandlerModel m = methods.get(method.getName());								

					//obtengo el source model correspondiente 
					SourceModel sm = sourcesMap.get(m);
					if(sm == null)
					{
						sm = new SourceModel(source,on,model, generator);								
						sourcesMap.put(m, sm);						
					}					
					//ya tengo el metodo manejador, que hago con el?
					//facil, ahora debes agregar este filtro
					//pero como diferencio si es conjuncion o disyunción?
					//todos los que están en este for, son una conjunción
					//13/02/14 Ahora maneja listas de expresiones
					if(exprList != null) //me aseguro que sea distinto de nulo, asi no agrega nada adicional
					{
						FiltersD filterD = sm.getCurrentFilterD(filter);									
						filterD.add(method, exprList, generator.exprGen); //agrego el filtro actual
					}
				}				
				//ahora como agrego otra disyunción?
				//lo haré en currentFilter, guardaré la ultima iteraciï¿½n. Si esta cambia, entonces agregarï¿½ otro filtro.						
			}
			else //cuando hay 0 filtros
			{
				for(Entry<String,MethodHandlerModel> entry:methods.entrySet())
				{
					//cuando hay 0 filtros, el source se agrega a cada uno de los metodos
					entry.getValue().addSource(new SourceModel(source, on, model, generator));					
				}
			}
			//al finalizar
			for(Entry<MethodHandlerModel, SourceModel> entry:sourcesMap.entrySet())
			{
				entry.getKey().addSource(entry.getValue());
			}
		}
		onModel.getMethodHandlers().addAll(methods.values());
		
		return onModel;
	}
}
