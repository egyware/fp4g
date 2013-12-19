package fp4g.classes;

import java.util.HashMap;

import fp4g.data.expresion.ClassMap;
import fp4g.data.expresion.CustomMap;
import fp4g.data.expresion.Literal;

/**
 * Esta clase auxiliar sirve para almacenar todos los methodos mensajes por nombre
 * @warning Los nombres de los metodos deben ser unicos 
 * @author Edgardo
 *
 */
public final class MessageMethods implements CustomMap
{
	private final HashMap<String, ClassMap<MessageMethod>> map;
	
	public MessageMethods()
	{
		map = new HashMap<String, ClassMap<MessageMethod>>();
	}
	public void add(MessageMethod mm)
	{
		//me aseguro que esté en minusculas para usarlo de la manera que se me de la gana
		map.put(mm.getName().toLowerCase(), new ClassMap<MessageMethod>(mm));		
	}
	public MessageMethod getMessageMethod(String k)
	{
		//me aseguro que est� en minusculas para usarlo de la manera que se me de la gana
		ClassMap<MessageMethod> cm = map.get(k.toLowerCase());		
		return cm.getValue();
	}

	
	//--- complaciendo el publico
	@Override
	public void set(String k, Literal<?> v) {
		//rechazar si
		if(!(v.getValue() instanceof MessageMethod))
		{
			//TODO LANZAR UN ERROR
			return;
		}
		map.put(k.toLowerCase(), new ClassMap<MessageMethod>((MessageMethod)v.getValue()));		
	}
	@Override
	public Literal<?> get(String k) {
		return map.get(k);				
	}
	
	
	
}
