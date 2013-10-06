package fp4g.data.define;

import static fp4g.Log.Show;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fp4g.Log.ErrType;
import fp4g.Log.WarnType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.On;

public class Entity extends Define{	
	
	public Entity(String name,Define parent) {
		super(DefineType.ENTITY, name,parent);
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
			if(!isSetDefine(DefineType.BEHAVIOR,code.name))
			{
				Show(WarnType.MissingDefineAdd,code);
			}
			super.setAdd(code);
			break;			
		default:
			Show(ErrType.UnknowError,code);
			break;		 
		}		
	}

	@Override
	public void setDefine(Define define) {
		Show(ErrType.NotExpectedDefine,define);		
	}


	@Override
	public void setOn(On on) {
		super.setOn(on);
	}		
}
