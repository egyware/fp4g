package fp4g.generator.models;

import java.util.Map;

import fp4g.data.Define;

public abstract class Depend<T extends Define> 
{		
	public abstract void perform(T data, Map<String,Object> root, JavaCodeModel model); 
}
