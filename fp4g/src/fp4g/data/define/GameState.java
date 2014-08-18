package fp4g.data.define;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.DefineTypes;
import fp4g.data.ILib;
import fp4g.data.On;
import fp4g.data.add.AddDefine;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.FP4GError;

public class GameState extends Define
{	
	public GameState(String name,ILib container) 
	{
		super(DefineTypes.STATE, name,container);
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
			throw new FP4GRuntimeException(FP4GError.NotExceptedAdd, code,  "No se permite estos tipos en GameState");			
		default:
			throw new FP4GRuntimeException(FP4GError.IllegalState, code.getAddType().toString());
		}		
	}
	
	public void setAdd(AddDefine code) 
	{
		final DefineType type = code.getType();	
		if(DefineTypes.ENTITY == type)
		{
			super.setAdd(code);		
		}
		else
		if(DefineTypes.GOAL == type)
		{
			throw new FP4GRuntimeException(FP4GError.NotImplement, code, "No se ha implementado esta caracteristica todavía");
		}
		else
		if(DefineTypes.MANAGER == type)
		{
			super.setAdd(code);
		}
		else
		if(DefineTypes.ASSET == type)
		{
			super.setAdd(code);
		}
		else
		{
			throw new FP4GRuntimeException(FP4GError.NotExceptedAdd, code, "No se esperaban estos tipos en GameState");			
		}		
	}
	
	@Override
	public void setOn(On on) {
		throw new FP4GRuntimeException(FP4GError.NotExpectedOn, on, "No se esperaba una instrucción ON en GameState");
	}
}
