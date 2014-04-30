package fp4g.generator.gdx;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.DeclVar;
import fp4g.data.Define;
import fp4g.data.IDefine;
import fp4g.data.NameList;
import fp4g.data.vartypes.BasicType;
import fp4g.data.vartypes.CustomType;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.generator.gdx.models.JavaCodeModel;
import fp4g.generator.gdx.models.ParamCodeModel;
import fp4g.log.info.GeneratorError;



public class JavaParamListBuilder  
{
	private final JavaGenerator generator;
	public JavaParamListBuilder(JavaGenerator generator)
	{
		this.generator = generator;
	}
	
	public List<ParamCodeModel> build(NameList nameList, IDefine current, JavaCodeModel model) 
	throws DependResolverNotFoundException, CannotEvalException
	{
		//lo veo un poco consumidor de recursos, pero bueno...
		List<ParamCodeModel> pair = new LinkedList<ParamCodeModel>();
		for(DeclVar par: nameList)
		{
			//TODO esto debe ir en otro lugar.
			String name;
			if(par.type instanceof BasicType)
			{
				switch((BasicType)par.type)
				{
				case Bool:
					name = "Boolean";
					break;
				case Entity:
					name = "Entity";
					break;
				case Number:
					name = "Number";
					break;
				case String:
					name = "String";
					break;
				case Double:
					name = "double";
					break;
				case Float:
					name = "float";
					break;
				case Integer:
					name = "int";
					break;
				default:
					throw new FP4GRuntimeException(GeneratorError.IllegalState,"Estado no valido del generador");
				}
			}
			else
			{
				CustomType custom = (CustomType)par.type;
				Define define = current.getDefine(custom.name);
				generator.resolveDependency(define).perform(define, model);
				name = custom.name;
			}
			ParamCodeModel param;
			if(par.initValue != null)
			{
				param = new ParamCodeModel(name, par.name,generator.expresion(model, par.initValue));					
			}
			else
			{
				param = new ParamCodeModel(name,par.name);
			}								
			pair.add(param);
		}
		return pair;
	}
	

}
