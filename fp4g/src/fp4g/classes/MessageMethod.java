package fp4g.classes;


/**
 * Esta clase sirve de apoyo para guardar los metodos de los mensajes.
 * 
 * @author Edgardo
 *
 */
public final class MessageMethod 
{
	private String valueReplace;
	private boolean attachInputProcesor;
	private boolean multiple = false;
	
	//para ser usado dentro del set
	public MessageMethod()
	{		
	}
	
	public final String getReplace()
	{
		return valueReplace;
	}
	
	public final boolean isMultiple() 
	{
		return multiple;
	}	
	
	public final boolean isAttachInputProcessor()
	{
		return attachInputProcesor;
	}
	
	public final void setReplace(String s)
	{
		valueReplace = s;
	}
	public final void setMultiple(boolean b) //deberia ser is, per no tengo tiempo para hacer comprobaciones extras.
	{
		multiple = b;
	}
	
	public final void setAttachInputProcessor(boolean b)
	{
		attachInputProcesor = b;
	}


}