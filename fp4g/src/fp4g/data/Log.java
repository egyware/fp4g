package fp4g.data;

import java.io.PrintStream;

public class Log {
	public static enum TypeLog
	{
		ErrorType,
		WarningType,
		InfoType
	}
	public static void Show(TypeLog type,int code,Value line)
	{
		switch(type)
		{
		case ErrorType:
			Error(code,line);
			break;
		case WarningType:
			Warning(code,line);
			break;
		case InfoType:
			Info(code,line);
			break;		
		}
		
	}
	private static void Info(int code,Value line) {
		// TODO Auto-generated method stub
		
	}
	private static void Warning(int code,Value line) {
		PrintStream err = System.err;
		switch(code)
		{
		case 1:
			err.println(String.format("w%ed: %s",code,"No se esperaba Define State, se ignora, cambie a otro nivel"));
			break;
		}
		
	}
	private static void Error(int code,Value line)
	{
		final String format = "%d: error%03d %s";
		PrintStream err = System.err;
		switch(code)
		{
		case 1:
			err.println(String.format(format,line.getLine(), code,"Los tipos no coinciden"));
			break;
		case 2:
			err.println(String.format(format,line.getLine(), code,"La variable buscada no está definida"));
			break;
		case 3:
			err.println(String.format(format,line.getLine(), code,"No se ha definido un sistema de entidades para el estado actual"));
			break;
		
		}
	}

}
