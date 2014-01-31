package fp4g.exceptions;

import fp4g.log.info.Warn;

public class DependResolverNotFoundException extends FP4GException 
{

	public DependResolverNotFoundException(String reason) 
	{
		super(Warn.DependResolverNotFound, reason);		
	}
	
	public DependResolverNotFoundException(String reason, Throwable parent) 
	{
		super(Warn.DependResolverNotFound, reason, parent);
		
	}

	private static final long serialVersionUID = 1L;

}
