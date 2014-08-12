package fp4g.generator;

import fp4g.Plugin;
import fp4g.generator.gdx.JavaGenerator;

public class JavaGdxPlugin implements Plugin 
{
	private static final String PLUGIN_NAME = "java";
	
	@Override
	public String getName() 
	{
		return PLUGIN_NAME;
	}

	@Override
	public Generator<?> createGenerator() 
	{
		return new JavaGenerator();
	}

}
