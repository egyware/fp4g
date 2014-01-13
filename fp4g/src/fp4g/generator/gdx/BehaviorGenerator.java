package fp4g.generator.gdx;

import java.io.File;

import fp4g.data.ICode;
import fp4g.data.define.Behavior;
import fp4g.generator.CodeGenerator;

public class BehaviorGenerator extends CodeGenerator<JavaGenerator> {

	public BehaviorGenerator(JavaGenerator generator) 
	{
		super(generator);		
	}

	@Override
	public void generateCode(ICode gameData, File path) throws Exception 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void usingCode(ICode gameData, File path)
	{
		Behavior behavior = (Behavior)gameData;
		generator.usingFile(generator.sourceDir, String.format("com/apollo/components/%s.java",behavior.name));		
		
	}

}
