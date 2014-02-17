package fp4g.data.expresion.literals;

import fp4g.data.expresion.Literal;

public class ObjectLiteral extends Literal<Object> {
	private final Object value;
	
	public ObjectLiteral(Object value)
	{
		this.value = value;
	}
	
	@Override
	public Object getValue() {
		return value;
	}
}
