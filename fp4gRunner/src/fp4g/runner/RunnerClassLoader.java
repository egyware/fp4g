package fp4g.runner;

import java.net.URL;
import java.net.URLClassLoader;

public class RunnerClassLoader extends URLClassLoader
{

	public RunnerClassLoader(URL[] urls,ClassLoader parent)
	{
		super(urls,parent);
	}
	
	public void addURL(URL url)
	{
		super.addURL(url);
	}

}
