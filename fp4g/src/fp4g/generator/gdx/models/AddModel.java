package fp4g.generator.gdx.models;

import java.util.List;

import fp4g.generator.Model;

public class AddModel implements Model {

	public String name;
	public String varName;
	public List<String> params;
	
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

}
