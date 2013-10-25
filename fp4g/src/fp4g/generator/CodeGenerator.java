package fp4g.generator;

import java.io.File;

import fp4g.data.Code;

public abstract class CodeGenerator <T extends Generator>
{
	protected final T generator;
	public CodeGenerator(T generator)
	{
		this.generator = generator;
	}
	
	public abstract void generateCode(Code gameData, File path) throws Exception;
}
