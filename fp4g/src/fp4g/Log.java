package fp4g;

import java.io.PrintStream;

import fp4g.data.Code;

public class Log {	
	protected static interface MessageType
	{
		public String getMessage();
		
	}
	public static enum WarnType implements MessageType
	{			
		MissingDefineAdd("No se encontro un Define para el Add"),
		NotFoundDefine("No se encontró una definición previa, se omitirá y se asumirá que existe"),
		CustomAddState, 
		NotExpectedThis, ParentBehaviorNull, NotImplement;
		
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
		DontMatchTypes("Los tipos no coinciden"),
		NotFoundVar("La variable buscada no está definida"),
		NotDefineFuction("La función especificada no está definida"),
		NotFoundEntitySystem("No se ha definido un sistema de entidades para el estado actual"), 
		NotExpectedType("No se esperaba ese tipo"),
		ExpectedAddDefineStart("Se esperaba Define/ADD State en Start"),
		CannotCastVar(""), 
		ErrorCallFunction("Error al llamar la función"),
		BehaviorNull,
		BasedExcepted,
		UnknowError;
		
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
		NoValidTestType("NO VALIDO!");
		
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
		Show(type,0);
	}
	public static <T extends MessageType> void Show(T type,Object v)
	{
		if(v instanceof Code)
		{
			Show(type,v);
		}
		else
		{
			//TODO [egyware] No es un error que tiene asociado una linea
		}
	}
	public static void Show(ErrType type,Code line)
	{
		Error(type,line.getLine());
	}
	public static void Show(WarnType type,Code line)
	{
		Warning(type,line.getLine());		
	}
	public static void Show(InfoType type,Code line)
	{
		Info(type,line.getLine());		
	}
	public static void Show(ErrType type,int line)
	{
		Error(type,line);
	}
	public static void Show(WarnType type,int line)
	{
		Warning(type,line);		
	}
	public static void Show(InfoType type,int line)
	{
		Info(type,line);		
	}	
	private static void Info(final InfoType type,final int line) {
		final String format = "%d: info%03d %s";
		final PrintStream out = System.out;
		final int code = type.ordinal();		
		final String message = type.getMessage();				
		out.println(String.format(format,line, code,message));		
	}
	private static void Warning(final WarnType type,final int line) {		
		final String format = "%d: warn%03d %s";
		final PrintStream err = System.err;
		final int code = type.ordinal();		
		final String message = type.getMessage();				
		err.println(String.format(format,line, code,message));
	}
	private static void Error(final ErrType type,final int line)
	{
		final String format = "%d: error%03d %s";
		final PrintStream err = System.err;
		final int code = type.ordinal();		
		final String message = type.getMessage();				
		err.println(String.format(format,line, code,message));
	}

}
