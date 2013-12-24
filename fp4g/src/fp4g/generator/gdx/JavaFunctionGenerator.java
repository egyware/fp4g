/**
 * 
 */
package fp4g.generator.gdx;

import java.util.HashMap;
import java.util.Map;

import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.exceptions.FunctionGeneratorException;
import fp4g.exceptions.GeneratorException;
import fp4g.generator.FunctionGenerator;
import fp4g.generator.gdx.models.JavaCodeModel;

/**
 * @author Edgardo
 *
 */
public class JavaFunctionGenerator extends FunctionGenerator<JavaGenerator,JavaCodeModel>
{		
	private final Map<String,Function> functions;	
	public JavaFunctionGenerator(JavaGenerator jg)
	{
		super(jg);
		functions = new HashMap<String, Function>(10,1);
		
		functions.put("getSprite" , new GetSprite());
		functions.put("getSound"  , new GetSound());
		functions.put("getMusic"  , new GetMusic());
		functions.put("getTexture", new GetTexture());
		functions.put("createBox", new CreateBox());
		functions.put("createCircle", new CreateCircle());

	}	
	
	private abstract class Function
	{
		public abstract Expresion generate(JavaCodeModel model,ExprList list) throws GeneratorException;
	}
		
	@Override
	public Expresion generate(JavaCodeModel model,FunctionCall fc) throws GeneratorException
	{
		Function fg = functions.get(fc.functionName);
		if(fg != null)
		{
			return fg.generate(model,fc.params);
		}
		throw new FunctionGeneratorException(fc.functionName);
	}
	
	
	private class GetSprite extends Function
	{
		@Override
		public Expresion generate(JavaCodeModel model,ExprList list) throws GeneratorException
		{
			String resourceName = generator.expresion(model,list.get(0));
			model.addImport(String.format("%s.%s",generator.packageName,"Utils"));			
			DirectCode expr = new DirectCode(String.format("Utils.getSprite(%s)",resourceName));						
			return expr;
		}		
	}
	private class GetSound extends Function
	{
		@Override
		public Expresion generate(JavaCodeModel model,ExprList list) throws GeneratorException
		{
			String resourceName = generator.expresion(model,list.get(0));
			model.addImport(String.format("%s.%s",generator.packageName,"Utils"));
			DirectCode expr = new DirectCode(String.format("Utils.getSound(%s)",resourceName));			
			return expr;
		}		
	}
	private class GetTexture extends Function
	{

		@Override
		public Expresion generate(JavaCodeModel model,ExprList list) throws GeneratorException
		{
			String resourceName = generator.expresion(model,list.get(0));
			model.addImport(String.format("%s.%s",generator.packageName,"Utils"));
			DirectCode expr = new DirectCode(String.format("Utils.getTexture(%s)",resourceName));					
			return expr;
		}		
	}
	private class GetMusic extends Function
	{
		@Override
		public Expresion generate(JavaCodeModel model,ExprList list) throws GeneratorException
		{			
			String resourceName = generator.expresion(model,list.get(0));
			model.addImport(String.format("%s.%s",generator.packageName,"Utils"));			
			DirectCode expr = new DirectCode(String.format("Utils.getMusic(%s)",resourceName));					
			return expr;
		}		
	}	

	private class CreateBox extends Function
	{

		@Override
		public Expresion generate(JavaCodeModel model,ExprList list) throws GeneratorException
		{
			model.addImport(String.format("%s.%s",generator.packageName,"Utils"));
			Expresion width  = list.get(0);			
			Expresion height = list.get(1);
			DirectCode expr = new DirectCode(String.format("Utils.createBox(%s,%s)",generator.expresion(model,width),generator.expresion(model,height)));			
			return expr;
		}		
	}
	private class CreateCircle extends Function
	{

		@Override
		public Expresion generate(JavaCodeModel model,ExprList list) throws GeneratorException
		{
			model.addImport(String.format("%s.%s",generator.packageName,"Utils"));
			Expresion ratio = list.get(0);			
			DirectCode expr = new DirectCode(String.format("Utils.createCircle(%s)",generator.expresion(model,ratio)));			
			return expr;
		}		
	}


}
