package fp4g.generator;

import java.util.Collection;

public interface MetaSourceModel 
{
	public String getName();
	public void addRequireSource(String sourcePseudoPath);
	public void addRequireSource(String[] sourcePseudoPaths);
	public void addRequireSource(Collection<String> sourcePseudoPath);

}
