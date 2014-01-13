package fp4g;

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
	
	protected static interface MessageType
	{
		public String getMessage();
		
	}
	public static enum WarnType implements MessageType
	{			
		MissingDefineAdd("No se encontro un Define o Using para el Add"), 
		MissingAdd("No se encontro un Add"), UnformatedFilter, CannotEvalExpr, DependResolverNotFound,
//		NotFoundDefine("No se encontró una definición previa, se omitirá y se asumirá que existe"),
//		CustomAddState, 
//		NotExpectedThis,
//		ParentBehaviorNull,
		;
		
		private String message;
		private WarnType()
		{
			message = this.name();
		}
		private WarnType(String msg)		
		{		
			message = msg;
		}

		@Override
		public String getMessage() {			
			return message;		
		}		
	}
	public static enum ErrType implements MessageType
	{	
//		DontMatchTypes("Los tipos no coinciden"),
//		NotFoundVar("La variable buscada no está definida"),
//		NotDefineFuction("La función especificada no está definida"),
//		NotFoundEntitySystem("No se ha definido un sistema de entidades para el estado actual"), 
		NotExpectedType("No se esperaba ese tipo"),
//		ExpectedAddDefineStart("Se esperaba Define/ADD State en Start"),
//		CannotCastVar(""), 
//		ErrorCallFunction("Error al llamar la función"),
//		BehaviorNull,
//		BasedExcepted,
		FunctionNotFound,
		NotImplement,
		MessageExpected,
		UnknowError,
		FilterMethodMissing, NotExpectedDefine, NotExpectedOn, NotExpectedAdd, YouCanUseOnceTimeAssets, MissingError("Falta un error descriptivo o no corresponde un error grave"), ClassNotFound, ExpresionGeneratorNotFound, MessageNotFound, MessageMethodNotFound, CriticalErrorGeneratorNotFound, VarNameNotFound, UnExpectedParams,
		;
		
		private String message;
		private ErrType()
		{
			message = this.name();
		}
		private ErrType(String msg)		
		{		
			message = msg;
		}

		@Override
		public String getMessage() {			
			return message;		
		}
	}
	public static enum InfoType implements MessageType
	{	
		//NoValidTestType("NO VALIDO!")
		;
		
		private String message;
		private InfoType()
		{
			message = this.name();
		}
		private InfoType(String msg)		
		{		
			message = msg;
		}

		@Override
		public String getMessage() {			
			return message;		
		}
	}
	public static <T extends MessageType> void Show(T type)
	{
		if(type instanceof WarnType)
		{			
			Warning((WarnType) type,0,null);				
		}else
		if(type instanceof InfoType)
		{	
			Info((InfoType) type,0,null);	
		}else
		if(type instanceof ErrType)
		{	
			Error((ErrType) type,0,null);				
		}
	}
	
	public static <T extends MessageType> void Show(T type,ICode c,String more)
	{
		if(type instanceof WarnType)
		{			
			Warning((WarnType) type,c.getLine(),more);				
		}else
		if(type instanceof InfoType)
		{	
			Info((InfoType) type,c.getLine(),more);	
		}else
		if(type instanceof ErrType)
		{	
			Error((ErrType) type,c.getLine(),more);				
		}
	}
	
	public static <T extends MessageType> void Show(T type,ICode c)
	{
		if(type instanceof WarnType)
		{			
			Warning((WarnType) type,c.getLine(),null);				
		}else
		if(type instanceof InfoType)
		{	
			Info((InfoType) type,c.getLine(),null);	
		}else
		if(type instanceof ErrType)
		{	
			Error((ErrType) type,c.getLine(),null);				
		}
	}
	
	public static <T extends MessageType> void Show(T type,int line)
	{
		if(type instanceof WarnType)
		{			
			Warning((WarnType) type,line,null);				
		}else
		if(type instanceof InfoType)
		{	
			Info((InfoType) type,line,null);	
		}else
		if(type instanceof ErrType)
		{	
			Error((ErrType) type,line,null);				
		}
	}
	
	public static <T extends MessageType> void Show(T type,int line,String more)
	{
		if(type instanceof WarnType)
		{			
			Warning((WarnType) type,line,more);				
		}else
		if(type instanceof InfoType)
		{	
			Info((InfoType) type,line,more);	
		}else
		if(type instanceof ErrType)
		{	
			Error((ErrType) type,line,more);				
		}
	}
	
	public static <T extends MessageType> void Show(T type,String more)
	{
		if(type instanceof WarnType)
		{			
			Warning((WarnType) type,0,more);				
		}else
		if(type instanceof InfoType)
		{	
			Info((InfoType) type,0,more);	
		}else
		if(type instanceof ErrType)
		{	
			Error((ErrType) type,0,more);				
		}
	}
	
	
	
	private static void Info(final InfoType type,final int line,final String more) {		
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
	private static void Warning(final WarnType type,final int line,final String more) {
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
	private static void Error(final ErrType type,final int line,final String more)
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
		throw new RuntimeException("Error!");
	}
	

}
