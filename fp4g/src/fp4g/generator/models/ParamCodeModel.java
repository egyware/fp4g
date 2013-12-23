package fp4g.generator.models;

import java.util.HashMap;
import java.util.Map;

public class ParamCodeModel implements Model {
	private static final Map<String,String> defaultValues;
	static
	{
		defaultValues = new HashMap<String, String>();
		defaultValues.put("Boolean", "false");
		defaultValues.put("Number",   "0");		
		defaultValues.put("Entity",  "null");
		defaultValues.put("String",  "null");
	}
	
	private final String name;
	private final String type;
	private final String defaultValue;
	
	public ParamCodeModel(String type,String name)
	{
		this.name = name;
		this.type = type;
		defaultValue = defaultValues.get(type);		
	}
	
	public String getName()
	{
		return name;
	}
	public String getType()
	{
		return type;
	}
	public String getDefaultValue()
	{
		return defaultValue;
	}
}