/**
 * 
 */
package fp4g.data.add;

import fp4g.data.Add;
import fp4g.data.AddType;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.ExprList;
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
	
	public AddDefine(Define define)
	{
		this(define, null, null);
	}
	
	public AddDefine(Define define, ExprList params)
	{
		this(define, params, null);
	}
	
	public AddDefine(Define define, ExprList params, IMap values) 
	{	
		super(define.name, AddType.AddDefine, values);
		this.define = define;
		this.type = define.type;
		this.params = params;
	}	
	
	public AddDefine(DefineType type, String name, ExprList params, IMap values)
	{
		super(name, AddType.AddDefine, values);
		this.define = null;
		this.type = type;
		this.params = params;		
	}
	
	public AddDefine(DefineType type, String name,  ExprList params)
	{
		this(type, name, params, null);		
	}
	
	public AddDefine(DefineType type, String name)
	{
		this(type, name, null, null);		
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
