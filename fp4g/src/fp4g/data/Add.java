/**
 * 
 */
package fp4g.data;

/**
 * @author egyware
 *
 */
public class Add extends Value{	
	private Scope scope;	
	private Type type;	
	public Add(String _name,Type _type, Scope _scope)
	{
		super(_name);
		scope = (_scope == null)?new Scope():_scope;
		type = _type;
		
	}
		
	public Scope getScope(){
		return scope;
	}
	
	public Type getType()
	{
		return type;
	}	
	
}
