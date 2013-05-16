package fp4g;

import java.io.PrintStream;

import fp4g.data.Value;

public class Log {	
	private static interface MessageType
	{
		public String getMessage();
		
	}
	public static enum WarnType implements MessageType
	{	
		ExpectedDefine("No se esperaba Define State, se ignora, cambie a otro nivel"),
		NotFoundDefine("No se encontr� una definici�n previa, se omitir� y se asumir� que existe"),
		CustomAddState, 
		NotExpectedThis;
		
		private String message;
		private WarnType()
		{
			this("warning no detallado");
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
		NotFoundVar("La variable buscada no est� definida"),
		NotDefineFuction("La funci�n especificada no est� definida"),
		NotFoundEntitySystem("No se ha definido un sistema de entidades para el estado actual"), 
		NotExpectedType("No se esperaba ese tipo"),
		ExpectedAddDefineStart("Se esperaba Define/ADD State en Start"),
		CannotCastVar(""), 
		ErrorCallFunction("Error al llamar la funci�n");
		
		private String message;
		private ErrType()
		{
			this("error no detallado");
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
			this("info no detallado");
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
	public static <T extends MessageType> void Show(T type,Object v)
	{
		if(v instanceof Value)
		{
			Show(type,v);
		}
		else
		{
			//TODO [egyware] No es un error que tiene asociado una linea
		}
	}
	public static void Show(ErrType type,Value line)
	{
		Error(type,line.getLine());
	}
	public static void Show(WarnType type,Value line)
	{
		Warning(type,line.getLine());		
	}
	public static void Show(InfoType type,Value line)
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
