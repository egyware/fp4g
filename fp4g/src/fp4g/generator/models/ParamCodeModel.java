package fp4g.generator.models;

import java.util.HashMap;
import java.util.Map;

public class ParamCodeModel implements Model {
	private static final Map<String,String> defaultValues;
	static
	{
		defaultValues = new HashMap<>();
		defaultValues.put("Boolean", "false");
		defaultValues.put("Float",   "0.0f");		
		defaultValues.put("Entity",  "null");		
		defaultValues.put("Integer", "0");
		defaultValues.put("String",  "null");
	}
	
	private final String name;
	private final String type;
	private final String defaultValue;
	
	public ParamCodeModel(String name, String type)
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