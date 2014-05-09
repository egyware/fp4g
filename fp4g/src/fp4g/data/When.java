package fp4g.data;

/**
 * @author Edgardo
 *
 */
public class When extends Line 
{
	public final Expresion condition;
	public final Statement statement;
	public final DeclVar flag;
	
	protected When(Expresion condition, Statement statement, DeclVar flag)
	{
		this.condition = condition;
		this.statement = statement;
		this.flag = flag;
	}

}
