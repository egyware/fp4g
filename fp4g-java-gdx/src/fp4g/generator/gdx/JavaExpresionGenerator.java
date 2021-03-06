package fp4g.generator.gdx;

import java.util.HashMap;
import java.util.Map;

import fp4g.core.Expresion;
import fp4g.core.IValue;
import fp4g.data.Add;
import fp4g.data.Container;
import fp4g.data.Define;
import fp4g.data.add.AddAsset;
import fp4g.data.define.Manager;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.ManagerExpr;
import fp4g.data.expresion.UnaryOp;
import fp4g.data.expresion.VarId;
import fp4g.data.expresion.literals.BoolLiteral;
import fp4g.data.expresion.literals.FloatLiteral;
import fp4g.data.expresion.literals.IntegerLiteral;
import fp4g.data.expresion.literals.ObjectLiteral;
import fp4g.data.expresion.literals.SpecificLiterals;
import fp4g.data.expresion.literals.StringLiteral;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.generator.Depend;
import fp4g.generator.ExpresionGenerator;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.log.Log;

/**
 * @author Edgardo
 * @param <T>
 *
 */
public class JavaExpresionGenerator extends ExpresionGenerator<JavaMetaSourceModel, JavaGenerator> 
{
	private final  Map<Class<?>, EG_Expresion> expresions = new HashMap<Class<?>, EG_Expresion>(6,1);
	
	public JavaExpresionGenerator(JavaGenerator generator) {
		super(generator);
		
		final LiteralExprGen litgen = new LiteralExprGen();
		expresions.put(VarId.class, new VarExprGen());
		expresions.put(BoolLiteral.class, litgen);
		expresions.put(FloatLiteral.class, litgen);
		expresions.put(IntegerLiteral.class, litgen);
		expresions.put(ObjectLiteral.class, litgen);
		expresions.put(StringLiteral.class, litgen);
		expresions.put(UnaryOp.class, new UnaryExprGen());
		expresions.put(BinaryOp.class, new BinaryExprGen());
		expresions.put(FunctionCall.class, new FunctionCallExprGen());
		expresions.put(DirectCode.class, new DirectCodeExprGen());
		expresions.put(Define.class, new DefineExprGen());
		expresions.put(SpecificLiterals.class, new SpecificLiteralsGen());
		expresions.put(ManagerExpr.class, new  ManagerExprGen());
		expresions.put(Add.class, new AddGen());
	}
	
	private abstract class EG_Expresion
	{		
		public abstract String expr2string(JavaMetaSourceModel model, Container container, Expresion expr) throws CannotEvalException;
	}
	
	@Override
	public String generate(JavaMetaSourceModel model, Container container, IValue<?> value) throws CannotEvalException 
	{
		//TODO generalmente estos se les evalua y solo contiene el valor.
		//TODO esto es raro, ni yo lo entiendo.
		if(value instanceof Expresion)
		{
			Expresion expr = (Expresion)value;
			Class<?> classType = expr.getClass();
			EG_Expresion eg = expresions.get(classType);
			while(eg == null && classType.getSuperclass() != Object.class)
			{
				classType = classType.getSuperclass();
				eg = expresions.get(classType);
			}		
			if(eg != null)
			{
				return eg.expr2string(model,container,expr);						
			}
		}		
		throw new CannotEvalException(CannotEvalException.Types.NotValidExpresion, value,"No se puede evualuar: ".concat(value.getClass().getSimpleName()));
	}
	
	@Override
	public String generate(JavaMetaSourceModel model, Container container, Expresion expr) throws CannotEvalException
	{		
		Class<?> classType = expr.getClass();
		EG_Expresion eg = expresions.get(classType);
		while(eg == null && classType.getSuperclass() != Object.class)
		{
			classType = classType.getSuperclass();
			eg = expresions.get(classType);
		}
		if(eg != null)
		{
			return eg.expr2string(model,container,expr);			 
		}
		throw new CannotEvalException(CannotEvalException.Types.ExpresionGeneratorNotFound, expr,"No se puede evualuar: ".concat(expr.getClass().getSimpleName()));
	}
	
	private class VarExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaMetaSourceModel model, Container container, Expresion expr) {
			VarId var = (VarId)expr;			
			return var.varName;
		}		
	}
	
	private class LiteralExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaMetaSourceModel model, Container container,Expresion expr) {
			final Literal<?> literal = (Literal<?>)expr;
			final Object value = literal.getValue();
			if(value instanceof String)
			{
				return String.format("\"%s\"",value);
			}
			else if(value instanceof Float)
			{
				return value.toString().concat("f");
			}
			else
			{
				return value.toString();
			}
		}		
	}
	
	private class FunctionCallExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaMetaSourceModel model, Container container, Expresion expr) throws CannotEvalException 
		{			
			Expresion resultExpr = generator.function(model, container,(FunctionCall)expr);
			return generate(model,container,resultExpr);			
		}		
	}
	
	private class DirectCodeExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaMetaSourceModel model, Container container, Expresion expr) {
			DirectCode direct = (DirectCode)expr;			
			return direct.code;
		}		
	}
	
	private class DefineExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaMetaSourceModel model, Container container, Expresion expr) {
			Define define = (Define)expr;
			try 
			{			
				Depend depend = generator.resolveDependency(define);
				depend.perform(define, model);
			} 
			catch (DependResolverNotFoundException e)
			{
				Log.Exception(e, define.getLine());					
			}			
			return define.name;
		}		
	}
	
	private class UnaryExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaMetaSourceModel model, Container container,Expresion expr) throws CannotEvalException
		{
			UnaryOp un = (UnaryOp)expr;
			StringBuilder builder = new StringBuilder();
			switch(un.type)
			{
			case Minus:
				builder.append('-');
				break;
			case Not:
				builder.append('!');
				break;
			default:
				break;				
			}
			builder.append(generate(model,container,un.expr));			
			return builder.toString();
		}		
	}
	
	private class BinaryExprGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaMetaSourceModel model, Container container,Expresion expr) throws CannotEvalException
		{
			BinaryOp bin = (BinaryOp)expr;
			StringBuilder builder = new StringBuilder();
			builder.append(generate(model,container, bin.left));
			switch(bin.type)
			{
			case Add:
				builder.append('+');
				break;
			case Div:
				builder.append('/');
				break;
			case Mult:
				builder.append('*');
				break;
			case Sub:
				builder.append('-');
				break;
			case Equal:
				builder.append("==");
				break;
			case LessThan:
				builder.append('<');
				break;
			case MoreThan:
				builder.append('>');
				break;
			default:
				break;	
							
			}
			builder.append(generate(model, container, bin.right));						
			return builder.toString();
		}		
	}
	
	private static final String empty = new String();
	public class SpecificLiteralsGen extends EG_Expresion
	{		
		@Override
		public String expr2string(JavaMetaSourceModel model, Container container, Expresion expr)
		throws CannotEvalException 
		{
			SpecificLiterals sl = (SpecificLiterals)expr;
			if(SpecificLiterals.GAME == sl)
			{
				return "container.gameManager";
			}
			if(SpecificLiterals.SELF == sl)
			{
				return String.format(String.format("%s.%s",model.getName(),"this"));
			}
			if(SpecificLiterals.OTHER == sl)
			{
				return "container.gameManager";
			}
			throw new CannotEvalException(CannotEvalException.Types.IncomplatibleTypes,expr, "Literal Especifico no valido, estado ilegal del generador");
		}
	}

	public class ManagerExprGen extends EG_Expresion
	{
		
		@Override
		public String expr2string(JavaMetaSourceModel model, Container container, Expresion expr)
		throws CannotEvalException 
		{
			ManagerExpr me = (ManagerExpr) expr;
			String manager = generate(model, container, (Expresion)me.manager);
			return String.format("container.getManager(%s.class)",manager);			
		}

	}
	
	public class AddGen extends EG_Expresion
	{
		@Override
		public String expr2string(JavaMetaSourceModel model, Container container, Expresion expr)
		throws CannotEvalException 
		{
			Add add = (Add)expr;
			if(add instanceof AddAsset)
			{
				AddAsset aa = (AddAsset)add;				
				IValue<?> className = aa.asset.get("className");
				String type = (className != null)?(String)className.getValue():aa.asset.name;
				return String.format("(%s)assets.get(\"%s\")",type,aa.resource);
			}
			return null;
		}

	}

	

}
