/**
 * 
 */
package fp4g.data;

import fp4g.data.expresion.IMap;

/**
 * @author egyware
 *
 */
public abstract class Add extends Line implements IValue<Add>
{		
	public final String name;	
	public final IMap values;
	public final AddType addType;
	
	
	public Add(String name, AddType type, IMap values) 
	{		
		this.name = name;		
		this.values = values;
		this.addType = type;
	}	
	
	public AddType getAddType()
	{
		return addType;
	}

	@Override
	public final Add getValue() 
	{
		return this;
	}

}
