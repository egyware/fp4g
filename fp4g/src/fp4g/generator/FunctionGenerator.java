/**
 * 
 */
package fp4g.generator;

import java.util.HashMap;
import java.util.Map;

import static fp4g.Log.Show;
import fp4g.Log.ErrType;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;

/**
 * @author Edgardo
 *
 */
public abstract class FunctionGenerator {
	private static Map<String,FunctionGenerator> functions = new HashMap<>();
	static
	{
		functions.put("getSprite" , new GetSprite());
		functions.put("getSound"  , new GetSound());
		functions.put("getMusic"  , new GetMusic());
		functions.put("getTexture", new GetTexture());
		functions.put("loadAssets", new LoadAssets());
		functions.put("createBox", new CreateBox());
		functions.put("createCircle", new CreateCircle());
	}
	
	
	/**
	 * A partir de los parametros puestos en el generador, devolverá una expresión.
	 * Tal expresión, será luego convertida en codigo según el generador.
	 * 
	 * @param list
	 * @return
	 */
	protected abstract Expresion generate(ExprList list);
	
	
	public static Expresion generate(FunctionCall fc)
	{
		FunctionGenerator fg = functions.get(fc.functionName);
		if(fg != null)
		{
			return fg.generate(fc.params);
		}
		else
		{
			Show(ErrType.FunctionNotFound,fc.functionName);
		}
		return null;
	}
	
	
	private static class GetSprite extends FunctionGenerator
	{

		@Override
		protected Expresion generate(ExprList list) {
			Expresion resourceName = list.get(0);			
			DirectCode expr = new DirectCode(String.format("Utils.getSprite(%s)",ExpresionGenerator.generate(resourceName)));			
			return expr;
		}		
	}
	private static class GetSound extends FunctionGenerator
	{

		@Override
		protected Expresion generate(ExprList list) {
			Expresion resourceName = list.get(0);			
			DirectCode expr = new DirectCode(String.format("Utils.getSound(%s)",ExpresionGenerator.generate(resourceName)));			
			return expr;
		}		
	}
	private static class GetTexture extends FunctionGenerator
	{

		@Override
		protected Expresion generate(ExprList list) {
			Expresion resourceName = list.get(0);			
			DirectCode expr = new DirectCode(String.format("Utils.getTexture(%s)",ExpresionGenerator.generate(resourceName)));			
			return expr;
		}		
	}
	private static class GetMusic extends FunctionGenerator
	{

		@Override
		protected Expresion generate(ExprList list) {
			Expresion resourceName = list.get(0);			
			DirectCode expr = new DirectCode(String.format("Utils.getMusic(%s)",ExpresionGenerator.generate(resourceName)));			
			return expr;
		}		
	}	
	private static class LoadAssets extends FunctionGenerator
	{

		@Override
		protected Expresion generate(ExprList list) {
			// TODO Auto-generated method stub
			return null;
		}		
	}
	
	private static class CreateBox extends FunctionGenerator
	{

		@Override
		protected Expresion generate(ExprList list) {
			Expresion width  = list.get(0);			
			Expresion height = list.get(1);
			DirectCode expr = new DirectCode(String.format("Utils.createBox(%s)",ExpresionGenerator.generate(width),ExpresionGenerator.generate(height)));			
			return expr;
		}		
	}
	private static class CreateCircle extends FunctionGenerator
	{

		@Override
		protected Expresion generate(ExprList list) {
			Expresion ratio = list.get(0);			
			DirectCode expr = new DirectCode(String.format("Utils.createCircle(%s)",ExpresionGenerator.generate(ratio)));			
			return expr;
		}		
	}


}
