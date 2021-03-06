package fp4g.generator.gdx.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import fp4g.data.ExprList;
import fp4g.data.ILib;
import fp4g.data.On;
import fp4g.data.add.AddMethod;
import fp4g.data.expresion.DirectCode;
import fp4g.data.statements.Filter;
import fp4g.data.statements.Source;
import fp4g.exceptions.FP4GException;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.generator.gdx.JavaParamListBuilder;
import fp4g.generator.gdx.models.on.FiltersD;
import fp4g.generator.gdx.models.on.MethodHandlerModel;
import fp4g.generator.gdx.models.on.SourceModel;


/**
 * La funcion de OnModel es almacenar el nombre del mensaje y metodos.
 * 
 * Esta  clase almacena el nombre de los mensajes y una lista de modelos de metodos quien contienen el codigo y los filtros asociados.
 * 
 * @author Edgardo
 *
 */
public class OnModel
{
	//Nombre categoria mensaje	
	private final String name;
	//Necesitar� una lista de los MethodHandlers!
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

	public static OnModel build(ILib lib, On on, JavaGenerator generator, JavaMetaSourceModel model) throws FP4GException
	{
		final JavaParamListBuilder paramBuilder = new JavaParamListBuilder(lib, generator);
		OnModel onModel = new OnModel(on);
		
		//inyectar variables
		//TODO pensar de forma dinamica QUE VARIABLES DEBEN IR AQUI
		on.set("entity", new DirectCode("entity"));
		
		
		//agregar la interface 
		//se utilizar� clases internas
		//model.addInterface(String.format("%sMessageHandler",on.name));

		//agregar los metodos, aunque est�n vacios y asumiento que todos son MessageMethod
		HashMap<String,MethodHandlerModel> methods = new HashMap<String, MethodHandlerModel>();
		//TODO da un error cuando el mensaje est� sin definir		
		for(AddMethod entry: on.message.getAddMethods())
		{	
			List<VarCodeModel> params = (entry.nameList != null)?paramBuilder.build(entry.nameList, null,  model):null;			
			methods.put(entry.name, new MethodHandlerModel(entry, params));
		}
		
		//luego tengo que recorrer los sources en busca de los methodHandlers y subirlos ac�
		for(Source source:on.sources)
		{			
			//este objeto se trata de relacionar los source model con un MethodHandlermodel
			final HashMap<MethodHandlerModel,SourceModel> sourcesMap = new HashMap<MethodHandlerModel, SourceModel>();
			
			if(source.filters.size() > 0)
			{
				for(Filter filter: source.filters)
				{
					final AddMethod method = filter.method;
					final ExprList exprList = filter.exprList;
					
					//encontr� un metodo, que hago con el
					MethodHandlerModel m = methods.get(method.name);								

					//obtengo el source model correspondiente 
					SourceModel sm = sourcesMap.get(m);
					if(sm == null)
					{
						sm = new SourceModel(source,on,model, generator);								
						sourcesMap.put(m, sm);						
					}					
					//ya tengo el metodo manejador, que hago con el?
					//facil, ahora debes agregar este filtro
					//pero como diferencio si es conjuncion o disyunci�n?
					//todos los que est�n en este for, son una conjunci�n
					//13/02/14 Ahora maneja listas de expresiones
					if(exprList != null) //me aseguro que sea distinto de nulo, asi no agrega nada adicional
					{
						FiltersD filterD = sm.getCurrentFilterD(filter);									
						filterD.add(method, exprList,model, on, generator.exprGen); //agrego el filtro actual
					}
				}				
				//ahora como agrego otra disyunci�n?
				//lo har� en currentFilter, guardar� la ultima iteraci�n. Si esta cambia, entonces agregar� otro filtro.						
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
