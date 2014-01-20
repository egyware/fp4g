package fp4g.data.define;

import static fp4g.Log.Show;
import fp4g.Log.ErrType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;

public class GameState extends Define{
	
	public GameState(String name,IDefine parent) {
		super(DefineType.STATE, name,parent);
	}
	
	@Override
	public void setAdd(Add code) {
		switch(code.getType())
		{				
		case BEHAVIOR:
		case GAME:
		case STATE:
			Show(ErrType.NotExpectedType,code);
			break;
		case ENTITY:			
			super.setAdd(code);
			break;
		case GOAL:
			//TODO: No implementado aún
			throw new RuntimeException("No implementado");
			//break;
		case MANAGER:
			super.setAdd(code);
			break;
		case ASSET:			
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
		Show(ErrType.NotExpectedOn,on);
	}
}
