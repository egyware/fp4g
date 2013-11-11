package fp4g.generator.models;

import java.util.TreeSet;

public class JavaCodeModel {
	public final TreeSet<String> imports;
	public String pckg;//package
	public String javadoc;
	public String name;
	
	public JavaCodeModel()
	{
		imports = new TreeSet<>();
	}
	
	public void addImport(String _class)
	{
		imports.add(_class);
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
	public String getName()
	{
		return name;
	}
	public TreeSet<String> getImports()
	{
		return imports;
	}
	
	
}
