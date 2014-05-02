package fp4g.generator;

import java.io.File;

import fp4g.data.ICode;

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
	public abstract void generateCode(ICode gameData, File path) throws Exception;
	/**
	 * Usa codigo prehecho dato ciertos datos.
	 * 
	 * @param gameData
	 * @param path
	 * @throws Exception 
	 */
	public abstract void usingCode(ICode gameData, File path) throws Exception;
}
