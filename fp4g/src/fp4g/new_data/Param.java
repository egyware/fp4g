package fp4g.new_data;

/**
 * Encapsula un parametro 
 */
public class Param {
	static enum Type {Integer,Double,String};
	public String name;
	public Type type;
	public Object default_value;
	
}
