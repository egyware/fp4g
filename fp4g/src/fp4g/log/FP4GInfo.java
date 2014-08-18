package fp4g.log;


public enum FP4GInfo implements IMessageType
	{	
		//NoValidTestType("NO VALIDO!")
		;
		
		private String message;
		private FP4GInfo()
		{
			message = this.name();
		}
		private FP4GInfo(String msg)		
		{		
			message = msg;
		}

		@Override
		public String getMessage() {			
			return message;		
		}
	}