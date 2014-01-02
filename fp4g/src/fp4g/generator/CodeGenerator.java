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

	/**
	 * Genera codigo dado ciertos datos
	 * 
	 * @param gameData
	 * @param path
	 * @throws Exception
	 */
	public abstract void generateCode(Code gameData, File path) throws Exception;
	/**
	 * Usa codigo prehecho dato ciertos datos.
	 * 
	 * @param gameData
	 * @param path
	 */
	public abstract void usingCode(Code gameData, File path);
}
