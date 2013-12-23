package fp4g.data.define;

import static fp4g.Log.Show;
import fp4g.Log.ErrType;
import fp4g.Log.WarnType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.On;

public class GameState extends Define{
	
	public GameState(String name,Define parent) {
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
			if(!isSetDefine(DefineType.ENTITY,code.name))
			{
				Show(WarnType.MissingDefineAdd,code);
			}
			super.setAdd(code);
			break;
		case GOAL:
			//TODO: No implementado aún
			throw new RuntimeException("No implementado");
			//break;
		case MANAGER:
			if(!isSetDefine(DefineType.MANAGER,code.name))
			{
				Show(WarnType.MissingDefineAdd,code);
			}
			super.setAdd(code);
			break;
		case ASSET:
			if(!isSetDefine(DefineType.ASSET,code.name))
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
		Show(ErrType.NotExpectedOn,on);
	}
}
