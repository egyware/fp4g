package fp4g;

import java.util.HashMap;

public class Options extends HashMap<String,Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Options()
	{
		put("package", Configuration.getProperty(Configuration.DEFAULT_PACKAGE)); //por defecto
		put("debug", Boolean.parseBoolean(Configuration.getProperty(Configuration.DEFAULT_DEBUG))); //por defecto		
	}

}
