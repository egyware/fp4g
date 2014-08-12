package fp4g.generator.gdx.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

import fp4g.generator.MetaSourceModel;

public class JavaMetaSourceModel 
implements MetaSourceModel 
{
	private final TreeSet<String> imports;
	private final TreeSet<String> interfaces;
	private final String pckg;//package
	private final String name;
	private String javadoc;
	
	
	public JavaMetaSourceModel(String pckg, String name)
	{
		imports = new TreeSet<String>();
		interfaces = new TreeSet<String>();
		this.pckg = pckg;
		this.name = name;
	}
	
	public void addInterface(String _interface)
	{
		interfaces.add(_interface);
	}
	
	//accesors
	public String getPckg()
	{
		return pckg;
	}
	public String getJavadoc()
	{
		return javadoc;
	}
	public void setJavadoc(String doc)
	{
		javadoc = doc;
	}
	
	public String getName()
	{
		return name;
	}
	public TreeSet<String> getImports()
	{
		return imports;
	}
	public TreeSet<String> getInterfaces()
	{
		return interfaces;
	}

	@Override
	public void addRequireSource(String sourcePseudoPath) 
	{
		imports.add(sourcePseudoPath);			
	}

	@Override
	public void addRequireSource(Collection<String> sourcePseudoPath) 
	{
		imports.addAll(sourcePseudoPath);		
	}

	@Override
	public void addRequireSource(String[] sourcePseudoPaths) 
	{
		imports.addAll(Arrays.asList(sourcePseudoPaths));		
	}
	
}
