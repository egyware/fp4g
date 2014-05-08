package fp4g.data;

/**
 * @author Edgardo
 *
 */
public class When extends Line 
{
	public final Expresion condition;
	public final ILine statement;
	public final DeclVar flag;
	
	protected When(Expresion condition, ILine statement, DeclVar flag)
	{
		this.condition = condition;
		this.statement = statement;
		this.flag = flag;
	}

}
