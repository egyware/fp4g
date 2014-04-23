package fp4g.data.define;

import fp4g.data.Add;
import fp4g.data.AddDefine;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.exceptions.NotAllowedException;
import fp4g.log.info.GeneratorError;
import fp4g.log.info.NotAllowed;

public class Entity extends Define
{	
	public Entity(String name, IDefine parent) 
	{
		super(DefineType.ENTITY, name,parent);
	}	
	
	@Override
	public void setAdd(Add code) 
	{
		switch(code.addType)
		{
		case AddAsset:
			throw new NotAllowedException(NotAllowed.NotExpectedAdd,code, "No se permite estos tipos en Entity");			
		case AddDefine:
			setAdd((AddDefine)code);
			break;
		case AddMethod:
			throw new NotAllowedException(NotAllowed.NotExpectedAdd,code, "No se permite estos tipos en Entity");			
		default:
			throw new FP4GRuntimeException(GeneratorError.IllegalState, code.getAddType().toString());
		}		
	}
	
	public void setAdd(AddDefine code)
	{
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
