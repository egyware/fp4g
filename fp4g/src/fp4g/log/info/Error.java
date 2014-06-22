package fp4g.log.info;

import fp4g.log.ErrorType;

public enum Error implements ErrorType 
{
NotExpectedType("No se esperaba ese tipo"),
FunctionNotFound,
MessageExpected,
UnknowError,
FilterMethodMissing,
YouCanUseOnceTimeAssets,
MissingError("Falta un error descriptivo o no corresponde un error grave"), 
ClassNotFound,
MessageNotFound,
MessageMethodNotFound,
UnExpectedParams,
PropertiesCantLoad,
UncaughtException,
ManagerIsNotAReceiver, 
UnformatedFilter,
;

	private final String message;
	private Error()
	{
		message = this.name();
	}
	private Error(String msg)		
	{		
		message = msg;
	}	
	
	@Override
	public String getMessage()
	{	
		return message;
	}

}
