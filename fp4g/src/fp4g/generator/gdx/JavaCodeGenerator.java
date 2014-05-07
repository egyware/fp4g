package fp4g.generator.gdx;

import fp4g.generator.CodeGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;

public abstract class JavaCodeGenerator extends CodeGenerator<JavaMetaSourceModel, JavaGenerator>
{

	public JavaCodeGenerator(JavaGenerator generator) 
	{
		super(generator);	
	}

}
