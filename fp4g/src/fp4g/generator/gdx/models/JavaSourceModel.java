package fp4g.generator.gdx.models;

import fp4g.generator.SourceModel;

public class JavaSourceModel extends SourceModel<JavaMetaSourceModel> 
{
	
	public JavaSourceModel(JavaMetaSourceModel metaSourceModel) 
	{
		super(metaSourceModel);
	}

	/** alias */
	public JavaMetaSourceModel getSource()
	{
		return getMetaSource();
	}
}
