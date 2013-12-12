package fp4g.generator.models;

import fp4g.data.Define;

public abstract class Depend<T extends Define> 
{		
	public abstract void perform(T data, JavaCodeModel model); 
}
