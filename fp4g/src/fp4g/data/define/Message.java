/**
 * 
 */
package fp4g.data.define;

import fp4g.classes.MessageMethods;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineTypes;
import fp4g.data.ILib;
import fp4g.data.On;
import fp4g.data.add.AddMethod;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.FP4GError;

/**
 * @author Edgardo
 *
 */
public class Message extends Define
{
	public static final String METHODS = "methods";	
	private static MessageMethods methods;
	private boolean factory;

	public Message(String name,ILib container) 
	{
		super(DefineTypes.MESSAGE, name,container);
		if(methods == null)
		{
			methods = (MessageMethods)container.get(METHODS).getValue();
		}
	}
	
	public Message(String name) {
		super(DefineTypes.MESSAGE, name);
		if(methods == null)
		{
			methods = (MessageMethods)lib.get(METHODS).getValue();
		}
	}
	
	/* (non-Javadoc)
	 * @see fp4g.data.Define#addADD(fp4g.data.Add)
	 */
	@Override
	public void setAdd(Add code) 
	{
		switch(code.addType)
		{
		case AddAsset:
			throw new FP4GRuntimeException(FP4GError.NotExceptedAdd, code, "No se permite estos tipos en Message");			
		case AddDefine:
			throw new FP4GRuntimeException(FP4GError.NotExceptedAdd, code, "No se permite estos tipos en Message");			
		case AddMethod:
			final AddMethod method = (AddMethod)code;
			//también lo agrego a las variables globales :P
			methods.add(method);
			super.setAdd(method);
			method.setMessage(this);
			break;
		default:
			throw new FP4GRuntimeException(FP4GError.IllegalState, code.getAddType().toString());
		}		
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#addOn(fp4g.data.On)
	 */
	@Override
	public void setOn(On on) {
		throw new FP4GRuntimeException(FP4GError.NotExpectedOn, on, "No se esperaba una instrucción ON en Message");
	}
	
	/**
	 * Devuelve si los mensajes se requiren necesariamente estár en el Factory de entidades.
	 * @return
	 */
	public boolean isFactory() {
		return factory;
	}

	public void setFactory(boolean factory) {
		this.factory = factory;
	}		
}
