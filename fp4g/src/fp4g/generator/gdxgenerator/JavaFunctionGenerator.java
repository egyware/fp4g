/**
 * 
 */
package fp4g.generator.gdxgenerator;

import static fp4g.Log.Show;

import java.util.HashMap;
import java.util.Map;

import fp4g.Log.ErrType;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.generator.FunctionGenerator;
import fp4g.generator.models.JavaCodeModel;

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
		functions = new HashMap<>(10,1);
		
		functions.put("getSprite" , new GetSprite());
		functions.put("getSound"  , new GetSound());
		functions.put("getMusic"  , new GetMusic());
		functions.put("getTexture", new GetTexture());
		functions.put("createBox", new CreateBox());
		functions.put("createCircle", new CreateCircle());

	}	
	
	private abstract class Function
	{
		public abstract Expresion generate(JavaCodeModel model,ExprList list);
	}
		
	@Override
	public Expresion generate(JavaCodeModel model,FunctionCall fc)
	{
		Function fg = functions.get(fc.functionName);
		if(fg != null)
		{
			return fg.generate(model,fc.params);
		}
		else
		{
			Show(ErrType.FunctionNotFound,fc.functionName);
		}
		return null;
	}
	
	
	private class GetSprite extends Function
	{
		@Override
		public Expresion generate(JavaCodeModel model,ExprList list)
		{
			String resourceName = generator.expresion(model,list.get(0));
			model.addImport(String.format("%s.%s",generator.packageName,"Utils"));
			//model.depends.addAsset(AssetModel.AssetType.Sprite,resourceName);
			DirectCode expr = new DirectCode(String.format("Utils.getSprite(%s)",resourceName));						
			return expr;
		}		
	}
	private class GetSound extends Function
	{
		@Override
		public Expresion generate(JavaCodeModel model,ExprList list)
		{
			String resourceName = generator.expresion(model,list.get(0));
			model.addImport(String.format("%s.%s",generator.packageName,"Utils"));
			//model.depends.addAsset(AssetModel.AssetType.Sound,resourceName);
			DirectCode expr = new DirectCode(String.format("Utils.getSound(%s)",resourceName));			
			return expr;
		}		
	}
	private class GetTexture extends Function
	{

		@Override
		public Expresion generate(JavaCodeModel model,ExprList list) 
		{
			String resourceName = generator.expresion(model,list.get(0));
			model.addImport(String.format("%s.%s",generator.packageName,"Utils"));
			//model.depends.addAsset(AssetModel.AssetType.Texture,resourceName);			
			DirectCode expr = new DirectCode(String.format("Utils.getTexture(%s)",resourceName));					
			return expr;
		}		
	}
	private class GetMusic extends Function
	{
		@Override
		public Expresion generate(JavaCodeModel model,ExprList list)
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
		public Expresion generate(JavaCodeModel model,ExprList list)
		{
			model.addImport(String.format("%s.%s",generator.packageName,"Utils"));
			Expresion width  = list.get(0);			
			Expresion height = list.get(1);
			DirectCode expr = new DirectCode(String.format("Utils.createBox(%s)",generator.expresion(model,width),generator.expresion(model,height)));			
			return expr;
		}		
	}
	private class CreateCircle extends Function
	{

		@Override
		public Expresion generate(JavaCodeModel model,ExprList list)
		{
			model.addImport(String.format("%s.%s",generator.packageName,"Utils"));
			Expresion ratio = list.get(0);			
			DirectCode expr = new DirectCode(String.format("Utils.createCircle(%s)",generator.expresion(model,ratio)));			
			return expr;
		}		
	}


}
