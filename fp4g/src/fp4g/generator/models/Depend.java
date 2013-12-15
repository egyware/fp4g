package fp4g.generator.models;

import fp4g.data.Define;
import fp4g.data.define.Game;

public abstract class Depend<T extends Define> 
{		
	public abstract Class<T> getForClass();
	public abstract void install(Game code);
	public abstract void perform(T data, JavaCodeModel model); 
}
