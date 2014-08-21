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
/**
 * Esta clase contendrá todos los datos necesarios para construir un juego
 * @author Edgardo
 *
 */
public class Game extends Define
{	
	public int width = 640;
	public int height = 480;
	
	public GameState startState;
	
	public Game(ILib lc)
	{
		super(DefineTypes.GAME,"game",lc);		
	}
	
	@Override
	public void setAdd(Add code) 
	{
		switch(code.addType)
		{
		case AddAsset:
			throw new FP4GRuntimeException(FP4GError.NotExceptedAdd,code, "No se permite estos tipos en Game");			
		case AddDefine:
			setAdd((AddDefine)code);
			break;
		case AddMethod:
			throw new FP4GRuntimeException(FP4GError.NotExceptedAdd,code, "No se permite estos tipos en Game");			
		default:
			throw new FP4GRuntimeException(FP4GError.IllegalState, code.getAddType().toString());
		}		
	}
	
	public void setAdd(AddDefine code) 
	{
		final DefineType type = code.getType();
		if(DefineTypes.GOAL == type)
		{
			super.setAdd(code);
		}
		if(DefineTypes.STATE == type)
		{			
			super.setAdd(code);
		}
		else
		{			
			throw new FP4GRuntimeException(FP4GError.NotExceptedAdd, code,"No se esperaba estos tipos en Game");
		}		
	}
	
	@Override
	public void setOn(On on) 
	{
		throw new FP4GRuntimeException(FP4GError.NotExpectedOn, on, "No se esperaba una instrucción ON en Game");		
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

	public final void setWidth(int width) {
		this.width = width;
	}

	public final void setHeight(int height) {
		this.height = height;
	}
	
	public void setName(String name)
	{
		//TODO esto puede traer problemas a futuro... 
		this.name = name;
	}
}
