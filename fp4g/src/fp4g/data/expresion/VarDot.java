package fp4g.data.expresion;

/**
 * Esta clase corresponde a la operación Variable.propiedad.
 * @author Edgardo
 *
 */
public class VarDot extends VarId {
	public final VarId property;
	public VarDot(String name,VarId p)
	{
		super(name);
		property = p;
	}	
}
