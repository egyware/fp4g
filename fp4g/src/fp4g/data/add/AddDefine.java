/**
 * 
 */
package fp4g.data.add;

import fp4g.data.Add;
import fp4g.data.AddType;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.ExprList;
import fp4g.data.IDefine;
import fp4g.data.expresion.IMap;

/**
 * Add especializado que permite añadir otros tipos de definiciones.
 * 
 * @author egyware
 *
 */
public class AddDefine extends Add
{		
	public final Define define;	
	public final DefineType type;
	public final ExprList params;
	
	public AddDefine(Define define, IDefine container)
	{
		this(define, null, container, null);
	}
	
	public AddDefine(Define define, ExprList params, IDefine container)
	{
		this(define, params, container, null);
	}
	
	public AddDefine(Define define, ExprList params, IDefine container, IMap values) 
	{	
		super(define.name, AddType.AddDefine, container, values);
		this.define = define;
		this.type = define.type;
		this.params = params;
	}	
	
	public AddDefine(DefineType type, String name, ExprList params, IDefine container, IMap values)
	{
		super(name, AddType.AddDefine, container, values);
		this.define = null;
		this.type = type;
		this.params = params;		
	}
	
	public AddDefine(DefineType type, String name,  ExprList params, IDefine container)
	{
		this(type, name, params, container, null);		
	}
	
	public AddDefine(DefineType type, String name, IDefine container)
	{
		this(type, name, null,  container, null);		
	}	
	
	public DefineType getType()
	{
		return type;
	}
	
	public String toString()
	{
		return "ADD ".concat(type.name()).concat(" ").concat(name).concat(" (...) [...]");
	}

}
