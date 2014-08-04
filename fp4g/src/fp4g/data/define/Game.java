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
/**
 * Esta clase contendrá todos los datos necesarios para construir un juego
 * @author Edgardo
 *
 */
public class Game extends Define
{	
	public int width = 640;
	public int height = 480;
	public boolean debug = false;	
	public GameState startState;
	
	public Game(ILib lc)
	{
		super(DefineType.GAME,"game",lc);		
	}
	
	@Override
	public void setAdd(Add code) 
	{
		switch(code.addType)
		{
		case AddAsset:
			throw new NotAllowedException(NotAllowed.NotExpectedAdd,code, "No se permite estos tipos en Game");			
		case AddDefine:
			setAdd((AddDefine)code);
			break;
		case AddMethod:
			throw new NotAllowedException(NotAllowed.NotExpectedAdd,code, "No se permite estos tipos en Game");			
		default:
			throw new FP4GRuntimeException(GeneratorError.IllegalState, code.getAddType().toString());
		}		
	}
	
	public void setAdd(AddDefine code) {
		switch(code.getType())
		{	
			case GOAL:
				super.setAdd(code);
				break;
			case STATE:
				super.setAdd(code);
				break;			
			default:
				throw new NotAllowedException(NotAllowed.NotExpectedAdd, code,"No se esperaba estos tipos en Game");					
		}		
	}
	
	@Override
	public void setOn(On on) {
		throw new NotAllowedException(NotAllowed.NotExpectedOn, on, "No se esperaba una instrucción ON en Game");		
	}

	public void setStart(GameState state) {
		startState = state;		
	}

	public final int getWidth() {
		return width;
	}

	public final int getHeight() {
		return height;
	}

	public final boolean isDebug() {
		return debug;
	}

	public final void setWidth(int width) {
		this.width = width;
	}

	public final void setHeight(int height) {
		this.height = height;
	}

	public final void setDebug(boolean debug) {
		this.debug = debug;
	}
}
