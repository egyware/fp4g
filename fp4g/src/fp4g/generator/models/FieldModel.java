package fp4g.generator.models;

public class FieldModel implements Model {
	public String type;
	public String name;
	public Object value;
	
	public final String getType() {
		return type;
	}
	public final String getName() {
		return name;
	}
	public final Object getValue() {
		return value;
	}	
	
}
