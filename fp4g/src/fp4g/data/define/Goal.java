package fp4g.data.define;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;
import fp4g.exceptions.NotAllowedException;
import fp4g.log.info.NotAllowed;

/**
 * La clase objetivo son eventos personalizados
 * @author Edgardo
 *
 */
public class Goal extends Define
{	
	public Goal(String name) {
		super(DefineType.GOAL, name);		 
	}
	
	@Override
	public void setAdd(Add code) 
	{
		throw new NotAllowedException(NotAllowed.NotExpectedAdd, code, "No se esperaba una instrución Add en Goal");
		
	}
	public void setOn(On on) 
	{
		throw new NotAllowedException(NotAllowed.NotExpectedOn, on, "No se esperaba una instrucción On en Goal");		
	}	
}
