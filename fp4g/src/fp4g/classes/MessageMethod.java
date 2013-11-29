package fp4g.classes;

public class MessageMethod 
{
	private String methodName;
	private String valueReplace;	
	private boolean multiple = false;
	
	public String getMethodName()
	{
		return methodName;
	}
	public String getValueReplace()
	{
		return valueReplace;
	}
	public boolean getMultiple() //deberia ser is, per no tengo tiempo para hacer comprobaciones extras.
	{
		return multiple;
	}
	public void setMethodName(String m)
	{
		methodName = m;
	}
	public void setValueReplace(String s)
	{
		valueReplace = s;
	}
	public void setMultiple(boolean b) //deberia ser is, per no tengo tiempo para hacer comprobaciones extras.
	{
		multiple = b;
	}	
}
