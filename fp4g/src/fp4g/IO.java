package fp4g;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IO {
	
	private IO()
	{		
	}
	
	/**
	 * Copia desde source a target un archivo.
	 * 
	 * @param source
	 * @param target
	 */
	public static void copy(File source, File target)
	throws IOException 
	{
		InputStream input = null;
	    OutputStream output = null;
	    	 
		try
		{
			input = new FileInputStream(source);
			output = new FileOutputStream(target);
		 
		    byte[] buf = new byte[1024]; //1 Kbyte de buffer
		 
		    int bytesRead;
		 
		    while ((bytesRead = input.read(buf)) > 0) 
		    {
		    	output.write(buf, 0, bytesRead);
		    }
		 
		}
		finally 
		{
			 if(input != null)input.close();
			 if(output != null)output.close();		 
		}

	}
}
