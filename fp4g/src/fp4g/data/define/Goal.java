package fp4g.data.define;

import fp4g.NotAllowed;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;

/**
 * La clase objetivo son eventos personalizados
 * @author Edgardo
 *
 */
public class Goal extends Define {	
	public Goal(String name) {
		super(DefineType.GOAL, name);		 
	}	
	
	@Override
	public void setAdd(Add code) 
	{
		throw new NotAllowedException(NotAllowed.NotExpectedAdd, code, "No se esperaba una instrución Add en Goal");
		
	}
	@Override
	public void setDefine(IDefine define) {
		throw new NotAllowedException(NotAllowed.NotExpectedDefine, define, "No se esperaba una instrucción Define en Goal");
	}
	@Override
	public void setOn(On on) 
	{
		throw new NotAllowedException(NotAllowed.NotExpectedOn, on, "No se esperaba una instrucción On en Goal");		
	}	
}
