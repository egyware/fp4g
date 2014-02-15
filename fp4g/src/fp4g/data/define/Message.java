/**
 * 
 */
package fp4g.data.define;

import fp4g.classes.MessageMethod;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;
import fp4g.data.expresion.ClassMap;
import fp4g.log.info.NotAllowed;

/**
 * @author Edgardo
 *
 */
public class Message extends Define
{
	private boolean factory;

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
		throw new NotAllowedException(NotAllowed.NotExpectedAdd, add, "No se esperaba una instruci�n Add en Mesage");
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#addDefine(fp4g.data.Define)
	 */
	@Override
	public void setDefine(IDefine define) {
		throw new NotAllowedException(NotAllowed.NotExpectedDefine, define, "No se esperaba una instrucci�n Define en Message");
	}

	/* (non-Javadoc)
	 * @see fp4g.data.Define#addOn(fp4g.data.On)
	 */
	@Override
	public void setOn(On on) {
		throw new NotAllowedException(NotAllowed.NotExpectedOn, on, "No se esperaba una instrucci�n ON en Message");
	}
	
	/**
	 * Devuelve si los mensajes se requiren necesariamente est�r en el Factory de entidades.
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
		//me aseguro que est� en minusculas para usarlo de la manera que se me de la gana
		ClassMap<MessageMethod> cm = (ClassMap<MessageMethod>) get(filterName.toLowerCase());		
		return cm.getValue();
	}	
	
}
