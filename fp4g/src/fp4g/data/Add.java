/**
 * 
 */
package fp4g.data;

import fp4g.data.expresion.IMap;
import fp4g.exceptions.CannotEvalException;

/**
 * @author egyware
 *
 */
public abstract class Add extends Line implements IValue<Add>, Expresion
{		
	public final String name;	
	public final IMap values;
	public final AddType addType;
	public final IDefine container;
	
	
	public Add(String name, AddType type, IDefine container, IMap values) 
	{		
		this.name = name;		
		this.values = values;
		this.addType = type;
		this.container = container;
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

	
	public IValue<?> eval(IValue<?> value) throws CannotEvalException
	{
		return this;
	}
}
