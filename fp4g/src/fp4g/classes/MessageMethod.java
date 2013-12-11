package fp4g.classes;

import fp4g.data.define.Message;

/**
 * Esta clase sirve de apoyo para guardar los metodos de los mensajes.
 * 
 * @author Edgardo
 *
 */
public class MessageMethod 
{
	private Message message;
	private String methodName;
	private String valueReplace;
	private String params;
	private boolean attachInputProcesor;
	private boolean multiple = false;
	
	//mensaje por conveniencia dentro del sistema
	public MessageMethod(Message m)
	{
		message = m; 
	}
	//para ser usado dentro del set
	public MessageMethod()
	{		
	}
	
	
	public final Message getMessage()
	{
		return message;
	}	
	
	public final String getName()
	{
		return methodName;
	}
	public final String getValueReplace()
	{
		return valueReplace;
	}
	public final boolean getMultiple() //deberia ser is, per no tengo tiempo para hacer comprobaciones extras.
	{
		return multiple;
	}
	//TODO corregir, para poder usar is en vez de get en caso de ser boolean
	public final boolean isAttachInputProcessor()
	{
		return attachInputProcesor;
	}
	public final void setName(String m)
	{
		methodName = m;
	}
	public final void setValueReplace(String s)
	{
		valueReplace = s;
	}
	public final void setMultiple(boolean b) //deberia ser is, per no tengo tiempo para hacer comprobaciones extras.
	{
		multiple = b;
	}
	public final String getParams() {
		return params;
	}
	public final void setParams(String params) {
		this.params = params;
	}
	public final void setMessage(Message m)
	{
		message = m;
	}
	public final void setAttachInputProcessor(boolean b)
	{
		attachInputProcesor = b;
	}
}
