package fp4g.exceptions;

import fp4g.log.FP4GWarn;

public class DependResolverNotFoundException extends FP4GException 
{
	public DependResolverNotFoundException(String reason) 
	{
		super(FP4GWarn.DefineDependResolverNotFound, reason);		
	}
	
	public DependResolverNotFoundException(String reason, Throwable parent) 
	{
		super(FP4GWarn.DefineDependResolverNotFound, reason, parent);
		
	}

	private static final long serialVersionUID = 1L;

}
