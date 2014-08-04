package fp4g.generator;

import java.io.File;

import fp4g.data.ICode;

public abstract class CodeGenerator <M extends MetaSourceModel, T extends Generator<M>>
{
	protected final T generator;
	
	public CodeGenerator(T generator)
	{
		this.generator = generator;
	}

	/**
	 * Genera codigo dado ciertos datos
	 * 
	 * @param codeData
	 * @param path
	 * @throws Exception
	 */
	public abstract void generateCode(ICode codeData, File path) throws Exception;
	/**
	 * Usa codigo prehecho dato ciertos datos.
	 * 
	 * @param codeData
	 * @param path
	 * @throws Exception 
	 */
	public abstract void usingCode(ICode codeData, File path) throws Exception;
}
