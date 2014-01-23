package fp4g.data.define;

import static fp4g.Log.Show;
import fp4g.Log.ErrType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.On;

public class Entity extends Define
{	
	
	public Entity(String name, IDefine parent) 
	{
		super(DefineType.ENTITY, name,parent);
	}
	
	public Entity(String name, ILib lib) 
	{
		super(DefineType.ENTITY, name, null,lib);
	}
	
	@Override
	public void setAdd(Add code) {
		switch(code.getType())
		{
		case ASSET:			
		case ENTITY:		
		case GAME:			
		case GOAL:			
		case MANAGER:			
		case STATE:
			Show(ErrType.NotExpectedType,code);
			break;
		case BEHAVIOR:
			super.setAdd(code);
			break;			
		default:
			Show(ErrType.UnknowError,code);
			break;		 
		}		
	}

	@Override
	public void setDefine(IDefine define) {
		Show(ErrType.NotExpectedDefine,define);		
	}


	@Override
	public void setOn(On on) {
		super.setOn(on);
	}		
}
