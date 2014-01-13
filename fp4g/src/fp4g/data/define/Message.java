/**
 * 
 */
package fp4g.data.define;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;

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
	public void setAdd(Add add) {
		Log.Show(ErrType.NotExpectedType,add);
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#addDefine(fp4g.data.Define)
	 */
	@Override
	public void setDefine(IDefine define) {
		Log.Show(ErrType.NotExpectedType,define);
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#addOn(fp4g.data.On)
	 */
	@Override
	public void setOn(On on) {
		Log.Show(ErrType.NotExpectedType,on);
	}
}
