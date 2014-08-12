package fp4g.generator.gdx.models;

import java.util.HashMap;
import java.util.Map;

public class VarCodeModel
{
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
	
	public VarCodeModel(String type,String name, String value)
	{
		this.name = name;
		this.type = type;
		defaultValue = value;
	}
	public VarCodeModel(String type,String name)
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