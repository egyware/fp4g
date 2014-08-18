package fp4g.log;

import java.io.PrintStream;

import fp4g.data.ILine;
import fp4g.exceptions.FP4GException;
import fp4g.exceptions.FP4GRuntimeException;

public class Log {	
	private final static String formatErrorSimple = "%3d: error%03d %s";
	private final static String formatWarnSimple  = "%3d: warn%03d %s";
	private final static String formatInfoSimple  = "%3d: info%03d %s";
	private final static String formatErrorMore   = "%3d: error%03d %s (%s)";
	private final static String formatWarnMore    = "%3d: warn%03d %s (%s)";
	private final static String formatInfoMore    = "%3d: info%03d %s (%s)";
	private final static PrintStream out = System.out;
	private final static PrintStream err = System.err;
	
	public static void Exception(FP4GException e)
	{
		Show(e.getType(), -1, e.getReason());
	}
	public static void Exception(FP4GRuntimeException e)
	{
		Show(e.getType(), -1, e.getReason());
	}
	public static void Exception(FP4GException e, int line)
	{
		Show(e.getType(), line, e.getReason());
	}
	public static void Exception(FP4GRuntimeException e, int line)
	{
		Show(e.getType(), line, e.getReason());
	}
	
	public static <T extends IMessageType> void Show(T type)
	{
		if(type instanceof FP4GWarn)
		{			
			Warning((FP4GWarn) type,0,null);				
		}else
		if(type instanceof FP4GInfo)
		{	
			Info((FP4GInfo) type,0,null);	
		}else
		if(type instanceof FP4GError)
		{	
			Error((FP4GError) type,0,null);				
		}
	}
	
	public static <T extends IMessageType> void Show(T type,ILine c,String more)
	{
		if(type instanceof FP4GWarn)
		{			
			Warning((FP4GWarn) type,c.getLine(),more);				
		}else
		if(type instanceof FP4GInfo)
		{	
			Info((FP4GInfo) type,c.getLine(),more);	
		}else
		if(type instanceof FP4GError)
		{	
			Error((FP4GError) type,c.getLine(),more);				
		}
	}
	
	public static <T extends IMessageType> void Show(T type,ILine c)
	{
		if(type instanceof FP4GWarn)
		{			
			Warning((FP4GWarn) type,c.getLine(),null);				
		}else
		if(type instanceof FP4GInfo)
		{	
			Info((FP4GInfo) type,c.getLine(),null);	
		}else
		if(type instanceof FP4GError)
		{	
			Error((FP4GError) type,c.getLine(),null);				
		}
	}
	
	public static <T extends IMessageType> void Show(T type,int line)
	{
		if(type instanceof FP4GWarn)
		{			
			Warning((FP4GWarn) type,line,null);				
		}else
		if(type instanceof FP4GInfo)
		{	
			Info((FP4GInfo) type,line,null);	
		}else
		if(type instanceof FP4GError)
		{	
			Error((FP4GError) type,line,null);				
		}
	}
	
	public static <T extends IMessageType> void Show(T type,int line,String more)
	{
		if(type instanceof FP4GWarn)
		{			
			Warning((FP4GWarn) type,line,more);				
		}else
		if(type instanceof FP4GInfo)
		{	
			Info((FP4GInfo) type,line,more);	
		}else
		if(type instanceof FP4GError)
		{	
			Error((FP4GError) type,line,more);				
		}
	}
	
	public static <T extends IMessageType> void Show(T type,String more)
	{
		if(type instanceof FP4GWarn)
		{			
			Warning((FP4GWarn) type,0,more);				
		}else
		if(type instanceof FP4GInfo)
		{	
			Info((FP4GInfo) type,0,more);	
		}else
		if(type instanceof FP4GError)
		{	
			Error((FP4GError) type,0,more);				
		}
	}
	
	private static void Info(final FP4GInfo type,final int line,final String more) {		
		final int code = type.ordinal();		
		final String message = type.getMessage();
		if(more == null)
		{
			out.println(String.format(formatInfoSimple,line, code,message));
		}
		else
		{
			out.println(String.format(formatInfoMore,line, code,message,more));
		}
	}
	private static void Warning(final FP4GWarn type,final int line,final String more) 
	{
		final int code = type.ordinal();		
		final String message = type.getMessage();				
		if(more == null)
		{
			err.println(String.format(formatWarnSimple,line, code,message));
		}
		else
		{
			err.println(String.format(formatWarnMore,line, code,message,more));
		}
	}
	private static void Error(final FP4GError type,final int line,final String more)
	{	
		final int code = type.ordinal();		
		final String message = type.getMessage();				
		if(more == null)
		{
			err.println(String.format(formatErrorSimple,line, code,message));
		}
		else
		{
			err.println(String.format(formatErrorMore,line, code,message,more));
		}		
	}
	

}
