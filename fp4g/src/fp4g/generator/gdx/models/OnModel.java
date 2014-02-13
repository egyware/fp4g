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
		
	public final String getName() {
		return name;
	}
	public final List<MethodHandlerModel> getMethodHandlers() {
		return methodHandlers;
	}
}
