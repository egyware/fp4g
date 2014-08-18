package fp4g.data.define;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineTypes;
import fp4g.data.On;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.FP4GError;

/**
 * La clase objetivo son eventos personalizados
 * @author Edgardo
 *
 */
public class Goal extends Define
{	
	public Goal(String name) {
		super(DefineTypes.GOAL, name);		 
	}
	
	@Override
	public void setAdd(Add code) 
	{
		throw new FP4GRuntimeException(FP4GError.NotExceptedAdd, code, "No se esperaba una instrución Add en Goal");
		
	}
	public void setOn(On on) 
	{
		throw new FP4GRuntimeException(FP4GError.NotExpectedOn, on, "No se esperaba una instrucción On en Goal");		
	}	
}
