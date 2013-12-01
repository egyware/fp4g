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
public class MessageMethods implements CustomMap
{
	private final HashMap<String, MessageMethod> map;
	
	public MessageMethods()
	{
		map = new HashMap<>();
	}
	public void add(MessageMethod mm)
	{
		map.put(mm.getMethodName(), mm);
	}
	public MessageMethod getMessageMethod(String k)
	{
		return map.get(k);
	}

	
	//--- complaciendo el publico
	@Override
	public Literal<?> set(String k, Literal<?> v) {
		//rechazar si
		if(!(v.getValue() instanceof MessageMethod))
		{
			return null;
		}
		Literal<?> old = get(k);
		map.put(k, (MessageMethod)v.getValue());
		return old;
	}
	@Override
	public Literal<?> get(String k) {
		MessageMethod method = map.get(k);
		if(method != null)
		{
			return new ClassMap(method);
		}
		return null;		
	}
	
	
	
}
