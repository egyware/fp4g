package fp4g.exceptions;

import fp4g.Log.WarnType;

public class DependResolverNotFoundException extends FP4GRuntimeException 
{

	public DependResolverNotFoundException(int line, String reason) 
	{
		super(WarnType.DependResolverNotFound, line, reason);		
	}
	
	public DependResolverNotFoundException(int line, String reason, Throwable parent) 
	{
		super(WarnType.DependResolverNotFound, line, reason, parent);
		
	}

	private static final long serialVersionUID = 1L;

}
