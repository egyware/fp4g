package fp4g.log.info;

import fp4g.log.ErrorType;

public enum Error implements ErrorType 
{
//DontMatchTypes("Los tipos no coinciden"),
//NotFoundVar("La variable buscada no está definida"),
//NotDefineFuction("La función especificada no está definida"),
//NotFoundEntitySystem("No se ha definido un sistema de entidades para el estado actual"), 
NotExpectedType("No se esperaba ese tipo"),
//ExpectedAddDefineStart("Se esperaba Define/ADD State en Start"),
//CannotCastVar(""), 
//ErrorCallFunction("Error al llamar la función"),
//BehaviorNull,
//BasedExcepted,
FunctionNotFound,
NotImplement,
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
