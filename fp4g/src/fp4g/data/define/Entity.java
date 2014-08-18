package fp4g.data.define;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.DefineTypes;
import fp4g.data.ILib;
import fp4g.data.add.AddDefine;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.FP4GError;

public class Entity extends Define
{	
	public Entity(String name, ILib container) 
	{
		super(DefineTypes.ENTITY, name,container);
	}	
	
	@Override
	public void setAdd(Add code) 
	{
		switch(code.addType)
		{
		case AddAsset:
			throw new FP4GRuntimeException(FP4GError.NotExceptedAdd, code, "No se permite estos tipos en Entity");			
		case AddDefine:
			setAdd((AddDefine)code);
			break;
		case AddMethod:
			throw new FP4GRuntimeException(FP4GError.NotExceptedAdd, code, "No se permite estos tipos en Entity");			
		default:
			throw new FP4GRuntimeException(FP4GError.IllegalState, code.getAddType().toString());
		}		
	}
	
	public void setAdd(AddDefine code)
	{
		final DefineType type = code.getType();
		
		if(DefineTypes.BEHAVIOR == type)
		{
			super.setAdd(code);
		}
		else
		{
			throw new FP4GRuntimeException(FP4GError.NotExceptedAdd, code, "No se permite estos tipos en Entity");			
		}		
	}	
}
