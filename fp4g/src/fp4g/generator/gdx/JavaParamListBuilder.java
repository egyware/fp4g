package fp4g.generator.gdx;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.DeclVar;
import fp4g.data.Define;
import fp4g.data.IDefine;
import fp4g.data.NameList;
import fp4g.data.VarType;
import fp4g.data.vartypes.BasicType;
import fp4g.data.vartypes.CustomType;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.exceptions.GeneratorException;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.generator.gdx.models.VarCodeModel;
import fp4g.log.Log;
import fp4g.log.info.GeneratorError;



public class JavaParamListBuilder  
{
	private final JavaGenerator generator;
	public JavaParamListBuilder(JavaGenerator generator)
	{
		this.generator = generator;
	}
	
	public List<VarCodeModel> build(NameList nameList, IDefine current, JavaMetaSourceModel model) 
	throws DependResolverNotFoundException, CannotEvalException
	{
		//lo veo un poco consumidor de recursos, pero bueno...
		List<VarCodeModel> pair = new LinkedList<VarCodeModel>();
		for(DeclVar par: nameList)
		{		
			String name = translateType(par.type,model, current);
			VarCodeModel param;
			if(par.initValue != null)
			{
				param = new VarCodeModel(name, par.name,generator.expresion(model, par.initValue));					
			}
			else
			{
				param = new VarCodeModel(name,par.name);
			}								
			pair.add(param);
		}
		return pair;
	}
	
	public List<VarCodeModel> buildForMessage(NameList nameList, IDefine current, JavaMetaSourceModel model) 
			throws DependResolverNotFoundException, CannotEvalException
			{
				//lo veo un poco consumidor de recursos, pero bueno...
				List<VarCodeModel> pair = new LinkedList<VarCodeModel>();
				for(DeclVar par: nameList)
				{	
					final String name;
					final VarType type = par.type;
					String method = null;
					if(type instanceof BasicType)
					{
						switch((BasicType)type)
						{
							case Number:								
								name = translateType(BasicType.Number,model, current);
								break;
							case Float:
								method = "floatValue";
								name = translateType(BasicType.Number,model, current);
								break;
							case Double:
								method = "doubleValue";
								name = translateType(BasicType.Number,model, current);
								break;
							case Integer:
								method = "intValue";
								name = translateType(BasicType.Number,model, current);
								break;							
							default:
								name = translateType(par.type,model, current);
							break;
						}
					}else
					{
						name = translateType(par.type,model, current);
					}
					
					VarCodeModel param = new VarCodeModel(name,par.name,method);
					pair.add(param);
				}
				return pair;
			}

	public String translateType(VarType type, JavaMetaSourceModel model, IDefine current) 
	throws DependResolverNotFoundException
	{
		String name;
		if(type instanceof BasicType)
		{
			switch((BasicType)type)
			{
			case Bool:
				name = "boolean";
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
				throw new GeneratorException(GeneratorError.IllegalState,"Estado no valido del generador");
			}
		}
		else
		{
			CustomType custom = (CustomType)type;
			try
			{
				Define define = current.getDefine(custom.type, custom.name);
				generator.resolveDependency(define).perform(define, model);
			}
			catch(DefineNotFoundException e)
			{
				Log.Exception(e);
			}
			catch(DependResolverNotFoundException e)
			{
				Log.Exception(e);
			}
			name = custom.name;
		}
		return name;
	}
	

}
