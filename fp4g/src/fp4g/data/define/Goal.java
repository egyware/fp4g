package fp4g.data.define;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.Event;
import fp4g.data.ObjectType;
import fp4g.data.On;

/**
 * La clase objetivo son eventos personalizados
 * @author Edgardo
 *
 */
public class Goal extends Define {	
	public Goal(String name) {
		super(ObjectType.GOAL, name);		 
	}
	public String name;
	public Event acomplish;
	//TODO pendiente falta como se encapsulará la condición de activación
	@Override
	public void addADD(Add code) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addDefine(Define define) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addOn(On on) {
		// TODO Auto-generated method stub
		
	}
}
