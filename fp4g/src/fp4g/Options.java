package fp4g;

import java.util.HashMap;

public class Options extends HashMap<String,Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Options()
	{
		put("package", "game"); //por defecto
		put("debug", false); //por defecto		
	}

}
