package fp4g.generator.gdx.models;

import java.util.List;

import fp4g.generator.Model;

public class SystemModel  implements Model{	
	public String preinit;
	public List<FieldModel> fields;
	public List<String> argumentList;
	public String preupdate;
	public String postupdate;
	
	public final String getPreinit() {
		return preinit;
	}
	public final List<FieldModel> getFields() {
		return fields;
	}
	public final List<String> getArgumentList() {
		return argumentList;
	}
	public final String getPreupdate() {
		return preupdate;
	}
	public final String getPostupdate() {
		return postupdate;
	}	 

}
