package fp4g.classes;

public class MessageMethod 
{
	private String methodName;
	private String valueReplace;
	private String params;
	private boolean multiple = false;
	
	public final String getMethodName()
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
	public final void setMethodName(String m)
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
}
