package fp4g.data.define;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;
import fp4g.data.expresion.ArrayMap;
import fp4g.data.expresion.Map;
import fp4g.exceptions.NotAllowedException;
import fp4g.log.info.NotAllowed;

public class GameState extends Define
{
	private final ArrayMap assets;
	
	public GameState(String name,IDefine parent) 
	{
		super(DefineType.STATE, name,parent);
		assets = new ArrayMap();
	}
	
	@Override
	public void setAdd(Add code) {
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
	
	/**
	 * Contiene un map que guarda todos los assets por nombre.
	 * 
	 * Contiene un map que guarda todos los assets por nombre, para su rapido acceso.
	 * @return
	 */
	public Map getAssets()
	{
		return assets;
	}
	
	@Override
	public void setDefine(IDefine define) {
		throw new NotAllowedException(NotAllowed.NotExpectedDefine, define, "No se esperaba una instrucción Define en GameState");
	}

	@Override
	public void setOn(On on) {
		throw new NotAllowedException(NotAllowed.NotExpectedOn, on, "No se esperaba una instrucción ON en GameState");
	}
}
