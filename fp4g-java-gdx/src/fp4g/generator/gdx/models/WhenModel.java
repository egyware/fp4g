package fp4g.generator.gdx.models;

import java.util.List;

public class WhenModel 
{
	//flag name
	public final String flagName;
	public final String condition;
	public final List<String> statements;
	
	
	public WhenModel(String name, String condition, List<String> statements)
	{
		this.flagName = name;
		this.condition = condition;
		this.statements = statements;
	}
	public final String getFlagName() {
		return flagName;
	}
	public final String getCondition() {
		return condition;
	}
	public final List<String> getStatements() {
		return statements;
	}

}
