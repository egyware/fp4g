package fp4g.data.expresion;

import org.antlr.v4.misc.Utils;

import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.IValue;
import fp4g.data.add.AddMethod;
import fp4g.data.define.Message;
import fp4g.exceptions.CannotEvalException;

public class MessageExpr implements Expresion, IValue<MessageExpr>
{
	public final AddMethod method;
	public final ExprList  exprList;
	public MessageExpr(AddMethod method, ExprList exprList)
	{
		this.method = method;
		this.exprList    = exprList;
	}
	
	@Override
	public IValue<?> eval(IValue<?> value) throws CannotEvalException
	{
		Message msg = method.getMessage();
		
		return new DirectCode(String.format("%1$sMessage.on%2$s%1$s",msg.name, Utils.capitalize(method.name)));		
	}

	@Override
	public MessageExpr getValue()
	{
		return this;
	}

}
