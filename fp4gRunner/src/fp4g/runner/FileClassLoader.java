/**
 * @(#)FileClassLoader.java	1.0 12/09/2008
 */

package fp4g.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileClassLoader extends URLClassLoader to provide functionality for
 * loading a class from a file or byte array.
 * 
 * @author Darryl
 * @see URLClassLoader
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
	public Class<?> loadClass(String name) throws ClassNotFoundException 
	{		
		Class<?> clazz = findClass(name);		
		if (clazz == null)
		{
			synchronized(getClassLoadingLock(name))
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
      
      try 
      (FileInputStream fis = new FileInputStream(file))
      {         
         byte[] bytes = new byte[fis.available()];
         int read = fis.read(bytes);
         if (read != bytes.length) {
            return null;
         }
         return createClass(bytes);
      }
   }

   public Class<?> createClass(byte[] bytes) 
   {
      Class<?> clazz = defineClass(null, bytes, 0, bytes.length);
      resolveClass(clazz);
      return clazz;
   }
}
