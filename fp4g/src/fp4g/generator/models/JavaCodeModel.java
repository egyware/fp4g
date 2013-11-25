package fp4g.generator.models;

import java.util.TreeSet;

public class JavaCodeModel {
	public final TreeSet<String> imports;
	public final TreeSet<String> interfaces;
	public String pckg;//package
	public String javadoc;
	public String name;
	
	public JavaCodeModel()
	{
		imports = new TreeSet<>();
		interfaces = new TreeSet<>();
	}
	
	public void addImport(String _class)
	{
		imports.add(_class);
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
	
	
}
