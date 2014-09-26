package fp4g.data.expresion.literals;

import fp4g.data.expresion.Literal;

public class SpecificLiterals extends Literal<SpecificLiterals>
{
	public static final SpecificLiterals GAME  = new SpecificLiterals();
	public static final SpecificLiterals OTHER = new SpecificLiterals();
	public static final SpecificLiterals SELF  = new SpecificLiterals();
	
	private SpecificLiterals()
	{		
	}

	@Override
	public SpecificLiterals getValue() 
	{
		return this;
	}

}
