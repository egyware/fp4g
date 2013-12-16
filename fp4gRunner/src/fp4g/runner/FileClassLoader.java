package fp4g.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.badlogic.gdx.utils.GdxRuntimeException;

/**
 * 
 */
public class FileClassLoader extends ClassLoader 
{
	private File path;
	public FileClassLoader(ClassLoader cl,File path) 
	{	   
	   super(cl);
	   this.path = path;	   
	}

   public FileClassLoader(ClassLoader parent) 
   {
      super(parent);
   }
   
   protected Class<?> findClass(String name) throws ClassNotFoundException
   {
	   Class<?> clazz = findLoadedClass(name);
	   if(clazz == null)
	   {
		   try
		   {		   
			   return getParent().loadClass(name);
		   }catch(ClassNotFoundException e)
		   {			   
		   }
	   }
	   return clazz;	   
   }
   
   public InputStream getResourceAsStream(String name)
   {	   
	   System.out.println(name);
	   File file = new File(name.replace('.', File.separatorChar));
	   try {
           return new FileInputStream(file);
	   } catch (Exception ex) 
	   {
		   //TODO talvez cambiar estas excepciones
           if (file.isDirectory())
                   throw new GdxRuntimeException(String.format("Cannot open a stream to a directory: %s ",file), ex);
           throw new GdxRuntimeException(String.format("Error reading file: %s",file), ex);
	   }	   
   }
   
	public Class<?> loadClass(String name) throws ClassNotFoundException 
	{		
		Class<?> clazz = findClass(name);		
		if (clazz == null)
		{
			
			//synchronized(getClassLoadingLock(name))
			{
				String fileName = String.format("%s.class",name.replace('.', File.separatorChar));
				try {
					clazz = createClass(new File(path,fileName));
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		}
		return clazz;
	}

   public Class<?> createClass(File file) throws IOException 
   {
	  FileInputStream fis = null; 
      try
      {         
    	 fis = new FileInputStream(file);
         byte[] bytes = new byte[fis.available()];
         int read = fis.read(bytes);
         if (read != bytes.length) {
        	fis.close();
            return null;
         }
         fis.close();
         return createClass(bytes);
      }
      finally
      {    	  
      }
   }

   public Class<?> createClass(byte[] bytes) 
   {
      Class<?> clazz = defineClass(null, bytes, 0, bytes.length);
      resolveClass(clazz);
      return clazz;
   }
}
