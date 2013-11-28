package fp4g.data.expresion;

public class ValueLiteral<Type> extends Literal<Type>{
	public final Type value;
	public ValueLiteral(Type value)
	{
		this.value = value;
	}
	@Override
	public Type getValue() {
		return value;
	}	
}
