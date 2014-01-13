package fp4g.data.define;

import static fp4g.Log.Show;
import fp4g.Log.ErrType;
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
	public void setAdd(Add code) {
		Show(ErrType.NotExpectedAdd,code);
		
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
