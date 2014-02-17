package fp4g.data.expresion.literals;

import fp4g.data.expresion.Literal;

public class BoolLiteral extends Literal<Boolean> 
{
	public static BoolLiteral TRUE = new BoolLiteral(true);
	public static BoolLiteral FALSE = new BoolLiteral(false);
	
	private final Boolean bool;
	
	public BoolLiteral(Boolean bool)
	{
		this.bool = bool;
	}
	@Override
	public Boolean getValue() 
	{		
		return bool;
	}	
}
