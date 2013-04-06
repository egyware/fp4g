package fp4g;

import java.io.PrintStream;

import fp4g.data.Value;

public class Log {	
	public static enum WarnType
	{
		ExpectedDefine,
		NotFoundDefine,
		CustomAddState, 
		NotExpectedThis,
	}
	public static enum ErrType
	{	
		DontMatchTypes,
		NotFoundVar,
		NotFoundEntitySystem, 
		NotExpectedType,
		ExpectedAddDefineStart
	}
	public static enum InfoType
	{	
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
		final String message;
		switch(type)
		{
		default:
			message = "warning/info/error no detallado";
		}		
		out.println(String.format(format,line, code,message));		
	}
	private static void Warning(final WarnType type,final int line) {		
		final String format = "%d: warn%03d %s";
		final PrintStream err = System.err;
		final int code = type.ordinal();		
		final String message;
		switch(type)
		{
		case ExpectedDefine:
			message = "No se esperaba Define State, se ignora, cambie a otro nivel";
			break;
		case NotFoundDefine:
			message = "No se encontró una definición previa, se omitirá y se asumirá que existe";			
			break;
		default:
			message = "warning/info/error no detallado";
		}		
		err.println(String.format(format,line, code,message));
	}
	private static void Error(final ErrType type,final int line)
	{
		final String format = "%d: error%03d %s";
		final PrintStream err = System.err;
		final int code = type.ordinal();		
		final String message;
		switch(type)
		{
		case DontMatchTypes:
			message = "Los tipos no coinciden";
			break;
		case NotFoundVar:
			message = "La variable buscada no está definida";
			break;
		case NotFoundEntitySystem:
			message = "No se ha definido un sistema de entidades para el estado actual";
			break;
		case ExpectedAddDefineStart:
			message = "Se esperaba Define/ADD State en Start";
			break;
		default:
			message = "warning/info/error no detallado";
		}		
		err.println(String.format(format,line, code,message));
	}

}
