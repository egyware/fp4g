package fp4g.data.define;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.ILib;
import fp4g.data.On;
import fp4g.data.add.AddDefine;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.exceptions.NotAllowedException;
import fp4g.log.info.GeneratorError;
import fp4g.log.info.NotAllowed;

public class GameState extends Define
{	
	public GameState(String name,ILib container) 
	{
		super(DefineType.STATE, name,container);
	}
	
	@Override
	public void setAdd(Add code) 
	{
		switch(code.addType)
		{
		case AddAsset:
			super.setAdd(code);
			break;
		case AddDefine:
			setAdd((AddDefine)code);
			break;
		case AddMethod:
			throw new NotAllowedException(NotAllowed.NotExpectedAdd,code, "No se permite estos tipos en GameState");			
		default:
			throw new FP4GRuntimeException(GeneratorError.IllegalState, code.getAddType().toString());
		}		
	}
	
	public void setAdd(AddDefine code) {
		switch(code.getType())
		{		
		case ENTITY:			
			super.setAdd(code);
			break;
		case GOAL:
			//TODO: No implementado aún
			throw new NotAllowedException(NotAllowed.NotImplementedYet, code, "No se ha implementado esta caracteristica todavía");
			//break;
		case MANAGER:
			super.setAdd(code);
			break;
		case ASSET:			
			super.setAdd(code);
			break;
		case BEHAVIOR:
		case GAME:
		case STATE:
		default:
			throw new NotAllowedException(NotAllowed.NotExpectedAdd, code, "No se esperaban estos tipos en GameState");			
		}		
	}
	
	@Override
	public void setOn(On on) {
		throw new NotAllowedException(NotAllowed.NotExpectedOn, on, "No se esperaba una instrucción ON en GameState");
	}
}
