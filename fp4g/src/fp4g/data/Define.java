package fp4g.data;


public class Define extends Value implements Cloneable{	
	private IScope scope;	
	private Type type;
	
	public Define(String _name,Type _type,IScope _scope){
		super(_name);
		scope = _scope;
		type = _type;
	}
	public Define(String _name,Type _type,IScope _scope,int ordinal){
		super(_name,ordinal);
		scope = _scope;
		type = _type;
	}
	public Define(String name,Type type){
		this(name,type, null);
	}
		
	
	public Type getType()
	{
		return type;
	}
	
	public IScope getScope()
	{
		return scope;
	}
	
	protected Define clone() throws CloneNotSupportedException
	{
		Define clone = (Define) super.clone(); 
		clone.scope = scope.clone();
		return clone;		
	}
	
	public static void Set(Type _type,String _name, String _based,IScope _local ,IScope _properties,int line)
	{	
		//si está definida, hay que clonar entonces...
		Define factory;
		if(_based == null)
		{
			try
			{
				factory = (Define) _local.get(_name);
				if(factory == null)
				{
					switch(_type)
					{
					case STATE:
					case GOAL:
					case ENTITY:
						factory = new Define(_name,_type,_properties);
						factory.setLine(line);
						//TODO no se definio globalmente
						_local.set(_name,factory);
						break;				
					default:
						break;
					}
				}
				else
				{
					_properties.writeAndOverride(factory.scope);
				}
			}
			catch(ClassCastException e)
			{
				//TODO error lanzar un error acá
				e.printStackTrace();
				return;
			}	
		}
		else
		{			
			try
			{
				Define f = (Define)_local.get(_based);
				if(f.type != _type)
				{
					//TODO lanzar otro error acá
				}
				factory = f.clone();
				factory.setLine(line);
				//establecemos la nueva variable
				_local.set(_name, factory);
				//sobreescribimos sus propiedades clonadas				_
				_properties.writeAndOverride(factory.scope);
			}
			catch(ClassCastException e)
			{
				//TODO error lanzar un error acá
				e.printStackTrace();
				return;
			} 
			catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
				return;
			}
		}	
	}
}
