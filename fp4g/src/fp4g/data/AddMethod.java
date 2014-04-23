/**
 * 
 */
package fp4g.data;

import fp4g.data.expresion.IMap;

/**
 * Add especializado que permite añadir mensajes-metodos.
 * 
 * @author egyware
 *
 */
public class AddMethod extends Add
{		
	public final NameList nameList;
	
	public AddMethod(String name, NameList list)
	{
		this(name, list, null);
	}
	
	public AddMethod(String name, NameList list, IMap values) 
	{	
		super(name, AddType.AddMethod, values);
		this.nameList = list;		
	}	
	
}
