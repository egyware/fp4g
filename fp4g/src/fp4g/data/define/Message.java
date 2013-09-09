/**
 * 
 */
package fp4g.data.define;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.ObjectType;
import fp4g.data.On;

/**
 * @author Edgardo
 *
 */
public class Message extends Define {

	public Message(String name,Define parent) {
		super(ObjectType.MESSAGE, name,parent);		
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#addADD(fp4g.data.Add)
	 */
	@Override
	public void addAdd(Add add) {
		Log.Show(ErrType.NotExpectedType,add);
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#addDefine(fp4g.data.Define)
	 */
	@Override
	public void addDefine(Define define) {
		Log.Show(ErrType.NotExpectedType,define);
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#addOn(fp4g.data.On)
	 */
	@Override
	public void addOn(On on) {
		Log.Show(ErrType.NotExpectedType,on);
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#isDefined(fp4g.data.ObjectType, java.lang.String)
	 */
	@Override
	public boolean isDefined(ObjectType type, String name) {		
		return type == ObjectType.VAR &&  isSet(name);
	}	
}
