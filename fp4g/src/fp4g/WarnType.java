package fp4g;


public enum WarnType implements IMessageType
	{			
		MissingDefineAdd("No se encontro un Define o Using para el Add"), 
		MissingAdd("No se encontro un Add"), UnformatedFilter, CannotEvalExpr, DependResolverNotFound, PropertiesCantSave,
//		NotFoundDefine("No se encontr� una definici�n previa, se omitir� y se asumir� que existe"),
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