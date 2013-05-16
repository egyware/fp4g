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
	private FactoryType type;	
	public Add(String _name,FactoryType _type, IScope _scope)
	{
		super(_name);
		scope = (_scope == null)?new MapScope():_scope;
		type = _type;
		
	}
		
	public IScope getScope(){
		return scope;
	}
	
	public FactoryType getType()
	{
		return type;
	}	
	
}
