package fp4g;

import java.util.HashMap;

public class Options extends HashMap<String,Object> {

	public static final String PACKAGE = "package";
	public static final String DEBUG = "debug";
	public static final String COMPILER = "compiler";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Options()
	{
		put("package", Configuration.getProperty(Configuration.DEFAULT_PACKAGE)); //por defecto
		put("debug", Boolean.parseBoolean(Configuration.getProperty(Configuration.DEFAULT_DEBUG))); //por defecto
		put("compiler",Configuration.getProperty(Configuration.DEFAULT_COMPILER)); //por defecto
		
	}

}
