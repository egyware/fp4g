/**
 * 
 */
package fp4g.data.define;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;
import fp4g.log.info.NotAllowed;

/**
 * @author Edgardo
 *
 */
public class Message extends Define
{

	public Message(String name,IDefine parent) {
		super(DefineType.MESSAGE, name,parent);		
	}
	
	public Message(String name) {
		super(DefineType.MESSAGE, name);		
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#addADD(fp4g.data.Add)
	 */
	@Override
	public void setAdd(Add add)
	{
		throw new NotAllowedException(NotAllowed.NotExpectedAdd, add, "No se esperaba una instrución Add en Mesage");
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#addDefine(fp4g.data.Define)
	 */
	@Override
	public void setDefine(IDefine define) {
		throw new NotAllowedException(NotAllowed.NotExpectedDefine, define, "No se esperaba una instrucción Define en Message");
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#addOn(fp4g.data.On)
	 */
	@Override
	public void setOn(On on) {
		throw new NotAllowedException(NotAllowed.NotExpectedOn, on, "No se esperaba una instrucción ON en Message");
	}
}
