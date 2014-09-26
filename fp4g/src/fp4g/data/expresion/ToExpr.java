package fp4g.data.expresion;

import fp4g.data.DefineTypes;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.IValue;
import fp4g.data.define.Manager;
import fp4g.data.expresion.literals.SpecificLiterals;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DefineNotFoundException;

/**
 * Esta clase tiene la finalidad de guardar el receptor y no verifica el destino.
 * El destino se verifica en tiempo de generación.
 * @author Edgardo
 *
 */
public class ToExpr implements Expresion, IValue<ToExpr> 
{
	public static final ToExpr SELF  = new ToExpr("SELF");
	public static final ToExpr OTHER = new ToExpr("OTHER");
	public static final ToExpr GAME  = new ToExpr("GAME");
	
	public final String toReceptor;	
	public ToExpr(final String receptor)
	{
		toReceptor = receptor;
	}
	
	@Override
	public ToExpr getValue() 
	{
		return this;
	}

	@Override
	public IValue<?> eval(IValue<?> value) throws CannotEvalException 
	{
		if(!(value.getValue() instanceof IDefine))
		{
			throw new CannotEvalException(CannotEvalException.Types.IncomplatibleTypes, value, "Se esperaba un define");
		}
		IDefine define = (IDefine) value.getValue();
		//Busqueda de quien envia mensaje.
		//1.- Game
		//2.- Self
		//3.- Other
		//4.- Componente
		//5.- Tag
		//6.- Sistema
		if(this == GAME)
		{
			return SpecificLiterals.GAME;
		}
		if(this == SELF)
		{
			return SpecificLiterals.SELF;
		}
		if(this == OTHER)
		{
			return SpecificLiterals.OTHER;
		}
		//revisar si es un componente		
		if(define.findAddDefineByName(toReceptor) != null)
		{
			//TODO pendiente
			return new DirectCode(String.format("this.%s.",toReceptor));
		}
		try 
		{
			final ILib lib = define.getLibrary();
			return new ManagerExpr((Manager) lib.getDefine(DefineTypes.MANAGER, toReceptor));			
		}
		catch (DefineNotFoundException e) 
		{
		}				
		throw new CannotEvalException(CannotEvalException.Types.CannotEvalExpresion, (Expresion)this, "No se encontró un destino");
	}
}
