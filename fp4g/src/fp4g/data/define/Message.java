/**
 * 
 */
package fp4g.data.define;

import fp4g.classes.MessageMethod;
import fp4g.classes.MessageMethods;
import fp4g.data.Add;
import fp4g.data.AddMethod;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;
import fp4g.data.expresion.ClassMap;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.exceptions.NotAllowedException;
import fp4g.log.info.GeneratorError;
import fp4g.log.info.NotAllowed;

/**
 * @author Edgardo
 *
 */
public class Message extends Define
{
	public static final String METHODS = "methods";	
	private final MessageMethods methods;
	private boolean factory;

	public Message(String name,IDefine parent) {
		super(DefineType.MESSAGE, name,parent);
		methods = (MessageMethods)parent.get(METHODS);
	}
	
	public Message(String name) {
		super(DefineType.MESSAGE, name);
		methods = (MessageMethods)parent.get(METHODS);
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
			throw new NotAllowedException(NotAllowed.NotExpectedAdd,code, "No se permite estos tipos en Message");			
		case AddDefine:
			throw new NotAllowedException(NotAllowed.NotExpectedAdd,code, "No se permite estos tipos en Message");			
		case AddMethod:
			final AddMethod method = (AddMethod)code;
			//ahora que hago con esto?
			setAdd(method);
			break;
		default:
			throw new FP4GRuntimeException(GeneratorError.IllegalState, code.getAddType().toString());
		}		
	}
	
	public void setAdd(AddMethod add)
	{
		//TODO por hacer todavía		
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

	
	@SuppressWarnings("unchecked")
	public MessageMethod getMessageMethod(String filterName) 
	{
		//me aseguro que está en minusculas para usarlo de la manera que se me de la gana
		ClassMap<MessageMethod> cm = (ClassMap<MessageMethod>) get(filterName.toLowerCase());		
		return cm.getValue();
	}	
	
}
