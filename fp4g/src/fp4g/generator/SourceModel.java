package fp4g.generator;


public class SourceModel<T extends MetaSourceModel>
{
	private T metaSource;
	
	public SourceModel(T metaSource)
	{
		this.metaSource = metaSource;
	}
	
	public final T getMetaSource()
	{
		return metaSource;
	}
}
