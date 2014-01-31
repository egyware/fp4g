package fp4g;
public enum InfoType implements IMessageType
	{	
		//NoValidTestType("NO VALIDO!")
		;
		
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