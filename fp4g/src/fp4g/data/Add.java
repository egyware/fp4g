/**
 * 
 */
package fp4g.data;

/**
 * @author egyware
 *
 */
public class Add extends Value{	
	private IScope scope;	
	private Type type;	
	public Add(String _name,Type _type, IScope _scope)
	{
		super(_name);
		scope = (_scope == null)?new MapScope():_scope;
		type = _type;
		
	}
		
	public IScope getScope(){
		return scope;
	}
	
	public Type getType()
	{
		return type;
	}	
	
}
