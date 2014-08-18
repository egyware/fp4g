package fp4g.log;


public enum FP4GWarn implements IMessageType
{
	//problemas de generacion
	DefineDependResolverNotFound,
	DefineNotFound,
	
	//problemas del generador	
	PropertiesCantSave,
	
	//problemas de la generaciòn
	MissingDefineAdd
	 
	
//	MissingDefineAdd("No se encontro un Define o Using para el Add"), 
//	MissingAdd("No se encontro un Add"),	
 
//	IOException,
//	
//	NotExpectedGame,
//	NotExpectedOn, 
//	NotExpectedAdd,
//	NotImplementedYet,

	;
	
	private final String message;
	private FP4GWarn()
	{
		this.message = name();
	}
	private FP4GWarn(String message)
	{
		this.message = message;
	}

	@Override
	public String getMessage() 
	{
		return message;
	}	
}