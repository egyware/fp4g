package fp4g.generator.models;

import java.util.Map;

public abstract class Depend {
		
	public abstract void perform(Map<String,Object> root,JavaCodeModel model); 
}
