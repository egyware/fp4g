package fp4g.classes;

public class MessageMethod 
{
	private String methodName;
	private String valueRegex;	
	private boolean multiple = false;
	
	public String getMethodName()
	{
		return methodName;
	}
	public String getValueRegex()
	{
		return valueRegex;
	}
	public boolean getMultiple() //deberia ser is, per no tengo tiempo para hacer comprobaciones extras.
	{
		return multiple;
	}
	public void setMethodName(String m)
	{
		methodName = m;
	}
	public void setValueRegex(String s)
	{
		valueRegex = s;
	}
	public void setMultiple(boolean b) //deberia ser is, per no tengo tiempo para hacer comprobaciones extras.
	{
		multiple = b;
	}	
}
