package fp4g.log;



public enum FP4GError implements IMessageType
{	
	//Errores del Generador en sí
	CompilerNotFound,
	GeneratorNotFound,
	IllegalState,
	NotImplement,
	CannotParseFile,
	PropertiesCantLoad,
	IOException,
	
	//Errores de datos
	FilterMethodMissing,
	MessagesMethodNotFound,
	ClassNotFound,
	
	//Errores de la generación
	ManagerIsNotAReceiver,
	UnExpectedParams,
	MessageNotFound,
	ManagerNotFound,
	
	//Errores de evaluacion
	CannotEvalExpresion,
	VarNameNotFound,
	NotAllowedOperation,
	IncomplatibleTypes,
	CannotSetProperty,
	CannotGetProperty, 
	FunctionNotFound,
	NotValidExpresion,
	ExpresionGeneratorNotFound,
	
	//error del parsing 
	DefineTypeNotFound, 
	NotExceptedAdd, 
	NotExpectedOn, 
	DefineIsRequired,   
	   
	
	
	
	//No permitido
	
	;
	
	private final String message;
	private FP4GError()
	{
		this.message = name();
	}
	private FP4GError(String message)
	{
		this.message = message;
	}	
	@Override
	public String getMessage() 
	{
		return message;
	}
}