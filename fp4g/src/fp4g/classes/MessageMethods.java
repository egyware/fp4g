package fp4g.classes;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.misc.Utils;

import fp4g.core.IValue;
import fp4g.data.add.AddMethod;
import fp4g.data.expresion.IMap;

/**
 * Esta clase auxiliar sirve para almacenar todos los methodos mensajes por nombre
 * @warning Los nombres de los metodos deben ser unicos 
 * @author Edgardo
 *
 */
public final class MessageMethods implements IMap, IValue<MessageMethods>
{
	private final HashMap<String, AddMethod> map;
	
	public MessageMethods()
	{
		map = new HashMap<String, AddMethod>();
	}
	public void add(AddMethod am)
	{
		//me aseguro que esté en minusculas para usarlo de la manera que se me de la gana
		map.put(am.name,am);		
	}
	public AddMethod getMessageMethod(String key)
	{
		AddMethod addMethod = map.get(Utils.decapitalize(key));
		return addMethod;
	}

	
	//--- complaciendo el publico
	@Override
	public void set(String k, IValue<?> v) {
		//TODO no se puede hacer set 
	}
	
	@Override
	public IValue<?> get(String k) {
		return map.get(k);				
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Set<Entry<String, AddMethod>> entrySet() 
	{
		return map.entrySet();
	}
	
	@Override
	public MessageMethods getValue()
	{
		return this;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append('{');
		builder.append('\n');
		for(Entry<String, AddMethod> entry:map.entrySet())
		{
			builder.append('\t');
			builder.append(entry.getKey());
			builder.append(" = ");
			builder.append(entry.getValue());
			builder.append('\n');
		}		
		builder.append('}');
		return builder.toString();
	}
}
