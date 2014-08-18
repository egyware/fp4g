package fp4g;

import fp4g.generator.Generator;

public interface Plugin 
{
	public String getName();
	public Generator<?> createGenerator();
}
