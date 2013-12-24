package fp4g.generator.gdx.models;

import java.util.TreeSet;

import fp4g.generator.Model;

public class JavaCodeModel implements Model{
	public final TreeSet<String> imports;
	public final TreeSet<String> interfaces;
	public String pckg;//package
	public String javadoc;
	public String name;
	
	public JavaCodeModel()
	{
		imports = new TreeSet<String>();
		interfaces = new TreeSet<String>();
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
