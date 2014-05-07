package fp4g.generator.gdx;

import java.io.File;

import fp4g.data.ICode;
import fp4g.data.define.Behavior;
import fp4g.exceptions.FP4GException;
import fp4g.log.info.Error;

public class BehaviorGenerator extends JavaCodeGenerator
{

	public BehaviorGenerator(JavaGenerator generator) 
	{
		super(generator);		
	}

	@Override
	public void generateCode(ICode gameData, File path) throws Exception 
	{
		throw new FP4GException(Error.NotImplement, "No está implementado este generador"); 
	}

	@Override
	public void usingCode(ICode gameData, File path)
	{
		Behavior behavior = (Behavior)gameData;
		generator.usingFile(generator.sourceDir, String.format("com/apollo/components/%sBehavior.java",behavior.name));		
		
	}

}
