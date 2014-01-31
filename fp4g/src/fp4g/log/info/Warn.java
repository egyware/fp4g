package fp4g.log.info;

import fp4g.log.WarnType;


public enum Warn implements WarnType
{			
	MissingDefineAdd("No se encontro un Define o Using para el Add"), 
	MissingAdd("No se encontro un Add"),
	UnformatedFilter,
	CannotEvalExpr,
	DependResolverNotFound,
	PropertiesCantSave,
//		NotFoundDefine("No se encontr� una definici�n previa, se omitir� y se asumir� que existe"),
//		CustomAddState, 
//		NotExpectedThis,
//		ParentBehaviorNull,
		;
		
		private String message;
		private Warn()
		{
			message = this.name();
		}
		private Warn(String msg)		
		{		
			message = msg;
		}

		@Override
		public String getMessage() {			
			return message;		
		}		
	}