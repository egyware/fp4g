package fp4g.data.define;

import fp4g.NotAllowed;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;

public class Entity extends Define
{	
	public Entity(String name, IDefine parent) 
	{
		super(DefineType.ENTITY, name,parent);
	}	
	
	@Override
	public void setAdd(Add code) {
		switch(code.getType())
		{		
		case BEHAVIOR:
			super.setAdd(code);
			break;
		case ASSET:			
		case ENTITY:		
		case GAME:			
		case GOAL:			
		case MANAGER:			
		case STATE:
		default:
			throw new NotAllowedException(NotAllowed.NotExpectedAdd,code, "No se permite estos tipos en Entity");			
		}		
	}

	@Override
	public void setDefine(IDefine define) 
	{
		throw new NotAllowedException(NotAllowed.NotExpectedAdd, define, "No se la instrucción Entity en ");		
	}


	@Override
	public void setOn(On on) {
		super.setOn(on);
	}		
}
