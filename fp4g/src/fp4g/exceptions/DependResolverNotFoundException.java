package fp4g.exceptions;

public class DependResolverNotFoundException extends Exception {

	public DependResolverNotFoundException(String name) 
	{
		super(String.format("No se encontr� un resolvedor de dependencias para: %s", name));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
