package fp4g.log;

import java.io.PrintStream;

import fp4g.data.ICode;

public class Log {	
	private final static String formatErrorSimple = "%3d: error%03d %s";
	private final static String formatWarnSimple  = "%3d: warn%03d %s";
	private final static String formatInfoSimple  = "%3d: info%03d %s";
	private final static String formatErrorMore   = "%3d: error%03d %s (%s)";
	private final static String formatWarnMore    = "%3d: warn%03d %s (%s)";
	private final static String formatInfoMore    = "%3d: info%03d %s (%s)";
	private final static PrintStream out = System.out;
	private final static PrintStream err = System.err;
	
	
//	public static <T extends IMessageType> void Show(T type)
//	{
//		if(type instanceof WarnType)
//		{			
//			Warning((WarnType) type,0,null);				
//		}else
//		if(type instanceof InfoType)
//		{	
//			Info((InfoType) type,0,null);	
//		}else
//		if(type instanceof ErrorType)
//		{	
//			Error((ErrorType) type,0,null);				
//		}
//	}
	
//	public static <T extends IMessageType> void Show(T type,ICode c,String more)
//	{
//		if(type instanceof WarnType)
//		{			
//			Warning((WarnType) type,c.getLine(),more);				
//		}else
//		if(type instanceof InfoType)
//		{	
//			Info((InfoType) type,c.getLine(),more);	
//		}else
//		if(type instanceof ErrorType)
//		{	
//			Error((ErrorType) type,c.getLine(),more);				
//		}
//	}
//	
//	public static <T extends IMessageType> void Show(T type,ICode c)
//	{
//		if(type instanceof WarnType)
//		{			
//			Warning((WarnType) type,c.getLine(),null);				
//		}else
//		if(type instanceof InfoType)
//		{	
//			Info((InfoType) type,c.getLine(),null);	
//		}else
//		if(type instanceof ErrorType)
//		{	
//			Error((ErrorType) type,c.getLine(),null);				
//		}
//	}
//	
//	public static <T extends IMessageType> void Show(T type,int line)
//	{
//		if(type instanceof WarnType)
//		{			
//			Warning((WarnType) type,line,null);				
//		}else
//		if(type instanceof InfoType)
//		{	
//			Info((InfoType) type,line,null);	
//		}else
//		if(type instanceof ErrorType)
//		{	
//			Error((ErrorType) type,line,null);				
//		}
//	}
//	
//	public static <T extends IMessageType> void Show(T type,int line,String more)
//	{
//		if(type instanceof WarnType)
//		{			
//			Warning((WarnType) type,line,more);				
//		}else
//		if(type instanceof InfoType)
//		{	
//			Info((InfoType) type,line,more);	
//		}else
//		if(type instanceof ErrorType)
//		{	
//			Error((ErrorType) type,line,more);				
//		}
//	}
//	
//	public static <T extends IMessageType> void Show(T type,String more)
//	{
//		if(type instanceof WarnType)
//		{			
//			Warning((WarnType) type,0,more);				
//		}else
//		if(type instanceof InfoType)
//		{	
//			Info((InfoType) type,0,more);	
//		}else
//		if(type instanceof ErrorType)
//		{	
//			Error((ErrorType) type,0,more);				
//		}
//	}
//	
//	
//	
//	private static void Info(final InfoType type,final int line,final String more) {		
//		final int code = type.ordinal();		
//		final String message = type.getMessage();
//		if(more == null)
//		{
//			out.println(String.format(formatInfoSimple,line, code,message));
//		}
//		else
//		{
//			out.println(String.format(formatInfoMore,line, code,message,more));
//		}
//	}
//	private static void Warning(final WarnType type,final int line,final String more) {
//		final int code = type.ordinal();		
//		final String message = type.getMessage();				
//		if(more == null)
//		{
//			err.println(String.format(formatWarnSimple,line, code,message));
//		}
//		else
//		{
//			err.println(String.format(formatWarnMore,line, code,message,more));
//		}
//	}
//	private static void Error(final ErrorType type,final int line,final String more)
//	{	
//		final int code = type.ordinal();		
//		final String message = type.getMessage();				
//		if(more == null)
//		{
//			err.println(String.format(formatErrorSimple,line, code,message));
//		}
//		else
//		{
//			err.println(String.format(formatErrorMore,line, code,message,more));
//		}		
//	}
//	

}
