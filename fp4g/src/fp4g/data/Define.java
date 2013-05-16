package fp4g.data;

import fp4g.Log;
import static fp4g.Log.Show;



public class Define extends Value implements Cloneable{	
	private IScope scope;	
	private FactoryType type;	
	
	public Define(String _name,FactoryType _type,IScope _scope){
		super(_name);
		scope = _scope;
		type = _type;
	}
	public Define(String _name,FactoryType _type,IScope _scope,int ordinal){
		super(_name,ordinal);
		scope = _scope;
		type = _type;
	}
	public Define(String name,FactoryType type){
		this(name,type, null);
	}
		
	
	public FactoryType getType()
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
	
	public static void Set(FactoryType _type,String _name, String _based,IScope _local ,IScope _properties,int line)
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
						_local.set(_name,factory);
						//TODO Revisar si algunas cosas deben definirse localmente al estado o al juego
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
			Object value = _local.get(_based);
			try
			{
				Define f = (Define)value;
				if(f.type != _type)
				{
					Show(Log.ErrType.DontMatchTypes,line);
					Show(Log.ErrType.DontMatchTypes,f);
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
				Show(Log.ErrType.CannotCastVar,line);
				Show(Log.ErrType.CannotCastVar,value);				
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
