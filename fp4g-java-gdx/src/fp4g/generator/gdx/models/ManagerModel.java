package fp4g.generator.gdx.models;


import java.util.HashMap;
import java.util.List;

public class ManagerModel implements Comparable<ManagerModel>
{
	public String name;
	public String setMethod;
	public String varName;
	public List<String> params;
	public List<String> preInitialize;
	public List<String> postInitialize;
	public List<String> preUpdate;
	public List<String> postUpdate;
	public List<String> fields;
	public int priority;
	public HashMap<String, String> property;
	
	public ManagerModel()
	{				
	}
	
	public final String getName() 
	{
		return name;
	}

	public final String getVarName()
	{
		return varName;
	}

	public final List<String> getParams()
	{
		return params;
	}	
	
	
	public final String getSetMethod()
	{
		return setMethod;
	}
	
	public final List<String> getPreInitialize()
	{
		return preInitialize;
	}
	public final List<String> getPostInitialize()
	{
		return postInitialize;
	}

	public final List<String> getFields() {
		return fields;
	}

	public final List<String> getPreUpdate() {
		return preUpdate;
	}

	public final List<String> getPostUpdate() {
		return postUpdate;
	}
	
	public int compareTo(ManagerModel other)
	{
		return (priority - other.priority);
	}

	public final HashMap<String, String> getProperty() {
		return property;
	}

	public final void setProperty(HashMap<String, String> property) {
		this.property = property;
	}
	
	
}
